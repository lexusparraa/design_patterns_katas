# Solución (Strategy)

⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. **Interfaz `PaymentStrategy`**: Define el contrato común para todos los algoritmos de pago.
2. **Estrategias Concretas**: Clases separadas (`PayPalStrategy`, `CreditCardStrategy`, etc.) que implementan la lógica específica.
3. **Inyección en el Contexto**: CheckoutService ya no tiene if/else. Ahora recibe una estrategia (puede ser en el constructor o en el método setter/método de acción) y delega la ejecución.

## Salida Esperada

```
=== Procesando Pedido 1 ===
Connecting to PayPal API...
Paying $100.0 using PayPal account.

=== Procesando Pedido 2 ===
Validating card number...
Paying $50.5 using Credit Card.

=== Cambio dinámico ===
Checking wallet balance...
Paying $50.5 using Cryptocurrency.
¿Cómo agregar un nuevo método de pago?
```
Para agregar "Apple Pay", solo crearías una clase `ApplePayStrategy` que implemente la interfaz. No necesitas tocar `CheckoutService`.
