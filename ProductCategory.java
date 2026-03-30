
public enum ProductCategory {
BOARDGAME,
ACCESSORY;
	
	public static String lwrcase(ProductCategory cat) {
		if (cat == BOARDGAME) {
			String lwrcase = "board game";
			return lwrcase;
		}
		else {
			String lwrcase = "accessory";
			return lwrcase;
		}
	}
}
