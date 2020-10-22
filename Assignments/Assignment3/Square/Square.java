import java.util.Scanner;

public class Square {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("Enter the size of the sides of a square: ");
		int sides = scan.nextInt();
		
		if (sides < 1)
		{
			sides = 1;
			System.out.println("Invalid input\nUsing default value 1.");
		}
		else if (sides > 20)
		{
			sides = 20;
			System.out.println("Invalid input\nUsing default value 20.");
		}
		
		
		//Top side
		int row = 1;
		while (row <= sides)
		{
			int column = 1;
			
			while (column <= sides)
			{
			
				if (row == 1)
					System.out.print("* ");
				
				else if (row == sides)
					System.out.print("* ");
			
				else if (column == 1)
					System.out.print("* ");
				
				else if (column == sides)
					System.out.print("*");
				
				else
					System.out.print("  ");
				
				column++;
			}
		
			System.out.println();
			row++;
		}
	}
}