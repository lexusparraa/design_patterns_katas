package strategy.solution;

// 3. El Contexto
// Esta clase ya no sabe CÓMO se paga, solo sabe que tiene una estrategia para hacerlo.
public class CheckoutService {
    
    private PaymentStrategy paymentStrategy;

    // Inyección de Dependencia (Setter Injection)
    // Esto permite cambiar la estrategia en tiempo de ejecución (Runtime).
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Por favor, seleccione un método de pago primero.");
            return;
        }
        
        // Delegamos la acción a la estrategia configurada
        paymentStrategy.pay(amount);
    }
}