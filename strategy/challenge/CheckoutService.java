package strategy.challenge;

public class CheckoutService {
    public void processPayment(String type, double amount) {
        if (type.equals("PAYPAL")) {
            System.out.println("Connecting to PayPal API...");
            System.out.println("Paying $" + amount + " using PayPal account.");
        } else if (type.equals("CREDIT_CARD")) {
            System.out.println("Validating card number...");
            System.out.println("Paying $" + amount + " using Credit Card.");
        } else if (type.equals("CRYPTO")) {
            System.out.println("Checking wallet balance...");
            System.out.println("Paying $" + amount + " using Cryptocurrency.");
        } else {
            System.out.println("Payment method not supported.");
        }
    }
}