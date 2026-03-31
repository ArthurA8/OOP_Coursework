
public class BoardGame extends Product {

	private BoardGameType type;
	private int maxPlayers;
	
	public BoardGame(int productID, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, BoardGameType type, int maxPlayers) {
		super(productID, productCategory, productName, purchaseCost, quantityInStock, price);
		this.type = type;
		this.maxPlayers = maxPlayers;
	}
	
	public BoardGameType getType() {
		return this.type;
	}
	
	public int getMaxPlayers() {
		return this.maxPlayers;
	}
	
	public String toString() {
		String gameDetails = String.format("%d; %s; %s; %s; %.2f; %d; %.2f; %d", this.getProductID(), String.valueOf(ProductCategory.lwrcase(this.getProductCategory())), String.valueOf(BoardGameType.lwrcase(this.getType())), this.getProductName(), this.getPrice(), this.getQuantityInStock(), this.getPurchaseCost(), this.getMaxPlayers());
		return gameDetails;	
	}
}
