
public class Accessories extends Product {

	private AccessoryType type;
	private String compatibility;
	
	public Accessories(int productID, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, AccessoryType type, String compatibility) {
		super(productID, productCategory, productName, purchaseCost, quantityInStock, price);
		this.type = type;
		this.compatibility = compatibility;
	}
	
	public AccessoryType getType() {
		return this.type;
	}
	
	public String getCompatibility() {
		return this.compatibility;
	}
	
	public String toString() {
		String gameDetails = String.format("%d; %s; %s; %s; %.2f; %d; %.2f; %s", this.getProductID(), String.valueOf(ProductCategory.lwrcase(this.getProductCategory())), String.valueOf(AccessoryType.lwrcase(this.getType())), this.getProductName(), this.getPrice(), this.getQuantityInStock(), this.getPurchaseCost(), String.valueOf(this.getCompatibility()));
		return gameDetails;	
	}
}
