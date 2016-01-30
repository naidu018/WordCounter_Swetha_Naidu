package com.company.operations;

/*
 * A sample class to check the functionality of getwordcount() before rendering to the gui.
 * Input: Accepts a path to the file as input.
 * Output: Returns the count of the number of words in the input file present in the filepath.
 * 
 */
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	 private static final Logger log=Logger.getLogger(Main.class);
	private static Scanner in;

	public static void main(String[] args) throws Exception{
		PropertyConfigurator.configure("log4j.properties");
		String filepath;
		in = new Scanner(System.in);
		System.out.println("Enter the path of file");
		//read the filepath to the variable.
		filepath=in.nextLine();
		log.info("The path of the file has been read from the command line. "+filepath);
		//check for valid extension
		if(filepath!=null&&!(filepath.endsWith(".txt")||filepath.endsWith(".md")))
		{
			
			System.out.println("The entered file extension is not valid. Only txt and md extensions are supported!");
			throw new Exception("The entered file extension is not valid. Only txt and md extensions are supported!");
								
		}
		log.info(" The entered file extension is supported. "+filepath);
		//declare an object of the class WordCounter
		WordCounter words=new WordCounter();
		log.info("An object of class WordCounter has been created");
		//retrieve the count of valid english words using the method.
		System.out.println(words.getwordcount(filepath));
		log.info("The number of valid english words in the file present in the file specified by the user has been retrieved. ");
		
		
}
}