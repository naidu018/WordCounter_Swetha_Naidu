=========================================
README
=========================================
-AUTHOR:SWETHA NAIDU

*****************************************
Project Introduction:
*****************************************

The main aim of this project is to create a WordCounter class that reads a file from disk and returns the count of words from the file. The filepath is given as input and the word count is retrieved using a method having public int in the signature. A word is defined as boundaried by any type of white space, valid English words, including all forms of contractions and possessives, allowed to contain valid punctuation at the beginning, middle, or end of a word, all other word candidates are skipped (eg. utf­8 characters are not counted). 

The logic that is used is 
" A valid English word can only have punction from this set {, . ; : "  ' ? ! [ { ( ] } ) -}. It can have letters upper or lower-case. But it cannot have numbers.

Among the punctuation, the symbols have some positions, where they can occur. For example: . cannot occur in the middle of a word. , cannot occur in the middle. hyphen only occurs in the middle. These rules are stated as follows

Rules of English Language: 
. : occurs only at the end of a word. If it occurs anywhere else, the word is not counted as valid.
, : occurs only at the end of a word. If it occurs anywhere else, the word is not counted as valid.
; : occurs only at the end of a word. 
: : occurs only at the end.
" : can occur at the beginning or end but cannot occur in the middle.
' : can occur anywhere. For a contractions like 'tis, is'nt , 	his' we can see that apostrophe occurs anywhere. For 	possessions like john's we can see that it occurs in the 	middle.
? :  occurs only at the end. 
! :  occurs only at the end. 
[ :  occurs only at the beginning.
{ :  occurs only at the beginning.
( :  occurs only at the beginning.
] :  occurs only at the ending.
} :  occurs only at the ending.
) :  occurs only at th ending. 
- :  occurs only in the middle.
a-z: alphabets can occur anywhere.
A-Z: whether they are upper-case or lower-case.
0-9: cannot occur anywhere.

other characters:  All other charaacters are invalid. They are remaining ASCII characters and utf-8 characters. So, if any othe r characters are encountered the entire word is not counted as valid.

Hence, words that are having only alphabets and the valid punctuation if they occur in positions where they can occur are counted are valid.

The input is read from a file. The type of file can be text or readme. If the user tries to read from other type of files, an exception will be thrown and he cannot proceed any furthur.


why you tested your word counter the way you did?

	The main class that deals with getting the word count is WordCounter. I have considered a wide variety of test cases for the word . All the test cases have been written in three files. WordCounter_getwordcounttests, WordCounter_gettersettertests, WordCounter_specialcharacterstest. The WordCounter_getwordcounttests has all the possible tests for the getwordcount() method in the WordCounter class. , WordCounter_gettersettertests has all possible tests for getter and setter methods in the WordCounterclass. WordCounter_specialcharacterstest has all possible tests for WordCounter getwordcount()on special characters. All these test cases cover all the possible exceptions that can break the system. 



­why you think your testing is sufficient for your code to be merged?

The tests that I have written are sufficient for the code to be merged because there are tests for each of the specifications mentioned by the user and some additional tests as well. Firstly, after evaluating the questions, the requirements are as follows 

	Reading a file from disk and return the count of words in the file using a method with public int in the signature.The words can be bounded by any number of white spaces, contractions, possessives, valid punctuation at beginning, middle, end, all other utf-8 characters need to be skipped.

In order to accomplish these requirements
1) read a file from disk - file has been read by making a selection in the gui. So, the user can select file from any directory. This is more user-friendly instead of specifing the path which every person cannot do. 

2)A method "public int countwords" in wordCounter class is used to return the number of words in a file.

3) Words can be bounded by any number of spaces - There are several testcases that validated this.

4) contractions, possessives - Three test-cases that are written in WordCounter_specialcharacterstest on symbol validate this.Contractions can have apostrophe anywhere in the word. Possessions are like joh'n. 

5)valid punctuation at beginning, middle, end - Several test cases are written on this.
In addition if the user has timing requirements, a timeout test can also be included.

 comment on additional testing you would consider beyond this JUnit test suite after your code is merged

If the user has timing requirements, a timeout test can also be included.
	
­include the time you spent on the entire exercise

	I have spent around one day on this project.