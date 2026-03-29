
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
		String gameDetails = String.valueOf(this.getProductID()) + "; " + String.valueOf(this.getProductCategory()) + "; " + String.valueOf(this.getType()) + "; " + this.getProductName() + "; " + String.valueOf(this.getPrice()) + String.valueOf(this.getQuantityInStock()) + "; " + String.valueOf(this.getPurchaseCost()) + String.valueOf(this.getMaxPlayers());
		return gameDetails;	
	}
}
