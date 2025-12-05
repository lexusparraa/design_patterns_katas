package composite.solution;

public class Main {
    public static void main(String[] args) {
        // Creación de la Estructura
        Directory root = new Directory("Root");
        Directory music = new Directory("Music");
        
        File song1 = new File("song1.mp3", 5000); 
        File resume = new File("resume.pdf", 200); 
        
        Shortcut linkToGame = new Shortcut("GameLink");
        
        root.add(resume);
        root.add(music); 
        music.add(song1); 
        root.add(linkToGame);

        // 1. Imprimir la estructura
        System.out.println("-- Estructura --");
        // Iniciamos la impresión desde el nodo raíz sin indentación inicial
        root.printStructure("");
        
        // 2. Calcular e imprimir el tamaño total
        int totalSize = root.getSizeKB();
        System.out.println("\nTotal Size: " + totalSize + " KB");
    }
}