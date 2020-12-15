/*
2. Write an application that encodes English-language phrases into pig Latin. 
Pig Latin is a form of coded language. 
There are many different ways to form pig Latin phrases.
For simplicity, use the following algorithm:

To form a pig Latin phrase from an English-language phrase, 
tokenize the phrase into words with String method split. 
To translate each English word into a pig Latin word,
place the first letter of the English word at the end of the word 
and add the letters "ay." Thus, the word "jump" becomes "umpjay," 
the word "the" becomes "hetay," and the word "computer" becomes "omputercay." 
Blanks between words remain as blanks. Assume the following: 
The English phrase consists of words separated by blanks, 
there are no punctuation marks and all words have two or more letters.
Method printLatinWord should display each word. 
Each token is passed to method printLatin-Word to print the pig Latin word.
*/

import java.util.Scanner;


public class PigLatin{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter an phrase to convert to Pig Latin: ");
		String phrase = scan.nextLine();
		
		String[] tokens = phrase.split(" ");
		
		System.out.println("Each word after split:");
		for (String word: tokens)
		{
			System.out.println(word);
		}
		
		System.out.println("\nEach word in pigLatin:");
		for (String word: tokens)
		{
			printLatinWord(word);
		}
		
	}
	
	public static void printLatinWord(String word)
	{
		char firstChar = word.charAt(0);
		
		System.out.println(word.substring(1, word.length()) + firstChar + "ay");
	}
	
	
	
}