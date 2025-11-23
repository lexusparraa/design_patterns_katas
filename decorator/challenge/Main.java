package decorator.challenge;

public class Main {
    public static void main(String[] args) {
        // Si quiero doble queso, tendría que crear la clase 'PizzaWithDoubleCheese'...
        Pizza p1 = new PizzaWithCheeseAndPepperoni();
        System.out.println(p1.getDescription() + " $" + p1.cost());
    }
}