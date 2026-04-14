import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
	private double cartTotal;
	private ArrayList<Product> cartItems;
	
	public Cart(double cartTotal, ArrayList<Product> cartItems) {
		this.cartTotal = cartTotal;
		this.cartItems = cartItems;
	}
	
	public void addItem(String name) {
		
		try {
			List<String> stock = Files.readAllLines(Paths.get("Stock.txt"));
			for (int i = 0; i < stock.size(); i++) {
				
				int productID = Integer.valueOf(stock.get(i).split("; ")[0].trim());
				String productType = stock.get(i).split("; ")[1].trim();
				String productName = stock.get(i).split("; ")[3].trim();
				double productPrice = Double.valueOf(stock.get(i).split("; ")[4].trim());
				int productStock = Integer.valueOf(stock.get(i).split("; ")[5].trim());
				double productCost = Double.valueOf(stock.get(i).split("; ")[6].trim());
				
				if (productName.toLowerCase().equals(name.toLowerCase().trim())) {
					
					if (productStock == 0) {
						System.out.printf("Sorry, %s is out of stock!\n", productName);
					}
					
					else if (productType.equals("board game")) {
						BoardGameType boardGameType = BoardGameType.valueOf(stock.get(i).split("; ")[2].trim().toUpperCase());
						int numPlayers = Integer.valueOf(stock.get(i).split("; ")[7].trim());
						BoardGame item = new BoardGame(productID, ProductCategory.BOARDGAME, productName, productCost, productStock, productPrice, boardGameType, numPlayers);
						cartItems.add(item);
						cartTotal += item.getPrice();
					}
					
					else if (productType.equals("accessory")) {
						AccessoryType accessoryType = AccessoryType.valueOf(stock.get(i).split("; ")[2].trim().toUpperCase());
						String compatability = stock.get(i).split("; ")[7].trim();
						Accessories item = new Accessories(productID, ProductCategory.ACCESSORY, productName, productCost, productStock, productPrice, accessoryType, compatability);
						cartItems.add(item);
						cartTotal += item.getPrice();
					}
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeItem(Product item) {
		cartItems.remove(item);
		cartTotal -= item.getPrice();
	}
	
	public ArrayList<Product> getItems() {
		return this.cartItems;
	}
	
	public void clearTotal() {
		cartTotal = 0;
	}
	
	public void viewCart() {
		System.out.println("SHOPPING CART:\n");
		String cart_format = "| %-28s | %-7s |%n";
		System.out.printf(cart_format, "Name", "Price");
		for (int i = 0; i < cartItems.size(); i++) {
			String name = cartItems.get(i).getProductName();
			double price = cartItems.get(i).getPrice();
			System.out.printf(cart_format, name, price);
		}
		System.out.printf("\nCart Total: %.2f\n", cartTotal);
	}
	
	public void cancelCart(Scanner scanner) {
		System.out.println("Are you sure you want to cancel cart?");
		System.out.println("If YES: Type 1\nIf NO: Type 2");
		String usrInput = scanner.nextLine();
		if (usrInput.equals(String.valueOf(1))) {
			cartItems.clear();
			System.out.println("Cart Cancelled!\n");
			return;
			}
		
		else if (usrInput.equals(String.valueOf(2))) {
			System.out.println("Cart Cancelation Cancelled!\n");
			return;
		}
		else {
			System.out.println("Invalid input!\n");
			return;
		}
	}
	
	public double getCartTotal() {
		return this.cartTotal;
	}
	
}
