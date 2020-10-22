import java.util.Scanner;

public class Largest {
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("Enter a number: ");
		int largest = scan.nextInt();
		
		int count = 1;
		
		while (count < 10)
		{	
			System.out.print("Enter a number: ");
			int temp = scan.nextInt();
			
			if (temp > largest)
				largest = temp;
			
			count++;
		}
		
		System.out.print("The largest number is: " + largest);
		
		
	}
}