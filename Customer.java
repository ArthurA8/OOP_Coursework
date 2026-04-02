import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
	
	private Cart customerCart;
	
	public Customer(int userID, String name, int houseNum, String postcode, String city, Role role, Cart customerCart) {
		super(userID, name, houseNum, postcode, city, role);
		this.customerCart = customerCart;
	}
	
	public static void viewProducts() {
		File products = new File("Stock.txt");
		try {
			Scanner scanner = new Scanner(products);
			String table_format = "| %-6s | %-12s | %-10s | %-28s | %-7s | %-5s | %-20s |%n";
			System.out.printf(table_format, "ID", "Category", "Type", "Name", "Price", "Stock", "Info");
			while (scanner.hasNextLine()) {
				String[] productFields = scanner.nextLine().split("; ");
				ArrayList<String> product = new ArrayList<String>();
				for (int i=0; i<8; i++) {
					if (i!=6) {
						product.add(productFields[i]);
					}
				}
				System.out.printf(table_format, product.get(0), product.get(1), product.get(2), product.get(3), product.get(4), product.get(5), product.get(6));
				
			scanner.close();
			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void fastSearch(int productID) {
		File products = new File("Stock.txt");
		try {
			Scanner scanner = new Scanner(products);
			while (scanner.hasNextLine()) {
				String[] productFields = scanner.nextLine().split("; ");
				if (Integer.valueOf(productFields[0]) == productID) {
					String table_format = "| %-6s | %-12s | %-10s | %-28s | %-7s | %-5s | %-20s |%n";
					System.out.printf(table_format, "ID", "Category", "Type", "Name", "Price", "Stock", "Info");
					ArrayList<String> product = new ArrayList<String>();
					for (int i=0; i<8; i++) {
						if (i!=6) {
							product.add(productFields[i]);
						}
					}
					System.out.printf(table_format, product.get(0), product.get(1), product.get(2), product.get(3), product.get(4), product.get(5), product.get(6));
					scanner.close();
					return;
				}
			}
			System.out.println("ID: %d does not match any product in stock!");
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void compatabilitySearch(String filter) {
		File products = new File ("Stock.txt");
		try {
			Scanner scanner = new Scanner(products);
			String table_format = "| %-6s | %-12s | %-10s | %-28s | %-7s | %-5s | %-20s |%n";
			System.out.printf(table_format, "ID", "Category", "Type", "Name", "Price", "Stock", "Info");
			while (scanner.hasNextLine()) {
				String[] productFields = scanner.nextLine().split("; ");
				if (productFields[1].equals("accessory")) {
					
				}
			}
		}
	}
	
}
