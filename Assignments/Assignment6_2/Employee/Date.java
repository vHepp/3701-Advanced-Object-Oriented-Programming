public class Date {
	private int month; // 1-12
	private int day; // 1-31 based on month
	private int year; // any year
	
	private static final int [] daysPerMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public Date(int month, int day, int year) {
		if (month <= 0 || month > 12) {
			throw new IllegalArgumentException("month must be 1-12");
		}
		
		if (day <= 0 || (day > daysPerMonth[month] && (month != 2 && day == 29))){
			throw new IllegalArgumentException("day out-of-range for the specified month and year");
		}
		
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
			throw new IllegalArgumentException("day out-of-range for the specified month and year");
		}
		
		this.month = month;
		this.day = day;
		this.year = year;
		
		//System.out.printf("Data object constructor for date %s%n", this);
	}
	
	public int getMonth()	{ return month; }
	
	public int getDay() 	{ return day; }
	
	public int getYear()	{ return year; }
	
	public int getDaysOfMonth(int month){
		return daysPerMonth[month];
	}
	
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	}
}