/*
The greatest common divisor (GCD) of two integers is the largest integer that evenly divides each of the two numbers. 
Write a method gcd that returns the greatest common divisor of two integers. [Hint: You might want to use Euclid’s algorithm. 
You can find information about it at en.wikipedia.org/wiki/Euclidean_algorithm.] 
Incorporate the method into an application that reads two values from the user and displays the result.
*/

import java.util.Scanner;

public class Divisor{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int num1;
		int num2;
		
		System.out.println("Enter two numbers to find the greatest common divisor: ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		System.out.printf("The GCD is: %d", gcd(num1,num2));
		
	
	}
	
	public static int gcd(int x, int y)
	{
		int mod;
		
		while (y != 0)
		{
			mod = x % y;
			x = y;
			y = mod;
		}
		
		return x;
	}
	
}