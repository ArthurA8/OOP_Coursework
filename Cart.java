import java.util.ArrayList;

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
	
}
