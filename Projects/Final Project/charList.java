/*
1

1. Write a program that inserts 30 random letters into a List<Character>. 
Perform the following operations and display your results:

Sort the List in ascending order.
Sort the List in descending order.
Display the List in ascending order with duplicates removed.

*/

import java.util.Random;
import java.util.*; 

public class charList
{
	public static void ascending(List<Character> charList)
	{		
		System.out.print("[");
		for (int i = 0; i < charList.size(); i++){
			System.out.print(charList.get(i));
			if (i != charList.size()-1)
				System.out.print(", ");
			else
				System.out.println("]\n");
		}
	}
	
	public static void descending(List<Character> charList)
	{
		System.out.print("[");
		for (int i = charList.size() - 1; i >= 0; i--){
			System.out.print(charList.get(i));
			if (i != 0)
				System.out.print(", ");
			else
				System.out.println("]\n");
		}
	}
	
	public static void noDuplicates(List<Character> charList)
	{
		
		List<Character> charList2 = new ArrayList<Character>();
		
		for (int i = 0; i < charList.size(); i++)
		{
			if (charList2.indexOf(charList.get(i)) == -1)
			{
				charList2.add(charList.get(i));
			}
		}
		
		Collections.sort(charList2);
		ascending(charList2);
	}
	
	public static void main(String[] args)
	{
		char [] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		List<Character> charList = new ArrayList<Character>();
		Random rand = new Random();
		
		for (int i = 0; i < 30; i++)
		{
			int r = rand.nextInt(26);
			
			charList.add(letters[r]);
		}
		
		Collections.sort(charList);
		
		System.out.println("charList in ascending order: ");
		ascending(charList);
		
		System.out.println("charList in decending order: ");
		descending(charList);
		
		System.out.println("charList in ascending order w/o duplicates: ");
		noDuplicates(charList);
		
	}
}