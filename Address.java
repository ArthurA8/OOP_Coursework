
public class Address {
	private int houseNum;
	private String postCode; 
	private String city; 
	
	public Address(int houseNum, String postCode, String city) {
		this.houseNum = houseNum;
		this.postCode = postCode;
		this.city = city;
	}
	
	public int getHouseNum() {
		return this.houseNum;
	}
	
	public String getPostCode() {
		return this.postCode;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String fullAddress() {
		String address = String.valueOf(this.getHouseNum()) + ", " + this.getCity() + ", " + this.getPostCode();
		return address;
	}
}
