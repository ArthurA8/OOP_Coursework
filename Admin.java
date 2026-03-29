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
			String table_format = "| %-6s | %-12s | %-10s | %-28s | %-7s | %-5s | %-7s | %-20s |%n";
			System.out.printf(table_format, "ID", "Category", "Type", "Name", "Price", "Stock", "Cost", "Info");
			while (scanner.hasNextLine()) {
				String[] item = scanner.nextLine().split("; ");
				System.out.printf(table_format, item[0], item[1], item[2], item[3], item[4], item[5], item[6], item[7]);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
				
			}
		}

}
