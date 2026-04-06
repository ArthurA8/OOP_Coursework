
public class PayPalReceipt extends Receipt {
	
	private String email;
	
	public PayPalReceipt(double amount, Address address, String email) {
		super(amount, address);
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getReceipt() {
		String receipt = String.format("%.2f paid via PayPal using %s on %s. Billing address: %s", this.getAmount(), this.getEmail(), Receipt.date, this.getAddress().fullAddress());
		return receipt;
	}
	
}
