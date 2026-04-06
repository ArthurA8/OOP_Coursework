
public class PayPal implements PaymentMethod {

	private String email;
	
	public PayPal(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public Receipt processPayment(double total, Address address) {
		Receipt receipt = new PayPalReceipt(total, address, this.getEmail());
		return receipt;
	}
}
