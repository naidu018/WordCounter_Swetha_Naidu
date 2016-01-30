package com.company.test;
/* This class is used for testing the getwordcount() in WordCounter on the special characters. 
 * All the test cases represent the various kinds of expected outputs for special characters. 
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import com.company.operations.WordCounter;

public class WordCounter_specialcharacterstest {

	private static WordCounter wordcounter;
	 private static final Logger log=Logger.getLogger(WordCounter_getwordcounttests.class);
	//this method is called once for every test-case.
	@BeforeClass
	public static void setup() throws Exception
	{
		 wordcounter=new WordCounter();
	}
	
	@Test
	public void testForSingleComma() throws Exception {
		//Initialize a new file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		
		try
		{
			//printwriter overwrites the content in the file
			PrintWriter output=new PrintWriter(file);
			output.println(",");
			log.info("A string ',' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForCommaAtBeginning() throws Exception {
		//Initialize a new file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//printwriter overwrites the content.
			PrintWriter output=new PrintWriter(file);
			output.println(",hello");
			log.info("A string ',hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForCommaInMiddle() throws Exception {
		//Initialize a new file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
			
		try
		{
			//to overwrite the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hell,o");
			log.info("A string 'hell,o' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForCommaAtEnd() throws Exception {
		//Initializes a new file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		
		try
		{
			//printwriter overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hello,");
			log.info("A string 'hello,' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSinglePeriod() throws Exception {
		//Initilaizes a new file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		
		try
		{
			//printwriter overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println(".");
			log.info("A string '.' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForPeriodAtBeginning() throws Exception {
		//initializes the file with the given name
		File file=new File("sample.txt");
		log.info("A new file has been created ");
				
		try
		{
			//printwriter overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println(".hello");
			log.info("A string '.hello' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForPeriodInMiddle() throws Exception {
		//initialize a file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			//printwriter overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hell.o");
			log.info("A string 'hell.o' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForPeriodAtEnd() throws Exception {
		//initializes a file with the given name
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			//printwriter overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hello.");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleQuestionMark() throws Exception {
		//initializes a file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
			
		try
		{
			PrintWriter output=new PrintWriter(file);
			//single question mark.
			output.println("?");
			log.info("A string '?' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForQuestionMarkAtBeginning() throws Exception {
		//initializes a file with given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			//printwriter overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			//question mark in the beginning.
			output.println("?hello");
			log.info("A string '?hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForQuestionMarkInMiddle() throws Exception {
		//initializes a new file with new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//printwriter overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hell?o");
			log.info("A string 'hell?o' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForQuestionMarkAtEnd() throws Exception {
		//initializes the file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			//overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hello?");
			log.info("A string 'hello?' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleExclamation() throws Exception {
		//initializes a file with the new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			PrintWriter output=new PrintWriter(file);
			//single exclamation
			output.println("!");
			log.info("A string '!' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForExclamationInMiddle() throws Exception {
		//initializes a file with new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
			
		try
		{
			//overwrites the content in the file
			PrintWriter output=new PrintWriter(file);
			output.println("hell!o");
			log.info("A string 'hell!o' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForExclamationAtEnd() throws Exception {
		//initializes a new file with new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//exclamation at the end.
			output.println("hello!");
			log.info("A string 'hello!' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleSemicolon() throws Exception {
		//initializes a file with the new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//overwrites the content in file.
			PrintWriter output=new PrintWriter(file);
			output.println(";");
			log.info("A string ';' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSemiColonAtBeginning() throws Exception {
		//initializes a file with the new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println(";hello");
			log.info("A string ';hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSemiColonInMiddle() throws Exception {
		//file indicates a new file.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hell;o");
			log.info("A string 'hell;o' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSemiColonAtEnd() throws Exception {
		//creates a file with new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			//overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("hello;");
			log.info("A string 'hello;' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleQuotation() throws Exception {
		//initializes a file with new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			//overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("\"");
			log.info("A string '\"' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForQuotationAtBeginning() throws Exception {
		//initializes a file with new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//overwrites the content in the file.
			PrintWriter output=new PrintWriter(file);
			output.println("\"hello");
			log.info("A string '\"hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForQuotationInMiddle() throws Exception {
		//initializes a new file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//the quotation mark in the middle.
			output.println("hell\"o");
			log.info("A string 'hell\"o' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForQuotationAtEnd() throws Exception {
		//initialize a file with the given name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//overwrites the file contents.
			PrintWriter output=new PrintWriter(file);
			output.println("hello\"");
			log.info("A string 'hello\"' has been written to file");
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleApostrophe() throws Exception {
		//file initializes a new file.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			//overwrites the file contents.
			PrintWriter output=new PrintWriter(file);
			output.println("'");
			log.info("A string '\'' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForApostropheAtBeginning() throws Exception {
		//initializes a new file.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//apostrophe in the beginning.
			output.println("'hello");
			log.info("A string '\'hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForApostropheInMiddle() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		try
		{
			PrintWriter output=new PrintWriter(file);
			output.println("hell'o");
			log.info("A string 'hell'o' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForApostropheAtEnd() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			output.println("hello'");
			log.info("A string 'hello'' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleHyphen() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			output.println("-");
			log.info("A string '-' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForHyphenInMiddle() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//valid according to english language rules.
			output.println("hell-o");
			log.info("A string 'hell-o' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 1");
		Assert.assertEquals(1,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForHyphenAtEnd() throws Exception {
		//initialize a file with new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//hyphen at the end
			output.println("hello-");
			log.info("A string 'hello-' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForHyphenAtBeginning() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//hyphen at beginning
			output.println("-hello");
			log.info("A string '-hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleNumber() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//single digit.
			output.println("1");
			log.info("A string '1' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForNumberAtBeginning() throws Exception {
		//initialize a new file with the new name.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//number at beginning
			output.println("1hello");
			log.info("A string '1hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForNumberInMiddle() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//number in th middle.
			output.println("hell9o");
			log.info("A string 'hell9o' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForNumberAtEnd() throws Exception {
		//new file.
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//number at end.
			output.println("hello9");
			log.info("A string 'hello9' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleInvalidPunctuation() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//single ampersand. invalid.
			output.println("&");
			log.info("A string '&' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForInvalidPunctuationAtBeginning() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//ampersand at the beginning. file is invalid.
			output.println("&hello");
			log.info("A string '&hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForInvalidPunctuationInMiddle() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//ampersand in the middle.
			output.println("hell&o");
			log.info("A string 'hell&o' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForInvalidPunctuationAtEnd() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//invalid 
			output.println("hello&");
			log.info("A string 'hello&' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForSingleInvalidPunctuationSymbol() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//# is not a valid english punctutaiton
			output.println("#");
			log.info("A string '#' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForInvalidPunctuationSymbolAtBeginning() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//# at the beginning makes invalid.
			output.println("#hello");
			log.info("A string '#hello' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForInvalidPunctuationSymbolInMiddle() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			//# in the middle makes the word invalid.
			output.println("hell#o");
			log.info("A string 'hell#o' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
	@Test
	public void testForInvalidPunctuationSymbolAtEnd() throws Exception {
		
		File file=new File("sample.txt");
		log.info("A new file has been created ");
		
		try
		{
			PrintWriter output=new PrintWriter(file);
			output.println("hello#");
			log.info("A string 'hello#' has been written to file");
			output.close();
		}
		catch(IOException ex){
			System.out.println("error");
		}
		log.info("The number of valid english words in the file is expected to be 0");
		Assert.assertEquals(0,wordcounter.getwordcount("sample.txt"));
		log.info("Test case has passed");
	}
	
}
