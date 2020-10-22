import java.util.Scanner;

public class Sales{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		double total = 0;
		
		System.out.println("Enter product number (1-5 or 0 to STOP): ");
		int productID = scan.nextInt();
		
		while (productID != 0)
		{
			if (productID >= 1 && productID <= 5)
			{
				System.out.println("Enter the quantity: ");
				int quantity = scan.nextInt();
				
				switch(productID){
					case 1:
					total += quantity * 2.98;
					break;
					
					case 2:
					total += quantity * 4.50;
					break;
					
					case 3:
					total += quantity * 9.98;
					break;
					
					case 4:
					total += quantity * 4.49;
					break;
					
					case 5:
					total += quantity * 6.87;
					break;
				}
			}
			else if(productID != 0)
			{
				System.out.print("Invalid product number. ");
			}
			
			System.out.println("Enter product number (1-5 or 0 to stop): ");
			productID = scan.nextInt();
		}
		
		System.out.printf("\nTotal retail value of all products sold is $%.2f.%n",total);
		
		
		
		
	}
}



/*
An online retailer sells five products whose retail prices are as follows: 
Product 1, $2.98; 
product 2, $4.50; 
product 3, $9.98; 
product 4, $4.49 and 
product 5, $6.87. 
Write an application that reads a series of pairs of numbers as follows:
product number
quantity sold
Your program should use a switch statement to determine the retail price for each product. 
It should calculate and display the total retail value of all products sold. 
Use a sentinel-controlled loop to determine when the program should stop looping and display the final results.



*/