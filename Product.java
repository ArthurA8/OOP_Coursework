
public abstract class Product {
	
	private double price;
	private int productID;
	private ProductCategory productCategory;
	private String productName;
	private double purchaseCost;
	private int quantityinStock;
	
	public Product(int productID, ProductCategory productCategory, String productName, double purchaseCost, int quantityinStock, double price) {
		this.price = price;
		this.productID = productID;
		this.productCategory = productCategory;
		this.productName = productName;
		this.purchaseCost = purchaseCost;
		this.quantityinStock = quantityinStock;
	}
	
	public ProductCategory getProductCategory() {
		return this.productCategory;
	}
	
	public int getProductID() {
		return this.productID;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public double getPurchaseCost() {
		return this.purchaseCost;
	}
	
	public int getQuantityInStock() {
		return this.quantityinStock;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public abstract String toString();
	
}
