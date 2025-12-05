package decorator.solution;

// 1. Componente Concreto: La Pizza base
class BasePizza extends Pizza {
    public BasePizza() {
        description = "Base Pizza";
    }
  
    @Override
    public double cost() {
        return 10.00;
    }
}

// ---------------------------------------------------------
// 2. Decoradores Concretos: Los Ingredientes
// Nota: En un proyecto real, cada clase iría en su propio archivo.
// ---------------------------------------------------------

class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza); // Pasamos la pizza al padre para guardarla
    }

    @Override
    public String getDescription() {
        // Delegamos a la pizza envuelta y agregamos lo nuestro
        return tempPizza.getDescription() + " + Cheese";
    }

    @Override
    public double cost() {
        // Delegamos el costo a la pizza envuelta y sumamos el nuestro
        return tempPizza.cost() + 1.50;
    }
}

class Pepperoni extends PizzaDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " + Pepperoni";
    }

    @Override
    public double cost() {
        return tempPizza.cost() + 2.00;
    }
}

class Mushroom extends PizzaDecorator {
    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " + Mushroom";
    }

    @Override
    public double cost() {
        return tempPizza.cost() + 1.50; // Asumiendo precio
    }
}