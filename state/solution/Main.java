package state.solution;

public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        
        // 1. Estamos en DRAFT
        doc.addText("Hello World");
        doc.publish(); // Pasa a Moderación
        
        // 2. Estamos en MODERATION
        doc.addText(" (Edit attempt)"); // Se permite
        doc.publish(); // Pasa a Publicado
        
        // 3. Estamos en PUBLISHED
        doc.addText(" (Edit after publish)"); // Error
        doc.reject(); // Error
    }
}