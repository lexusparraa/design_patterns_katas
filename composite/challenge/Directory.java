package composite.challenge;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    // PROBLEMA: Listas separadas para cada tipo de cosa
    private List<File> files = new ArrayList<>();
    private List<Directory> subDirectories = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        subDirectories.add(directory);
    }

    // PROBLEMA: Lógica compleja que debe saber distinguir entre archivos y carpetas
    public int getTotalSizeKB() {
        int total = 0;
        
        // Sumar archivos
        for (File f : files) {
            total += f.getSizeKB();
        }
        
        // Sumar subcarpetas (recursivo manual)
        for (Directory d : subDirectories) {
            total += d.getTotalSizeKB();
        }
        
        return total;
    }
}