import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerCLI {

    public static void run(Scanner consoleInput) {
        System.out.println("CUSTOMER VIEW\n");
        
        int id = Integer.parseInt(Main.usrDetails.get(0));
    	String name = Main.usrDetails.get(1);
    	int houseNum = Integer.parseInt(Main.usrDetails.get(2));
    	String pstCode = Main.usrDetails.get(3);
    	String city = Main.usrDetails.get(4);
    	
    	Customer customerInst = new Customer(id, name, houseNum, pstCode, city, Role.CUSTOMER, new Cart(0, new ArrayList<Product>()));
        
        while (true)  {
        	printCustomerMenu();
        	int selection = Integer.parseInt(consoleInput.nextLine().trim());
        	
        	switch (selection) {
        	
        	case 1:
        		System.out.println("\n");
        		System.out.println("PRODUCT LIST\n");
        		Customer.viewProducts();
        		break;
        		
        	case 2: 
        		System.out.println("\n");
        		System.out.println("ADD TO BASKET\n");
        		System.out.println("Please enter the name of the product to add:");
        		File products = new File ("Stock.txt");
        		try {
        			Scanner scanner = new Scanner(products);
        			String tableFormat = "| %-28s | %-7s | %-5s |%n";
        			System.out.printf(tableFormat, "Name", "Price", "Stock");
        			ArrayList<String[]> itemNames = new ArrayList<String[]>();
        			ArrayList<String> stockDetails = new ArrayList<String>();
        			int index = 0;
        			while (scanner.hasNextLine()) {
        				String currentLine = scanner.nextLine();
        				stockDetails.add(currentLine);
        				String[] itemDetails = currentLine.split("; ");
        				System.out.printf(tableFormat, itemDetails[3], itemDetails[4], itemDetails[5]);
        				itemNames.add(new String[] {itemDetails[3], String.valueOf(index)});
        				index += 1;
        			}
        			String userInput = consoleInput.nextLine();
        			for (int i = 0; i < itemNames.size(); i++) {
        				if (userInput.toLowerCase().equals(itemNames.get(i)[0].toLowerCase())) {
        					for (int j = 0; j < stockDetails.size(); j++) {
        						if (stockDetails.get(j).split("; ")[3].toLowerCase().equals(itemNames.get(i)[0].toLowerCase())) {
        							
        							int field1 = Integer.valueOf(stockDetails.get(j).split("; ")[0]);
        							String field2 = stockDetails.get(j).split("; ")[1];
        							String field3 = stockDetails.get(j).split("; ")[2];
        							String field4 = stockDetails.get(j).split("; ")[3];
        							double field5 = Double.valueOf(stockDetails.get(j).split("; ")[4]);
        							int field6 = Integer.valueOf(stockDetails.get(j).split("; ")[5]);
        							double field7 = Double.valueOf(stockDetails.get(j).split("; ")[6]);
        							
        							if (stockDetails.get(j).split("; ")[1].equals("board game")) {
        								int field8 = Integer.valueOf(stockDetails.get(j).split("; ")[7]);
        								BoardGame selectedProduct = new BoardGame(field1, ProductCategory.BOARDGAME, field4, field7, field6, field5, BoardGameType.valueOf(field3.toUpperCase()), field8);
        								customerInst.addToCart(selectedProduct);
        							}
        							else if (stockDetails.get(j).split("; ")[1].equals("accessory")) {
        								String field8 = stockDetails.get(j).split("; ")[7];
        								Accessories selectedProduct = new Accessories(field1, ProductCategory.ACCESSORY, field4, field7, field6, field5, AccessoryType.valueOf(field3.replace(" ", "_").toUpperCase()), field8);
        								customerInst.addToCart(selectedProduct);
        							}
        						}
        					}
        				}
        			}
        			scanner.close();
        			break;
        			
        		} catch (FileNotFoundException e) {
        			e.printStackTrace();
        		}
        		break;
        	}
        }
    }
    
    private static void printCustomerMenu() {
        System.out.println("PLEASE SELECT ACTION BY INPUTTING THE CORRESPONDING NUMBER (or 0 for logout)");
        System.out.println("1) View all products");
        System.out.println("2) Add product to shopping basket");
        System.out.println("3) View contents of shopping basket");
        System.out.println("4) Purchase items in the basket");
        System.out.println("5) Cancel shopping basket");
        System.out.println("6) Lookup with product ID");
        System.out.println("7) Search/filter based on compatilbility");
        System.out.println("0) Log out");
    }
}