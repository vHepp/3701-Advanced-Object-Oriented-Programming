

public class EmployeeBirthDayTest  {
   public static void main(String[] args) {
      // create four-element Employee array
      Employee[] employees = new Employee[4];
	  
	  Date currentDate = new Date(10,1,2020);
      
	  double birthdayBonus = 100;
	  
      // populate array with objects that implement Employee
      employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, 1,1,1984);
      employees[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, 4,30,1991);
      employees[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06, 12, 27, 2000);
      employees[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300, 10, 23, 2002);
	  
	  int daysOfMonth = currentDate.getDaysOfMonth(currentDate.getMonth());
	  
	  System.out.printf("\nDays in month %d: %d\n\n", currentDate.getMonth(), daysOfMonth);
      System.out.println("Employees processed polymorphically:\n");

      // generically process each element in array employees
      for (Employee currentEmployee : employees) {
		  
		  System.out.println("////////////////////////////////////\n"); 
		  
         // output currentEmployee and its appropriate payment amount
         System.out.printf("%s \n", currentEmployee.toString());
		 
		 double monthlyPayment = (currentEmployee.getPaymentAmount()/((double)7)) * 
			 ((double)daysOfMonth);
			 
			 System.out.printf("%s: $%,.2f\n", "monthly payment", monthlyPayment); 
		 
		 
         if (currentEmployee.getBirthday().getMonth() == currentDate.getMonth()) {
			 
            System.out.printf("Happy birthday! Heres a bonus: $%,.2f\n", birthdayBonus);
			
			double newPayment = 
				monthlyPayment + birthdayBonus;
			
			System.out.printf("\n%s: $%,.2f\n\n",
            "payment due", newPayment); 
         }
		 else
			System.out.printf("\n%s: $%,.2f\n\n",
            "payment due", monthlyPayment);
      }
   }
}