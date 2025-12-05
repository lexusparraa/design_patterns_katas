package composite.solution;

public class File implements FileSystemComponent {
    private String name;
    private int sizeKB;

    public File(String name, int sizeKB) {
        this.name = name;
        this.sizeKB = sizeKB;
    }

    // Implementación simple: devuelve su tamaño fijo.
    @Override
    public int getSizeKB() {
        return sizeKB;
    }
    
    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "File: " + name + " (" + sizeKB + " KB)");
    }
}