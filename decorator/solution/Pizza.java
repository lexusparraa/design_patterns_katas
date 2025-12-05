package decorator.solution;

// Componente: La clase abstracta base
public abstract class Pizza {
    String description = "Unknown Pizza";
  
    public String getDescription() {
        return description;
    }
  
    public abstract double cost();
}