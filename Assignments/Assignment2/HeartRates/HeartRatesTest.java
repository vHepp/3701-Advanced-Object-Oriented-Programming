import java.util.Scanner;

public class HeartRatesTest
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String nameFirst, nameLast;
		int month, day, year;
		
		
		System.out.println("Input your first name: ");
		nameFirst = scan.nextLine();
		System.out.println("Input your last name: ");
		nameLast = scan.nextLine();
		
		System.out.println("Input your birth month: ");
		month = scan.nextInt();
		System.out.println("Input your birth day: ");
		day = scan.nextInt();
		System.out.println("Input your birth year: ");
		year = scan.nextInt();
		
		HeartRates person1 = new HeartRates(nameFirst, nameLast, month, day, year);
	}
}