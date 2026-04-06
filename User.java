
public abstract class User {

	
	private int userID;
	private String name;
	private int houseNum;
	private String postcode;
	private String city;
	private Role role;
	
	public User(int userID, String name, int houseNum, String postcode, String city, Role role) {
		this.userID = userID;
		this.name = name;
		this.houseNum = houseNum;
		this.postcode = postcode;
		this.city = city;
		this.role = role;
	}
	
	public int getID() {
		return this.userID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public Address address() {
		Address address = new Address(this.houseNum, this.postcode, this.city);
		return address;
	}
	
}
