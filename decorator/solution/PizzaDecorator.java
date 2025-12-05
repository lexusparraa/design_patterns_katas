package decorator.solution;

// Decorador: La clase clave que permite la "envoltura".
// Extiende de Pizza (para ser del mismo tipo) y tiene una Pizza (composición).
public abstract class PizzaDecorator extends Pizza {
    
    // La pizza que estamos envolviendo/decorando
    protected Pizza tempPizza;

    public PizzaDecorator(Pizza pizza) {
        this.tempPizza = pizza;
    }

    public abstract String getDescription();
}