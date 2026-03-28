import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin extends User {

	public Admin(int userID, String name, int houseNum, String postcode, String city, Role role) {
		super(userID, name, houseNum, postcode, city, role);
	}
	
	public void viewProducts() {
		File stock = new File("Stock.txt");
		try (Scanner scanner = new Scanner(stock)) {
			while (scanner.hasNextLine()) {
				String[] item = scanner.nextLine().split("; ");
				String productName = item[3];
				System.out.println(productName);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
				
			}
		}

}
