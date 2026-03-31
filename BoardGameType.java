
public enum BoardGameType {
STRATEGY,
PARTY;
	
	public static String lwrcase(BoardGameType type) {
		if (type == STRATEGY) {
			String lwrcase = "strategy";
			return lwrcase;
		}
		
		else {
			String lwrcase = "party";
			return lwrcase;
		}
	}
}
