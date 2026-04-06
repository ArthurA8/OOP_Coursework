
public enum AccessoryType {
DICE,
MINIATURE,
PLAYMAT;
	
	public static String lwrcase(AccessoryType type) {
		if (type == DICE) {
			String lwrcase = "dice";
			return lwrcase;
		}
		else if (type == MINIATURE) {
			String lwrcase = "miniature"; 
			return lwrcase;
		}
		else {
			String lwrcase = "playmat";
			return lwrcase;
		}
	}
}
