/*
Standard telephone keypads contain the digits zero through nine. 
The numbers two through nine each have three letters associated with them 
(image below). Many people find it difficult to memorize phone numbers, 
so they use the correspondence between digits and letters to develop 
seven-letter words that correspond to their phone numbers. 
 example, a person whose telephone number is 686-2377 might 
 use the correspondence indicated in the image below to develop 
 the seven-letter word "NUMBERS" Every seven-letter word 
 corresponds to exactly one seven-digit telephone number. 
 A restaurant wishing to increase its takeout business could 
 surely do so with the number 825-3688 (i.e., "TAKEOUT").
 Every seven-letter phone number corresponds to many different 
 seven-letter words, but most of these words represent unrecognizable 
 juxtapositions of letters. It's possible, however, 
 that the owner of a barbershop would be pleased to know that the shop's
 telephone number, 424-7288, corresponds to "HAIRCUT."
 A veterinarian with the phone number 738-2273 would be pleased to know
 that the number corresponds to the letters "PETCARE." 
 An automotive dealership would be pleased to know that the dealership number, 
 639-2277, corresponds to "NEWCARS."

Write a program that, given a seven-digit number, 
uses a Formatter object to write to a file every possible seven-letter word 
combination corresponding to that number. There are 2,187  (3^7)  such combinations. 
Avoid phone numbers with the digits 0 and 1.
*/

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;

import java.util.Scanner;
import java.util.Formatter;

import java.util.ArrayList;

public class Keypads
{
	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		char[][] list = {	{'n', 'n', 'n'}, //0
					{'n', 'n', 'n'}, //1
					{'A', 'B', 'C'}, //2
					{'D', 'E', 'F'}, //3
					{'G', 'H', 'I'},//4
					{'J', 'K', 'L'},//5
					{'M', 'N', 'O'},//6
					{'P', 'R', 'S'},//7
					{'T', 'U', 'V'},//8
					{'W', 'X', 'Y'}	};//9
		
		
		try (Formatter myWriter = new Formatter("SevenLetterWordCombos.txt");)
		{
			
			
			System.out.print("Input a 7-digit phone # w/o 1 and/or 0: ");
			
			String phoneNum = String.valueOf(scan.nextInt());
			
			while (true){
				if (phoneNum.length() != 7)
				{
					System.out.println("Number is not 7 digits long, try again.");
					System.out.print("Input a 7-digit phone # w/o 1 and/or 0: ");
					phoneNum = String.valueOf(scan.nextInt());
				}
				else if (phoneNum.indexOf('1') != -1 || phoneNum.indexOf('0') != -1)
				{
					System.out.println("Number contains 1 and/or 0, try again.");
					System.out.print("Input a 7-digit phone # w/o 1 and/or 0: ");
					phoneNum = String.valueOf(scan.nextInt());
				}
				else
					break;
			}
			
			int num = Integer.parseInt(phoneNum);
			
			
			int num0 = num/1000000;
			int num1 = (num%1000000)/100000;
			int num2 = (num%100000)/10000;
			int num3 = (num%10000)/1000;
			int num4 = (num%1000)/100;
			int num5 = (num%100)/10;
			int num6 = (num%10);
			
			String word = "";
			int count = 0;
			
			for (int r0 = 0; r0 < 3; r0++)
			{
				
				word += list[num0][r0];
				
				for (int r1 = 0; r1 < 3; r1++)
				{
					word += list[num1][r1];
					
					for (int r2 = 0; r2 < 3; r2++)
					{
						word += list[num2][r2];
						
						for (int r3 = 0; r3 < 3; r3++)
						{
							word += list[num3][r3];
					
							for (int r4 = 0; r4 < 3; r4++)
							{
								word += list[num4][r4];
								
								for (int r5 = 0; r5 < 3; r5++)
								{
									word += list[num5][r5];
							
									for (int r6 = 0; r6 < 3; r6++)
									{
										word += list[num6][r6];
										
										myWriter.format("%s%n", word);
										System.out.printf("\nSuccessfully wrote \"%s\" to the file.\n", word);
										count++;
										
										word = word.substring(0,6);
									}
									word = word.substring(0,5);
								}
								word = word.substring(0,4);
							}
							word = word.substring(0,3);
						}
						word = word.substring(0,2);
					}
					word = word.substring(0,1);
				}
				word = "";
			}
			
			myWriter.close();
			
			System.out.printf("\nWriting Complete. Count: %d words" , count);
			
		}
		catch (IOException | NoSuchElementException | IllegalStateException e) {
			System.exit(1);
		}
		
		
		
		
		
	}
}