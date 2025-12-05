package composite.solution;


/**
 *
 * @author lexusparra
 */
public class Shortcut implements FileSystemComponent {
    
    private String name;
    private int sizeKB = 1;
    
    public Shortcut(String name) {
        this.name = name;
        this.sizeKB = sizeKB;
    }

    @Override
    public int getSizeKB() {
        return sizeKB;
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "Shortcut: " + name + " (" + sizeKB + " KB)");
    }
    
}
