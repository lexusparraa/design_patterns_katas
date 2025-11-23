# Kata: Decorator

## Contexto
Estás diseñando el sistema de facturación de una pizzería. Al principio, usaste herencia para describir las pizzas. Tenías PizzaBase, y luego creaste subclases para las variantes.

El problema explotó cuando notaste que los clientes piden combinaciones arbitrarias. Si usas herencia, necesitas una clase para cada combinación posible. PizzaConQueso, PizzaConQuesoYJamón, PizzaConQuesoJamónYPiña... Esto es insostenible.

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

## Challenge

Para poner en práctica el patrón Decorator, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.


## Recursos Adicionales

- [Refactoring Guru - Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
- [Source Making - Adapter Pattern](https://sourcemaking.com/design_patterns/adapter)

