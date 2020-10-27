

public class SalariedEmployee extends Employee  {
   private double weeklySalary;

   // four-argument constructor
   public SalariedEmployee(String first, String last, String ssn, 
      double salary, int month, int day, int year) {
      super(first, last, ssn, month, day, year); // pass to Employee constructor
      setWeeklySalary(salary); // validate and store salary
   }

   // set salary
   public void setWeeklySalary(double salary) {
      weeklySalary = salary < 0.0 ? 0.0 : salary;
   }

   // return salary
   public double getWeeklySalary() {
      return weeklySalary;
   }

   // calculate earnings; implement interface Payable method that was
   // abstract in superclass Employee
   @Override
   public double getPaymentAmount() {
      return getWeeklySalary();
   }

   // return String representation of SalariedEmployee object
   @Override
   public String toString() {
      return String.format("salaried employee: %s\n%s: $%,.2f", 
         super.toString(), "weekly salary", getWeeklySalary());
   }
}

