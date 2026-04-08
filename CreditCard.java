
public class CreditCard implements PaymentMethod {

	private String cardNumber;
	private String securityCode;
	
	public CreditCard(String CardNumber, String securityCode) {
		setCardNumber(CardNumber);
		setSecurityCode(securityCode);
		
	}
	
	public void setCardNumber (String cardNumber) {
		int cardNumLength = cardNumber.length();
		if (cardNumLength != 6) {
			throw new IllegalArgumentException("Invalid Card Number! Must be 6 digits!");
		}
		else {
			this.cardNumber = cardNumber;
		}
	}
	
	public void setSecurityCode (String securityCode) {
		int securityCodeLength = String.valueOf(securityCode).length();
		if (securityCodeLength != 3) {
			throw new IllegalArgumentException("Invalid Security Code! Must be 3 digits!");
		}
		else {
			this.securityCode = securityCode;
		}
	}
	
	public String getCardNumber() {
		return this.cardNumber;
	}
	
	public String getSecurityCode() {
		return this.securityCode;
	}
	
	@Override 
	public Receipt processPayment(double total, Address address) {
		Receipt receipt = new CreditCardReceipt(total, address, this.getCardNumber(), this.getSecurityCode());
		return receipt;
	}
	
}
