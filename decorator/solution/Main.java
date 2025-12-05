package decorator.solution;

public class Main {
    public static void main(String[] args) {
        
        // 1. Pedido simple: Pizza base + Queso
        // Creamos la base
        Pizza p1 = new BasePizza();
        // La envolvemos con Queso
        p1 = new Cheese(p1);
        
        System.out.println("Order 1: " + p1.getDescription() + " $" + p1.cost());

        // 2. Pedido complejo: Base + Queso + Pepperoni + Champiñones
        // Podemos anidar los constructores directamente
        Pizza p2 = new Mushroom(new Pepperoni(new Cheese(new BasePizza())));
        
        System.out.println("Order 2: " + p2.getDescription() + " $" + p2.cost());

        // 3. Pedido con doble ingrediente: Base + Doble Queso
        Pizza p3 = new BasePizza();
        p3 = new Cheese(p3); // Primer queso
        p3 = new Cheese(p3); // Segundo queso (se envuelve a sí misma)
        
        System.out.println("Order 3 (Double Cheese): " + p3.getDescription() + " $" + p3.cost());
    }
}