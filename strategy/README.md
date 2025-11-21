# Kata: Strategy

## Contexto
Estás desarrollando el módulo de facturación (CheckoutService) para una tienda en línea. Inicialmente, la tienda solo aceptaba PayPal. El código era simple y directo.

Sin embargo, el negocio crece y te piden agregar Tarjeta de Crédito. Añades un if/else para verificar el tipo de pago. Meses después, te piden agregar Criptomonedas, luego Apple Pay, y luego Transferencia Bancaria.

Tu clase CheckoutService se ha convertido en un monstruo. Tiene condicionales gigantescos, importa librerías de PayPal, SDKs de bancos y utilidades de Cripto, todo mezclado en un solo archivo. Cada vez que necesitas editar la lógica de PayPal, corres el riesgo de romper la lógica de las Tarjetas de Crédito. El código es rígido y difícil de probar.

## El Patrón: Strategy

El patrón Strategy sugiere que tomes esa clase que hace algo específico de muchas maneras diferentes (pagar) y extraigas cada una de esas variantes en clases separadas llamadas Estrategias.

En nuestro caso de pagos:

  1. La "Estrategia" es la forma de procesar el dinero.

  2. El "Contexto" es tu servicio de compra (CheckoutService).

  3. El Cliente es quien decide qué método usar.

En lugar de que el CheckoutService sepa cómo hablar con PayPal o cómo validar una Tarjeta, simplemente delegará esa tarea a un objeto experto.

El Strategy resuelve el problema del `CheckoutService` gigante al:
- Interfaz Común `(PaymentStrategy)`: Define un contrato universal que todos los métodos de pago deben cumplir (ej: `pay(amount)`). El `CheckoutService` solo habla con esta interfaz.
- Estrategias Concretas: Cada clase `(PayPalStrategy, CreditCardStrategy)` contiene la lógica sucia y específica de su API correspondiente, aislada del resto del sistema.
- Inyección: El `CheckoutService` recibe la estrategia lista para usar (ya sea en el constructor o mediante un setter). No decide cuál usar, solo la usa.

Beneficios principales:
- **Principio Abierto/Cerrado**: Puedes agregar `ApplePayStrategy.java` mañana sin tocar ni una sola línea de `CheckoutService.java.`
- **Aislamiento**: Los errores en la librería de Criptomonedas no afectan a los pagos con Tarjeta.
- **Intercambio en caliente**: El usuario puede seleccionar "PayPal", arrepentirse, y seleccionar "Tarjeta" en la interfaz, y el código simplemente cambia el objeto estrategia en tiempo de ejecución.

## ¿Cuándo usar este patrón?

- **Múltiples variantes de un algoritmo**: Cuando tienes varias formas de realizar una acción conceptualmente igual (en este caso, transferir dinero).
- **Lógica condicional compleja**: Cuando tu método tiene un switch o múltiples if que dependen de un "tipo" o "modo" (ej: if (type == "PAYPAL")).
- **Ocultar detalles de implementación**: Cuando quieres que tu lógica de negocio principal (CheckoutService) no dependa de librerías externas complejas (SDKs de pagos).

## Challenge

Para poner en práctica el patrón Strategy, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.
