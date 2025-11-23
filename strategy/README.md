# Kata: Strategy

## Contexto
Estás desarrollando el módulo de facturación (`CheckoutService`) para una tienda en línea. Inicialmente, la tienda solo aceptaba PayPal. El código era simple y directo.

Sin embargo, el negocio crece y te piden agregar Tarjeta de Crédito. Añades un if/else para verificar el tipo de pago. Meses después, te piden agregar Criptomonedas, luego Apple Pay, y luego Transferencia Bancaria.

Tu clase `CheckoutService` se ha convertido en un monstruo. Tiene condicionales gigantescos, importa librerías de PayPal, SDKs de bancos y utilidades de Cripto, todo mezclado en un solo archivo. Cada vez que necesitas editar la lógica de PayPal, corres el riesgo de romper la lógica de las Tarjetas de Crédito. El código es rígido y difícil de probar.

## El Patrón: Strategy

El patrón Strategy permite definir una familia de algoritmos, encapsular cada uno de ellos en una clase separada y hacerlos intercambiables.

El patrón sugiere que extraigas todos esos algoritmos que hacen "lo mismo pero de forma diferente" y los muevas a clases individuales llamadas Estrategias. La clase original pasa a tener una referencia a una de estas estrategias y le delega el trabajo.


  1. La "Estrategia" es la forma de procesar el dinero.

  2. El "Contexto" es tu servicio de compra (`CheckoutService`).

  3. El Cliente es quien decide qué método usar.

En lugar de que el `CheckoutService` sepa cómo hablar con PayPal o cómo validar una Tarjeta, simplemente delegará esa tarea a un objeto experto.

El Strategy resuelve el problema del `CheckoutService` gigante al:
- Interfaz Común `(PaymentStrategy)`: Define un contrato universal que todos los métodos de pago deben cumplir (ej: `pay(amount)`). El `CheckoutService` solo habla con esta interfaz.
- Estrategias Concretas: Cada clase `(PayPalStrategy, CreditCardStrategy)` contiene la lógica sucia y específica de su API correspondiente, aislada del resto del sistema.
- Inyección: El `CheckoutService` recibe la estrategia lista para usar (ya sea en el constructor o mediante un setter). No decide cuál usar, solo la usa.

Beneficios principales:
- **Principio Abierto/Cerrado**: Puedes agregar `ApplePayStrategy.java` mañana sin tocar ni una sola línea de `CheckoutService.java`
- **Aislamiento**: Separa el código de negocio de los detalles complejos de los algoritmos.
- **Composición sobre herencia**: Es mucho más flexible que intentar manejar variaciones de algoritmos creando subclases del contexto.
- **Intercambio en tiempo de ejecución**: Puedes cambiar el algoritmo que usa un objeto mientras el programa corre

## ¿Cuándo usar este patrón?

- **Varias formas de hacer algo**: Cuando tienes una clase que hace algo específico de muchas maneras diferentes (algoritmos de ordenamiento, filtros de imagen, estrategias de pago, rutas).
- **Cambio dinámico**: Cuando necesitas cambiar de algoritmo durante la ejecución.
- **Muchos condicionales**: Cuando tienes un switch o múltiples if que seleccionan la variante de un algoritmo.
- **Ocultar complejidad**: Cuando quieres ocultar datos o lógica compleja específica de un algoritmo a las clases que lo usan.

## Challenge

Para poner en práctica el patrón Strategy, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [Source Making - Observer Pattern](https://sourcemaking.com/design_patterns/observer)
