import java.util.Scanner;

public class RectangleTest{
	public static void main(String [] args){
		
		Scanner scan = new Scanner(System.in);
		Rectangle rec = new Rectangle();
		
		int choice = getMenuChoice();
		
		while(choice !=3)
		{
			try{
				
				switch(choice)
				{
					case 1: 
					System.out.print("Enter Length: ");
					rec.setLength(scan.nextFloat());
					break;
					case 2:
					System.out.print("Enter width: ");
					rec.setWidth(scan.nextFloat());
					break;
				}
				System.out.println(rec.toString());
				
			}
			catch (IllegalArgumentException e) {
					System.out.println("Length and Width must be between 0.0 and 20 exclusively\n");
				}
				
			choice = getMenuChoice();
		}
	}
	
	public static int getMenuChoice(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. Set Length\n2. Set Width\n3. Exit");
		
		System.out.print("Choice: ");
		return scan.nextInt();
		
	}
	
}