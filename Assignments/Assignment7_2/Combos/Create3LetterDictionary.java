import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Create3LetterDictionary {
	public static void main(String[] args) {
		
		try {
			int count = 0;
			
			FileWriter myWriter = new FileWriter("ThreeLetterWords.txt");
			File myObj = new File("dictionary.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.length() == 3){
					myWriter.write(data + "\n");
					System.out.println("Successfully wrote to the file.");
				}
			}
			myReader.close();
			myWriter.close();
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println("A reading error occurred.");
			e.printStackTrace();
		}
		
		catch (IOException e) {
			System.out.println("A writing error occurred.");
			e.printStackTrace();
		}
	}
}