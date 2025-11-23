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
