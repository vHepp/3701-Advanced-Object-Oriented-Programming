/*
1. Modify the payroll system of Figs. 10.4–10.9 to include 
private instance variable birthDate in class Employee. 
Use class Date of Fig.8.7 to represent an employee’s birthday. 
Add get methods to class Date. Assume that payroll is 
processed once per month. Create an array of Employee variables 
to store references to the various employee objects. 
In a loop, calculate the payroll for each Employee (polymorphically), 
and add a $100.00 bonus to the person’s payroll amount 
if the current month is the one in which the Employee’s birthday occurs.
*/

public abstract class Employee implements Payable {
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private Date birthday;

   // three-argument constructor
   public Employee(String first, String last, String ssn, int month, int day, int year) {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
	  
	  setBirthday(month, day, year);
   }

   // set first name
   public void setFirstName(String first) {
      firstName = first; // should validate
   }

   // return first name
   public String getFirstName() {
      return firstName;
   }

   // set last name
   public void setLastName(String last) {
      lastName = last; // should validate
   }

   // return last name
   public String getLastName() {
      return lastName;
   }

   // set social security number
   public void setSocialSecurityNumber(String ssn) {
      socialSecurityNumber = ssn; // should validate
   }

   // return social security number
   public String getSocialSecurityNumber() {
      return socialSecurityNumber;
   }
   
   public void setBirthday(int month, int day, int year) {
	   birthday = new Date(month,day,year);
   }
   
   public Date getBirthday() {
	   return birthday;
   }

   // return String representation of Employee object
   @Override
   public String toString() {
      return String.format("%s %s\nsocial security number: %s\nbirthday: %s", 
         getFirstName(), getLastName(), getSocialSecurityNumber(), birthday.toString());
   }

   // Note: We do not implement Payable method getPaymentAmount here so  
   // this class must be declared abstract to avoid a compilation error.
} 


