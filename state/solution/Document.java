package state.solution;

// Contexto: Mantiene una referencia al estado actual.
public class Document {
    private State state;
    private String text;

    public Document() {
        // Estado inicial: Draft (Borrador)
        this.state = new DraftState(this);
        this.text = "";
    }

    // Método setter para cambiar el estado (usado por los Estados Concretos)
    public void changeState(State state) {
        this.state = state;
    }

    // Getters y Setters para el contenido (usado por los Estados para editar)
    public String getText() {
        return text;
    }

    public void appendText(String newText) {
        this.text += newText;
    }

    // --- Delegación de Comportamiento ---
    // El documento ya no decide nada, solo delega al estado actual.

    public void addText(String text) {
        state.addText(text);
    }

    public void publish() {
        state.publish();
    }

    public void reject() {
        state.reject();
    }
}