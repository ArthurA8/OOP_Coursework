
public interface PaymentMethod {
	public abstract Receipt processPayment(double total, Address address);
}
