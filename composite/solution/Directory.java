package composite.solution;

import java.util.ArrayList;
import java.util.List;

// Compuesto (Composite): Puede contener Hojas y otros Compuestos.
public class Directory implements FileSystemComponent {
    private String name;
    // SOLUCIÓN: Lista única que almacena cualquier cosa que sea FileSystemComponent.
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    // Método de gestión unificado
    public void add(FileSystemComponent component) {
        components.add(component);
    }
    
    // Operación recursiva: Suma el tamaño de todos los componentes.
    @Override
    public int getSizeKB() {
        int total = 0;
        
        // Iteramos la lista única y delegamos la llamada.
        // El polimorfismo se encarga de llamar al getSizeKB() correcto (File o Directory).
        for (FileSystemComponent component : components) {
            total += component.getSizeKB(); 
        }
        
        return total;
    }
    
    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "Directory: " + name);
        // Lógica recursiva: llama a la impresión de cada hijo con más indentación
        for (FileSystemComponent component : components) {
            component.printStructure(indent + "  "); 
        }
    }
}