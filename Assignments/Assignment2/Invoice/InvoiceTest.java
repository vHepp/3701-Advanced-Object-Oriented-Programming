public class InvoiceTest
{
	public static void main(String[] args) 
	{
		Invoice invoice1 = new Invoice("1234", "Hammer", 2, 14.95);
		
		System.out.println("Original invoice information");
		System.out.printf("Part number: %s%n", invoice1.getPartNumber());
		System.out.printf("Description: %s%n", invoice1.getPartDescription());
		System.out.printf("Quantity: %d%n", invoice1.getQuantity());
		System.out.printf("Price: %.2f%n", invoice1.getPricePerItem());
		System.out.printf("Invoice amount: %.2f%n", invoice1.getInvoiceAmount());
		
		//change data
		
		invoice1.setPartNumber("001234");
		invoice1.setPartDescription("Yellow Hammer");
		invoice1.setQuantity(3);
		invoice1.setPricePerItem(19.49);
		
		
		System.out.println("Original invoice information");
		System.out.printf("Part number: %s%n", invoice1.getPartNumber());
		System.out.printf("Description: %s%n", invoice1.getPartDescription());
		System.out.printf("Quantity: %d%n", invoice1.getQuantity());
		System.out.printf("Price: %.2f%n", invoice1.getPricePerItem());
		System.out.printf("Invoice amount: %.2f%n", invoice1.getInvoiceAmount());
		
	}
}