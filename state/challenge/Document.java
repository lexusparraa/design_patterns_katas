package state.challenge;

public class Document {
    private String state;
    private String text;

    public Document() {
        this.state = "DRAFT"; // Estado inicial
        this.text = "";
    }

    public void addText(String newText) {
        if (state.equals("DRAFT") || state.equals("MODERATION")) {
            // En moderación aún se permite editar, pero en Publicado no.
            this.text += newText;
            System.out.println("Text added. Current content: " + text);
        } else if (state.equals("PUBLISHED")) {
            System.out.println("Error: Cannot edit a published document.");
        }
    }

    public void publish() {
        if (state.equals("DRAFT")) {
            state = "MODERATION";
            System.out.println("Moved from Draft to Moderation.");
        } else if (state.equals("MODERATION")) {
            // Simulamos que el usuario es un admin y lo aprueba
            state = "PUBLISHED";
            System.out.println("Moved from Moderation to Published.");
        } else if (state.equals("PUBLISHED")) {
            System.out.println("Document is already published.");
        }
    }
    
    // Método para "rechazar" y volver a borrador
    public void reject() {
        if (state.equals("DRAFT")) {
            System.out.println("It's already a draft.");
        } else if (state.equals("MODERATION")) {
            state = "DRAFT";
            System.out.println("Rejected. Moved back to Draft.");
        } else if (state.equals("PUBLISHED")) {
            System.out.println("Error: Cannot reject a published document.");
        }
    }
}