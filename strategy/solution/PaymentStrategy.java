package strategy.solution;

// 1. La Interfaz (Strategy)
// Define el contrato que todos los métodos de pago deben seguir.
public interface PaymentStrategy {
    void pay(double amount);
}