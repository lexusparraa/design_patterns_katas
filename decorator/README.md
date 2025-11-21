# Kata: Decorator

## Contexto
Imagina que estás construyendo un sistema de notificaciones. Inicialmente, tienes una clase Notificador que envía correos electrónicos. Todo va bien hasta que los clientes piden recibir alertas por SMS. Luego por Slack. Y después por Facebook.

Creas subclases para cada uno: NotificadorSMS, NotificadorSlack. Pero el problema estalla cuando un cliente dice: "Quiero recibir la alerta por Email Y por SMS, pero no por Slack".

Si intentas resolver esto con herencia, terminas con una explosión de combinaciones: NotificadorEmailYSMS, NotificadorEmailYSlack, NotificadorSMSYFacebook. El número de subclases crece exponencialmente y el código se vuelve inmanejable. La herencia es estática; no puedes cambiar el comportamiento de un objeto existente en tiempo de ejecución.
## El Patrón: Decorator

El patrón Decorator (o Wrapper) permite añadir funcionalidades a objetos de forma dinámica colocando estos objetos dentro de objetos encapsuladores especiales que contienen estas funcionalidades.

Piensa en el Decorator como en las capas de ropa. Si tienes frío, no cambias tu cuerpo por un "cuerpo de invierno". Te pones un suéter. Si sigue haciendo frío, te pones una chaqueta encima del suéter. Si empieza a llover, te pones un impermeable encima de todo.

El Decorator resuelve el problema de la rigidez de la herencia al:
- **Usar composición en lugar de herencia**: El objeto decorador tiene una referencia al objeto original (o a otro decorador).
- **Interfaz compartida**: Tanto el decorador como el objeto original implementan la misma interfaz. El cliente no sabe (ni le importa) si está hablando con el objeto base o con una "cebolla" de 5 decoradores.
- **Delegación**: El decorador ejecuta su "extra" (antes o después) y luego llama al método del objeto envuelto.

Beneficios principales:
- **Extensibilidad en tiempo de ejecución**: Puedes añadir o quitar responsabilidades a un objeto sin recompilar código.
- **Evita la explosión de subclases**: No necesitas crear una clase para cada posible combinación de características.
- **Principio de Responsabilidad Única**: Puedes dividir una clase monolítica que hace muchas cosas en varias clases pequeñas, cada una con una función decorativa específica.

## ¿Cuándo usar este patrón?
- **Asignación dinámica de responsabilidades**: Cuando necesitas agregar funcionalidades a objetos individuales en tiempo de ejecución sin afectar a otros objetos de la misma clase.
- **Herencia inviable**: Cuando no puedes extender una clase mediante herencia (por ejemplo, si la clase es final en Java) pero necesitas reutilizar su lógica y modificarla.
- **Combinaciones de comportamientos**: Cuando la lógica de negocio requiere aplicar varias variantes de un comportamiento en diferentes combinaciones (ej: streams de entrada/salida en Java new BufferedReader(new FileReader(file))).
