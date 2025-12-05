package strategy.solution;

class PayPalStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Connecting to PayPal API...");
        System.out.println("Paying $" + amount + " using PayPal account.");
    }
}

class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Validating card number...");
        System.out.println("Paying $" + amount + " using Credit Card.");
    }
}

class CryptoStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Checking wallet balance...");
        System.out.println("Paying $" + amount + " using Cryptocurrency.");
    }
}