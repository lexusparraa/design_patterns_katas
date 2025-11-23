package strategy.challenge;

public class Main {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();
        
        // El cliente está acoplado a strings mágicos ("PAYPAL", etc.)
        service.processPayment("PAYPAL", 100.00);
        service.processPayment("CREDIT_CARD", 50.50);
    }
}