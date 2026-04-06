
public class CreditCardReceipt extends Receipt {

	private String cardNumber;
	private String securityCode;
	
	public CreditCardReceipt(double amount, Address address, String cardNumber, String securityCode) {
		super(amount, address);
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
	}
	
	public String getCardNumber() {
		return this.cardNumber;
	}
	
	public String getSecurityCode() {
		return this.securityCode;
	}
	
	public String getReceipt() {
		String receipt = String.format("%.2f paid by Credit Card %s on %s. Billing address: %s", this.getAmount(), this.getCardNumber(), Receipt.date, this.getAddress().fullAddress());
		return receipt;
	}
		
}
