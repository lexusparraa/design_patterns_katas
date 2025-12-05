package strategy.solution;

public class Main {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();

        // CASO 1: Pagar con PayPal
        System.out.println("=== Procesando Pedido 1 ===");
        // Le inyectamos la estrategia de PayPal
        service.setPaymentStrategy(new PayPalStrategy());
        service.processPayment(100.00);

        System.out.println();

        // CASO 2: Pagar con Tarjeta de Crédito
        System.out.println("=== Procesando Pedido 2 ===");
        // Cambiamos la estrategia dinámicamente
        service.setPaymentStrategy(new CreditCardStrategy());
        service.processPayment(50.50);

        System.out.println();

        // CASO 3: Cambio dinámico a Cripto
        System.out.println("=== Cambio dinámico ===");
        service.setPaymentStrategy(new CryptoStrategy());
        service.processPayment(50.50);
    }
}