 public class HeartRates {
	 private String nameFirst;
	 private String nameLast;
	 private int month, day, year;
	 
	 private int cDay = 7, cMonth = 9, cYear = 2020;
	 
	 //default constructor
	 public HeartRates(String nameFirst, String nameLast, int month, int day, int year) {
		 this.nameFirst = nameFirst;
		 this.nameLast = nameLast;
		 this.month = month;
		 this.day = day;
		 this.year = year;
		 
		 System.out.printf("Name: %s %s%nBirthdate: %d/%d/%d%n", nameFirst, nameLast, month, day, year);
		 
		 
		 System.out.printf("Age: %d years%n", findAge());
		 System.out.printf("Maximum Heart Rate: %d%n", maxHeartRate());
		 targetHeartRate();
	 }
	 
	 //findAge (in years)
	 public int findAge() {
		 int age = 0;
		 
		 age+= cYear - year;
		 
		 //month(s) after bday month
		 if (cMonth < month) {
			 age--; 
		 }
		 else if (cMonth == month && cDay < day) {
			 age--;
		 }
		 
		 return age;
	 }
	 
	 //max heartrate
	 public int maxHeartRate() {
		 return 220 - findAge();
	 }
	 
	 //target heartrate
	 public void targetHeartRate() {
		 int low, high;
		 
		 low = (int) (maxHeartRate() * .5);
		 high = (int)(maxHeartRate() * .85);
		 
		 System.out.printf("Target Heart Rate Range: %d %c %d %s", low, '-' , high, "bpm");
	 }
	 
	 //getter methods
	 public String setNameFirst() {
		  return nameFirst;
	 }
		 
	 public String setNameLast() {
		  return nameLast;
	 }
	 
	 public int setMonth() {
		 return month;
	 }
	 
	 public int setDay() {
		 return day;
	 }
	 
	 public int setYear() {
		 return year;
	 }
	
	 //setter methods
	 public void setNameFirst(String nameFirst) {
		  this.nameFirst = nameFirst;
	 }
		 
	 public void setNameLast(String nameLast) {
		  this.nameLast = nameLast;
	 }
	 	 
	 public void setMonth(int month) {
		 this.month = month;
	 }
	 
	 public void setDay(int day) {
		 this.day = day;
	 }
	 
	 public void setYear(int year) {
		 this.year = year;
	 }
	 
 }
 