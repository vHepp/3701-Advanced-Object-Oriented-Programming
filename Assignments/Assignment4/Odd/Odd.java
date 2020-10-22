public class Odd{
	public static void main(String[] args){
		
		int product = 1;
		
		for (int i = 3; i <=15; i+= 2)
		{
			product *= i;
		}
		
		System.out.printf("Product: %d%n", product);
		
	}
}