import java.time.LocalDate;

public abstract class Receipt {
	
	private double amount;
	public static String date = LocalDate.now().toString();
	private Address address;
	
	public Receipt(double amount, Address address) {
		this.address = address; 
		this.amount = amount;
	}
	
	public abstract String getReceipt();
	
	public double getAmount() {
		return this.amount;
	}
	
	public Address getAddress() {
		return this.address;
	}
}
