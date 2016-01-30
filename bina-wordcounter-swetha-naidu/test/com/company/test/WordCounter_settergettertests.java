package com.company.test;
/*
 * This method is used for testing get and set methods in the WordCounter class. 
 */

import java.io.File;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.company.operations.WordCounter;
import org.apache.log4j.Logger;
public class WordCounter_settergettertests {

	private static WordCounter wordcounter;
	 private static final Logger log=Logger.getLogger(WordCounter_getwordcounttests.class);
	//this method setsup the countwordsinfile.
	@BeforeClass
	public static void setup() throws Exception
	{
		 wordcounter= new WordCounter();
	}
	
	
	@Test
	public void testToSetFilePathInWordCounter() {
		
		String name="swetha.txt";
		log.info("The path of file is in the current project directory swetha.txt");
		//test to set the filepath to the given string.
		wordcounter.setfilepath(name);
		log.info("Trying to set the path of file");
		//test whether the returned path is same as the string.
		Assert.assertTrue(wordcounter.getfilepath().equals(name));
		log.info("The test case passed");
	}
	
	@Test()
	public void testtoSetFileContentInWordCounter() throws Exception {
		//initializes a new file with the given name.
		File file=new File("swiss.txt");
		log.info("A new file has been created in same directory");
		//if the file already exists, the contents are deleted.
		if(file.exists())
			file.delete();
		
		//sets the filepath to given path.
		wordcounter.setfilepath("swiss.txt");
		//sets the content to the file.
		wordcounter.setcontenttofile("hello");
		log.info("Trying to set content to file");
		wordcounter.setfilecontent();
		Assert.assertEquals("hello ",wordcounter.getfilecontent());
		log.info("The test case passed as the retrieved content is same as the passed content");
	}

	@Test
	public void testToSetCountInWordCounter() throws Exception {		
		int count=20;
		//method to set the count attribute in the countwordsinfile class.
		log.info("Trying to set the count variable of WordCounter class");
		wordcounter.setfilepath("sample.txt");
		wordcounter.setcount(20);
		
		Assert.assertTrue(wordcounter.getcount()==count);
		log.info("The test case passed as the content is successfuly set");
	}

	@Test()
	public void testOnNonExistentFileToGetWordCount() throws Exception {
		//hi.txt does not exist in the project directory.
		String file="hi.txt";
		log.info("Trying to test the program on a non existing file");
		wordcounter.getwordcount(file);
				
	}
	
	
	
	@Test(expected=Exception.class)
	public void testOnUnsupportedFileExtensionToGetWordCount() throws Exception 
	{
		//.pdf is not a supported extension. So an exception is thrown and it is expected.
		String file="swetha.pdf";
		log.info("Trying to test the program on an invalid extension");
		wordcounter.getwordcount(file);
		log.info("The test case passes");
	}
	

	@Test(expected=NullPointerException.class)
	public void testWithNullInputToGetWordCount() throws Exception {
		//if we input null to the method, it throws an exception
		log.info("Trying to test the program on an null input");
		wordcounter.getwordcount(null);
		
	}
	
}
