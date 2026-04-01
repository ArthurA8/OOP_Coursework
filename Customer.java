import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer extends User {
	
	public Customer(int userID, String name, int houseNum, String postcode, String city, Role role) {
		super(userID, name, houseNum, postcode, city, role);
	}
	
	public static void viewProducts() {
		File products = new File("Stock.txt");
		try {
			Scanner scanner = new Scanner(products);
			while (scanner.hasNextLine()) {
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
