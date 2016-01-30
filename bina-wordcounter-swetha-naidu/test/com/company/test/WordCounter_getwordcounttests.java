package com.company.test;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.company.operations.WordCounter;
import org.apache.log4j.Logger;

/*
 * This class writes various tests on the getwordcount() in the WordCounter class.
 */

public class WordCounter_getwordcounttests {
	   private static WordCounter wordcounter;
	   private static final Logger log=Logger.getLogger(WordCounter_getwordcounttests.class);
	    //This method is called first.
		@BeforeClass
		public static void setup() throws Exception
		{
			 wordcounter=new WordCounter();
		}
		
		@Test()
		public void testOnCustomFileToGetWordCount() throws Exception {
			//initializes a new file with given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			try
			{
				//overwrites the content in the file.
				PrintWriter output=new PrintWriter(file);
				output.println("swetha is a good girl");
				log.info("A string 'swetha is a good girl' has been written to file ");
				output.close();
			}
			catch(IOException ex)
			{
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 4");
			Assert.assertEquals(5, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnEmptyFileToGetWordCount() throws Exception{
			//initializes a new file with the given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			
			try
			{
				//overwrites the content in the file.
				PrintWriter output=new PrintWriter(file);
				//empty file.
				output.println("");
				log.info("Nothing has been written to file ");
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 0");
			Assert.assertEquals(0, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnSingleSpaceToGetWordCount() throws Exception{
			//initializes a file with the given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
		
			try
			{
				//overwrites the content in the file with the given name.
				PrintWriter output=new PrintWriter(file);
				//single space input.
				output.println(" ");
				log.info("A space ' ' has been written to file ");
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 0");
			Assert.assertEquals(0, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnSpacesToGetWordCount() throws Exception{
			//initializes a new file with the given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
		
			try
			{
				//overwrites the content in the file.
				PrintWriter output=new PrintWriter(file);
				output.println("    good orning   ");
				log.info("A string '    good orning   ' has been written to file ");
				output.close();
			}
			catch(IOException ex)
			{
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 2");
			Assert.assertEquals(2, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void TestOnMultipleSpacesToGetWordCount() throws Exception
		{
			//initializes a new file with the given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			try
			{
				//overwrites the content in the file .
				PrintWriter output=new PrintWriter(file);
				//input has multiple spaces.
				output.println("   string   is       good  ");
				log.info("A string '   string   is       good  ' has been written to file ");
				
				output.close();
			}
			catch(IOException ex)
			{
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 2");
			Assert.assertEquals(3, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnContractionsToGetWordCount() throws Exception{
			//initilaizes a new file with the given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			try
			{
				//overwrites the content in the file with the given string.
				PrintWriter output=new PrintWriter(file);
				output.println("   string   is'nt       good   ");
				log.info("A string '   string   is'nt       good   ' has been written to file ");
				
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 3");
			Assert.assertEquals(3, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnPossessivesToGetWordCount() throws Exception{
			//creates  a new file with the given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			try
			{
				//overwrites the content in the file with the given name.
				PrintWriter output=new PrintWriter(file);
				output.println("   John's   input is      good   ");
				log.info("A string '   John's   input is      good   ' has been written to file ");
				
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 4");
			Assert.assertEquals(4, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnPunctuationToGetWordCount() throws Exception{
			//initializes a new file with given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			try
			{
				//overwrites the content in the file.
				PrintWriter output=new PrintWriter(file);
				//words bounded with punctuation
				output.println("   John   input is      good!   ");
				log.info("A string '   John   input is      good!   ' has been written to file ");
				
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 4");
			Assert.assertEquals(4, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnSymbolsToGetWordCount() throws Exception{
			//creates a new file with given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			
			try
			{
				//overwrites the content in the file with the given file.
				PrintWriter output=new PrintWriter(file);
				output.println("hello hai hello hai bye bye, .  ./''' ././. '';';';  v hei, is'nt his john's clothes are washed though'ly is'ni it! ");
				log.info("A string 'hello hai hello hai bye bye, .  ./''' ././. '';';';  v hei, is'nt his john's clothes are washed though'ly is'ni it! ' has been written to file ");
				
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 17");
			Assert.assertEquals(17, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnPunctuationAtBeginningToGetWordCount() throws Exception{
			//creates a new file with the given name.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			
			try
			{
				//test with valid punctuation at the beginning.
				PrintWriter output=new PrintWriter(file);
				output.println("'its \"john ");
				log.info("A string 'its \"john' has been written to file");
				
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 2");
			Assert.assertEquals(2, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnPunctuationInMiddleToGetWordCount() throws Exception{
			//initializes a new file.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			
			try
			{
				PrintWriter output=new PrintWriter(file);
				//hyphen in the middle.
				output.println(" set-wet co-operate ");
				log.info("A string ' set-wet co-operate ' has been written to file");
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 2");
			Assert.assertEquals(2, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnPunctuationAtEndToGetWordCount() throws Exception{
			//creates a new file.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			
			try
			{
				//overwrites the file content 
				PrintWriter output=new PrintWriter(file);
				//test for valid punctuation at the end.
				output.println(" good, nice! well done. ");
				log.info("A string ' good, nice! well done. ' has been written to file");
				
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 4");			
			Assert.assertEquals(4, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
		
		@Test()
		public void testOnSpacesAtBeginningToGetWordCount() throws Exception{
			//create a new file.
			File file=new File("sample.txt");
			log.info("A new file with name sample.txt has been created");
			
			try
			{
				PrintWriter output=new PrintWriter(file);
				//test on words with spaces.
				output.println(" goo      doooooo ");
				log.info("A string ' goo      doooooo ' has been written to file");
				
				output.close();
			}
			catch(IOException ex){
				System.out.println("error");
			}
			log.info("The expected number of words in the given string is 2");	
			Assert.assertEquals(2, wordcounter.getwordcount("sample.txt"));
			log.info("The test case passed");
		}
}
