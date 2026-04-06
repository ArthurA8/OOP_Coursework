import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	private double cartTotal;
	private ArrayList<Product> cartItems;
	
	public Cart(double cartTotal, ArrayList<Product> cartItems) {
		this.cartTotal = cartTotal;
		this.cartItems = cartItems;
	}
	
	public void addItem(Product item) {
		cartItems.add(item);
		cartTotal += item.getPrice();
	}
	
	public void removeItem(Product item) {
		cartItems.remove(item);
		cartTotal -= item.getPrice();
	}
	
	public ArrayList<Product> getItems() {
		return this.cartItems;
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
			for (int i = 0; i < this.getItems().size(); i ++) {
				this.removeItem(this.getItems().get(i));
			}
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
