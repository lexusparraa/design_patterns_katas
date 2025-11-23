# Reto: Strategy

## Instrucciones

Refactoriza el código para eliminar los condicionales del método `processPayment` en la clase `CheckoutService`. Actualmente, el servicio necesita saber los detalles de implementación de cada pasarela de pago (PayPal, Tarjeta, Cripto), lo que viola el principio de responsabilidad única y hace difícil agregar nuevas formas de pago sin romper el código existente.

Tu solución debe permitir intercambiar el algoritmo de pago en tiempo de ejecución.

## Código a Refactorizar

**Archivo: `challenge/CheckoutService.java`**
```java

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
```

**Archivo: `challenge/Main.java`**

```java

public class Main {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();
        
        // El cliente está acoplado a strings mágicos ("PAYPAL", etc.)
        service.processPayment("PAYPAL", 100.00);
        service.processPayment("CREDIT_CARD", 50.50);
    }
}
```
## Tips

- 💡 **Identifica lo que cambia**: La acción es siempre "pagar", pero el cómo se realiza el pago cambia según el método.
- 💡 **Define un contrato**: Crea una interfaz (ej: `PaymentStrategy`) con un método `pay(double amount)`.
- 💡 **Inversión de control**: En lugar de que `CheckoutService` decida qué lógica ejecutar basándose en un String, haz que reciba el objeto con la lógica de pago ya lista. El servicio no debe preocuparse por cuál es el método, solo debe ejecutarlo.

## Recursos Adicionales

- [Refactoring Guru - Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [Source Making - Observer Pattern](https://sourcemaking.com/design_patterns/observer)
