import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerCLI {
	
	public final static String INVALID = "Invalid input";

    public static void run(Scanner consoleInput) {
        System.out.println("\nCUSTOMER VIEW\n");
        
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
        		System.out.printf("\n");
        		System.out.println("PRODUCT LIST\n");
        		Customer.viewProducts();
        		break;
        		
        	case 2: 
        		System.out.printf("\n");
        		System.out.println("ADD TO CART\n");
        		System.out.println("Please enter the name of the product to add:");
        		String productName = consoleInput.nextLine().trim();
        		customerInst.addToCart(productName);
        		break;
        		
        		
        	case 3:
        		System.out.printf("\n");
        		System.out.println("SHOPPING CART\n");
        		customerInst.viewCart();
        		System.out.printf("\n");
        		break;
        		
        	case 4: 
        		
        		System.out.printf("\n");
        		System.out.println("CHECKOUT\n");
        		System.out.println("For PayPal: Enter 1");
        		System.out.println("For CreditCard: Enter 2");
        		int usrInput = Integer.valueOf(consoleInput.nextLine().trim());
        		
        		if (usrInput == 1) {
        			System.out.printf("\n");
        			System.out.println("Please Enter your Email Address");
        			String email = consoleInput.nextLine().trim();
        			PayPal payPalInst = new PayPal(email);
        			System.out.printf("\n");
        			Receipt receipt = customerInst.completePurchase(payPalInst);
        			System.out.println(receipt.getReceipt());
        		}
        		
        		else {
        			System.out.printf("\n");
        			System.out.println("Please Enter your 6-digit Card Number");
        			String cardNumber = consoleInput.nextLine().trim();
        			System.out.println("Please Enter your 3-digit Security Code");
        			String securityCode = consoleInput.nextLine().trim();
        			try {
        				CreditCard creditCardInst = new CreditCard(cardNumber, securityCode);
        				Receipt receipt = customerInst.completePurchase(creditCardInst);
            			System.out.println(receipt.getReceipt());
        			} catch (IllegalArgumentException e) {
        				System.out.println(e.getMessage());
        			}
        		}
        		
        		try {
					List<String> stock = Files.readAllLines(Paths.get("Stock.txt"));
					
					ArrayList<Product> cartItems = customerInst.getCart().getItems();
					
        			for (int i = 0; i < cartItems.size(); i++) {
        				Product item = cartItems.get(i);
        				for (int j = 0; j < stock.size(); j ++) {
        					if (item.getProductID() == Integer.valueOf(stock.get(j).split("; ")[0])) {
        						String line = stock.get(j);
        						String[] parts = line.split("; ");
        						int newStock = Integer.valueOf(parts[5]) - 1;
        						String update = parts[0] + "; " + parts[1] + "; " + parts[2] + "; " + parts[3] + "; " + parts[4] + "; " + String.valueOf(newStock) + "; " + parts[6] + "; " + parts[7];
        						stock.set(j, update);
        					}
        				}
        			} 
        			
        			Files.write(Paths.get("Stock.txt"), stock);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
        		
        		customerInst.getCart().getItems().clear();		
        		customerInst.getCart().clearTotal();
        		System.out.println("\n");
        		break;
        		
        	case 5:
        		
        		System.out.printf("\n");
        		System.out.println("CANCEL CART");
        		customerInst.cancelCart(consoleInput);
        		break;
        		
        	case 6:
        		
        		System.out.printf("\n");
        		System.out.println("PRODUCT ID SEARCH");
        		System.out.println("Enter a product ID to search for");
        		int productID = Integer.valueOf(consoleInput.nextLine().trim());
        		Customer.fastSearch(productID);
        		System.out.println("\n");
        		break;
        		
        	case 7:
        		
        		System.out.printf("\n");
        		System.out.println("PRODUCT COMPATIBILITY SEARCH");
        		System.out.println("Enter accessory compatibility to search for");
        		String compatability = consoleInput.nextLine().trim();
        		Customer.compatabilitySearch(compatability);
        		System.out.println("\n");
        		break;
        		
        	case 0: 
        		return;
        	
        	default:
    			System.out.println(INVALID);
    			System.out.println();
    		
        	}
        	
        }
    }
    
    private static void printCustomerMenu() {
        System.out.println("PLEASE SELECT ACTION BY INPUTTING THE CORRESPONDING NUMBER (or 0 for logout)");
        System.out.println("1) View all products");
        System.out.println("2) Add product to shopping cart");
        System.out.println("3) View contents of shopping cart");
        System.out.println("4) Purchase items in the cart");
        System.out.println("5) Cancel shopping cart");
        System.out.println("6) Lookup with product ID");
        System.out.println("7) Search/filter based on compatilbility");
        System.out.println("0) Log out");
    }
}