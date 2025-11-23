package state.challenge;

public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        
        doc.addText("Hello World");
        doc.publish(); // Pasa a Moderación
        
        doc.addText(" (Edit attempt)"); // Se permite
        doc.publish(); // Pasa a Publicado
        
        doc.addText(" (Edit after publish)"); // Error
        doc.reject(); // Error
    }
}