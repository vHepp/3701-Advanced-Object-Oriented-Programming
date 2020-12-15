//1. Write an application that inputs a line of text and outputs the text twice
//	 once in all uppercase letters and once in all lowercase letters.

import java.util.Scanner;

public class CaseSensitive {
	public static void main(String[] args)
{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a line of text: ");
		String input = scan.nextLine();
		
		System.out.printf("\ntext w/ all uppercase letters: %s\n\ntext w/ all lowercase letters: %s", input.toUpperCase(), input.toLowerCase());
		
		
	}
}