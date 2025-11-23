# Solución (Decorator)

⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. **PizzaDecorator**: Una clase abstracta que hereda de Pizza y además contiene un objeto Pizza. Es el puente clave.
2. **Ingredientes Concretos**: Cheese, Pepperoni, Mushroom. Ya no son "PizzaCon...", son solo el ingrediente. Toman una pizza existente en su constructor y le suman su valor.
3. **Flexibilidad**: En el Main, podemos envolver tantas veces como queramos.

## Salida Esperada

```
Order 1: Base Pizza + Cheese $11.5
Order 2: Base Pizza + Cheese + Pepperoni + Mushroom $15.0
Order 3 (Double Cheese): Base Pizza + Cheese + Cheese $13.0
```
