package com.company.operations;

/*
 * This class is used for counting the number of words in a file. 
 * Input: a string representing filepath. Example: C:\Users\Desktop\swetha.txt
 * Output: an integer representing number of words in the file. Example: 50
 * The main method to get the count of words is getwordcount(). 
 * It returns an integer representing the number of words in the file.
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class WordCounter {
	private static final Logger log=Logger.getLogger(WordCounter.class);
	private String filepath; // this string represents the file. Example : C:\Users\Desktop\test.txt
	private int count; // an integer representing the number of words in the file.
	private String filecontent=""; // a string representing the content in the file.

	/**
	 * a constructor for the class that accepts the filename as parameter.
	 */
	
	
	public WordCounter(String filepath)
	{
		PropertyConfigurator.configure("log4j.properties");
		count=0;
		this.filepath=filepath;
		log.info("The WordCounter object has been created succesfuly");
	}

	/**
	 * a default-constructor
	 */
	
	
	public WordCounter() throws Exception
	{
		PropertyConfigurator.configure("log4j.properties");
		//if the user tries to create an object with an invalid file extension, it throws this exception.
		if(filepath!=null&&!(filepath.endsWith(".txt")||filepath.endsWith(".md")))
		{
			log.error("There is an error in the file input!");
			throw new Exception("Please enter a valid format. txt or md.");
			
		}
		count=0;
		filepath=null;
		log.info("The WordCounter object has been created succesfully");
	}
	/**
	 * getter method of the private variable count.
	 * Output: returns the count of the number of words in the file.
	 */
	
	
	
	public int getcount() throws Exception 
	{
		if(!(filepath.endsWith(".txt")||filepath.endsWith(".md")))
		{
			log.error("The entered file format is invalid");
			throw new Exception("Please enter a valid format. txt or md.");
			
		}
		return count;
	}
	/**
	 * Setter method for setting variable count.
	 */
	
	
	public void setcount(int count) {
		this.count = count;
		log.info("The private variable count has been set succesfully");
	}
	/**
	 * Getter method for the private  variable  filepath
	 */
	
	
	public String getfilepath() {
		return filepath;
	}
	
	/**
	 * method to set the filepath. 
	 * This method accepts the string representing filepath. 
	 */
	
	
	public void setfilepath(String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * method to append the content to the file. 
	 * input: string representing the content to be added to the file
	 */
	
	public void setcontenttofile(String content) 
	{
		try 
		{
			//Here true is to append the content to file
			FileWriter filewriter;
			filewriter = new FileWriter(filepath,true);
			//BufferedWriter writer give better performance
	    	BufferedWriter bw = new BufferedWriter(filewriter);
	    	bw.write(content);
	    	bw.flush();
	    	bw.close();
		}
		catch (Exception e) {
			log.error(" Exceptions happen!   "+e);		
			e.printStackTrace();
		}
		
	}

	/**
	 * Getter method for the private variable filecontent. 
	 * Output: returns the filecontent.
	 */
	
	
	public String getfilecontent()
	{
		return filecontent;
	}
	
	/**
	 * Setter method for setting the filecontent. 
	 * this method reads the content from the file in the specified filepath into the filecontent variable.
	 */
	
	
	public void setfilecontent() throws IOException
	{
		try
		{
			//filereader and buffered reader together are used for reading the content from the file and they give better performance.
			FileReader filereader=new FileReader(filepath);
			BufferedReader bufferedreader=new BufferedReader(filereader);
			//line represents the string that is read from the file.
			String line=bufferedreader.readLine();
			filecontent=new String();
			while(line!=null){
				//the line read from the file is appended to a space and added to the filecontent variable.
				filecontent+=line+" ";
				//line represents the line read from the file.
				line=bufferedreader.readLine();
			}
			log.info("The content has been succesfuly read from the file into the filecontent variable of wordcounter");
			bufferedreader.close();
		}
		catch(Exception e){
			log.error(" Exceptions happen!   "+e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * returns the count of the number of words in the file present in the given filepath.
	 */
	
	public int getwordcount(String filepath) throws Exception
	{
		//throws an exception when the file does not end with valid extension.
		if(!(filepath.endsWith(".txt")||filepath.endsWith(".md")))
		{
			log.error("Entered format is invalid! ");
			throw new Exception("Please enter a valid format. txt or md.");
			
		}
		
		//to set the filepath variable of the class.
		setfilepath(filepath);
		//to set the content from the file into the filecontent variable.
		setfilecontent();
		count=0;
		int index=0;
		//the content is split for every occurrence of a space.
		String array[]=filecontent.split("\\s+");
		log.info("The words in the file are extracted");
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[i].length();j++)
			{
				index=0;
				//caracter at every index
				char c=array[i].charAt(j);
				//represents the length of each word.
				int length=array[i].length();
				//switch statement for each character. According to the rules of English language, each character is evaluated and then a decision is taken whether the word is valid or invalid.
				switch(c)
				{
					case ',': case '!': case '?': case ';': case '.': case ':': if(j!=length-1||length==1) index=1;break;//according to rules of english language, the punctuation symbols . , ? ! ; always occur at the end of a statement. So, if in the current word, these symbols occur at any position other than last, the word is counted as invalid.
					case '"': if((j>0&&j<length-1)||length==1) index=1; break;// according to rules of english language, " can occur at beginning or end but not in the middle. So, if in the current word, if the quotation occurs at any position other than beginning or end, the word is not counted as valid.
					case '\'': if(length==1) index=1;break;//according to the rules of english language, ' can occur anywhere. If the word is contraction or possession, the apostrophe can occur at either beginning or middle or end.
					case '-': if(j==0||j==length-1||length==1) index=1;  break;//according to the rules of english language, only in the middle. So, if in the current word, if the hyphen occurs at either the beginning or end, the word is skipped.
					case '(': case '[': case '{': if(j!=0||length==1) index=1;break;//according to the rules of english language, {, [, ( can only occur at the beginning only. So, if in the current word, any of these characters occur anywhere other than beginning, the word is not counted as valid. index is set to 1. If, the index is 1, the word is not counted as valid. 
					case ')': case ']': case '}': if(j!=length-1||length==1) index=1; break;//according to the rules of english language, {, [, ( can only occur at the ending only. So, if in the current word, any of these characters occur anywhere other than ending, the word is not counted as valid. index is set to 1. If, the index is 1, the word is not counted as valid.
					//if the character is a letter, then there is no change to the count.
					case 'a': case 'A': case 'b': case 'B': case 'c': case 'C': case 'd':case 'D': case 'e':case 'E': case 'f': case 'F': case 'g': case 'G': case 'h': case 'H': case 'i': case 'I': case 'j': case 'J': case 'k': case 'K': case 'l': case 'L': case 'm': case 'M': case 'n': case 'N': case 'o': case 'O': case 'p': case 'P': case 'q': case 'Q': case 'r': case 'R': case 's': case 'S': case 't': case 'T': case 'u': case 'U': case 'v': case 'V': case 'w': case 'W': case 'X': case 'y': case 'Y': case 'z': case 'Z': break;
					//if the current character is a number, then index is set to 1 and the word is not valid.
					case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': index=1; break;
					//if the current character is any other character, then index is set to 1 and the word is not counted as valid. 
					default: index=1; break;
				}
			//index is set to 1 whenever a character is encountered that is invalid. The word is not counted as valid.
			if(index==1)
				break;
			}
			//if index is 0 then the word is valid and count is incremented. The word is counted as valid.
			if(index==0&&array[i].length()>0)
				count++;
		}
		log.info("The count of the valid english words in the file is "+count);
		//finally the count is returned.
		return count;
}
}

