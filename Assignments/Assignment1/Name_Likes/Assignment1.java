import java.util.Scanner;

public class Assignment1 {
    public static void main(String args[]) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter your name:");
        String name = scan.nextLine();
        
        System.out.println("Enter something you like:");
        String x = scan.nextLine();
        
        System.out.println("Enter something else you like:");
        String y = scan.nextLine();
        
        System.out.printf("%s%s%s%s%s%s%s", "Hello, my name is ", name , " and I like ", x, " and ", y, ".");
        
    }
}
