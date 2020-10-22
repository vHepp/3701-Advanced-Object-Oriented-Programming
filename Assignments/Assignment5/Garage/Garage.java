/*
A parking garage charges a $2.00 minimum fee to park for up to three hours. 
The garage charges an additional $0.50 per hour for each hour or part thereof in excess of three hours. 
The maximum charge for any given 24-hour period is $10.00. Assume that no car parks for longer than 24 hours at a time. 
Write an application that calculates and displays the parking charges for each customer who parked in the garage yesterday. 
You should enter the hours parked for each customer. 
The program should display the charge for the current customer and should calculate and display the running total of yesterday’s receipts. 
It should use the method calculateCharges to determine the charge for each customer.
*/

import java.util.Scanner;

public class Garage {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of hours, -1 to quit.");
		
		float totalReceipts= 0.0f;
		float hours = scan.nextFloat();
		
		while(hours >= 0.0f)
		{
			float fee = calculateCharges(hours);
			totalReceipts+= fee;
			
			System.out.printf("Current charge: $%.2f, Total receipts: $%.2f\n", fee, totalReceipts);
			
			System.out.println("Enter number of hours, -1 to quit.");
			hours = scan.nextFloat();
			
		}
	}
	
	public static float calculateCharges(float hours)
	{
		
		float charge = 2.0f;
		
		if (hours > 3f)
			charge = 2.0f + .5f * (float)Math.ceil(hours-3f);
		
		if (charge > 10f)
			charge = 10f;
		
		return charge;
		
	}
	
}