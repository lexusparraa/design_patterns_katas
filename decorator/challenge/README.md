# Reto (Decorator)

## Instrucciones

Refactoriza el sistema de precios de la pizzería. Actualmente, el sistema utiliza herencia para manejar los ingredientes extra. Esto ha provocado una "explosión de clases". Tienes una clase para `PizzaConQueso`, otra para `PizzaConPepperoni`, otra para `PizzaConQuesoYPepperoni`, etc.

Si quieres agregar un nuevo ingrediente (ej: Champiñones), tendrías que crear combinaciones para todas las clases existentes (`ConQuesoYChampiñones`, `ConPepperoniYChampiñones`, `ConTodo`...).

Tu solución debe permitir agregar cualquier número de ingredientes a una pizza base de forma dinámica, sin crear nuevas clases para cada combinación, y calculando el precio total correctamente.

## Código a Refactorizar

**Archivo: `challenge/Pizza.java`**
```java
package decorator.challenge;

public abstract class Pizza {
    String description = "Unknown Pizza";
  
    public String getDescription() {
        return description;
    }
  
    public abstract double cost();
}
```

**Archivo: `challenge/Combinations.java`**
```java
package decorator.challenge;

public class Combinations {
    class BasePizza extends Pizza {
    public BasePizza() { description = "Base Pizza"; }
    public double cost() { return 10.00; }
    }

class PizzaWithCheese extends Pizza {
    public PizzaWithCheese() { description = "Base Pizza + Cheese"; }
    public double cost() { return 10.00 + 1.50; }
    }

class PizzaWithPepperoni extends Pizza {
    public PizzaWithPepperoni() { description = "Base Pizza + Pepperoni"; }
    public double cost() { return 10.00 + 2.00; }
    }

// El problema real: Combinaciones
class PizzaWithCheeseAndPepperoni extends Pizza {
    public PizzaWithCheeseAndPepperoni() { description = "Base Pizza + Cheese + Pepperoni"; }
    public double cost() { return 10.00 + 1.50 + 2.00; }
    }
}
```

**Archivo: `challenge/Combinations.java`**
```java
package decorator.challenge;

public class Main {
    public static void main(String[] args) {
        // Si quiero doble queso, tendría que crear la clase 'PizzaWithDoubleCheese'...
        Pizza p1 = new PizzaWithCheeseAndPepperoni();
        System.out.println(p1.getDescription() + " $" + p1.cost());
    }
}
```

## Tips

- 💡 **Envoltura (Wrapper)**: Imagina que la pizza base es un objeto. El queso es un "envoltorio" que contiene a la pizza. El pepperoni es otro envoltorio que contiene al queso (que contiene a la pizza).
- 💡 **Mismo Tipo**: El decorador (Ingrediente) debe ser del mismo tipo que el objeto decorado (Pizza). Esto permite pasar una "Pizza con Queso" a un constructor que espera una "Pizza" para ponerle Pepperoni encima.
- 💡 **Delegación**: Cuando le pides el precio al "Queso", este debe sumar su precio + el precio del objeto que tiene adentro.

## Recursos Adicionales

- [Refactoring Guru - Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
- [Source Making - Adapter Pattern](https://sourcemaking.com/design_patterns/adapter)
