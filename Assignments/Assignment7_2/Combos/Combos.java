/*
3.  Write an application that reads a five-letter word from the user 
and produces every possible three-letter string that can be derived 
from the letters of that word. For example, 
the three-letter words produced from the word "bathe" 
include "ate," "bat," "bet," "tab," "hat," "the" and "tea."
*/

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.util.ArrayList;
import java.util.Scanner;

public class Combos{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> threeLetterWords = new ArrayList<String>();
		
		try {
			File myObj = new File("ThreeLetterWords.txt");
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine())
				threeLetterWords.add(myReader.nextLine());
			
			System.out.println("Enter a five-letter word: ");
			String word = scan.nextLine();
			System.out.println();
			
			System.out.println("Three-letter words made from imput:");
			
			char[] charList = word.toCharArray();
			
			ArrayList<String> combos = new ArrayList<String>();
			
			for (char c1: charList)
			{
				for (char c2: charList)
				{
					for (char c3: charList)
					{
						if (c1 != c2 && c1 != c3 && c2 != c3)
						{
							String tempWord = String.valueOf(c1) + String.valueOf(c2) + String.valueOf(c3);
							
							if (threeLetterWords.contains(tempWord) && !combos.contains(tempWord))
							{
								combos.add(tempWord);
							}
						}
					}
				}
			}
			
			for (String currentWord: combos)
			{
				System.out.println(currentWord);
			}
			
			
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("A reading error occurred.");
			e.printStackTrace();
		}
		
	}
}