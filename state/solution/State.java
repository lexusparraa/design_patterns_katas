package state.solution;

// La interfaz común para todos los estados.
// Define el comportamiento que varía según el estado del documento.
public interface State {
    void addText(String text);
    void publish();
    void reject();
}