
public class Accessories extends Product {

	private AccessoryType type;
	private BoardGame compatibility;
	
	public Accessories(int productID, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, AccessoryType type, BoardGame compatibility) {
		super(productID, productCategory, productName, purchaseCost, quantityInStock, price);
		this.type = type;
		this.compatibility = compatibility;
	}
	
	public AccessoryType getType() {
		return this.type;
	}
	
	public BoardGame getCompatibility() {
		return this.compatibility;
	}
	
	public String toString() {
		String gameDetails = String.valueOf(this.getProductID()) + "; " + String.valueOf(this.getProductCategory()) + "; " + String.valueOf(this.getType()) + "; " + this.getProductName() + "; " + String.valueOf(this.getPrice()) + String.valueOf(this.getQuantityInStock()) + "; " + String.valueOf(this.getPurchaseCost()) + String.valueOf(this.getCompatibility());
		return gameDetails;	
	}
}
