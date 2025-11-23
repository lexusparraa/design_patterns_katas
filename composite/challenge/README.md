# Reto (Composite)

## Instrucciones
Refactoriza el código del sistema de archivos. Actualmente, la clase `Directory` tiene que tratar a los `File` y a los `Directory` (Subcarpetas) de manera diferente. Tiene dos listas separadas y lógica duplicada para calcular el tamaño total.

Si quisieras agregar un tercer tipo de elemento (ej: un "Acceso Directo" o "Link Simbólico"), tendrías que modificar la clase `Directory` para agregar una tercera lista y otro bucle, rompiendo el principio Abierto/Cerrado.

Tu solución debe permitir tratar a archivos y carpetas de manera uniforme, permitiendo calcular el peso de una carpeta raíz sin importar qué tan profunda o compleja sea la estructura.

## Código a Refactorizar

**Archivo: `challenge/File.java`**
```java
package composite.challenge;

public class File {
    private String name;
    private int sizeKB;

    public File(String name, int sizeKB) {
        this.name = name;
        this.sizeKB = sizeKB;
    }

    public int getSizeKB() {
        return sizeKB;
    }
}
```
**Archivo: `challenge/Directory.java`**
```java
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
```

**Archivo: `challenge/Main.java`**
```java
package composite.challenge;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory music = new Directory("Music");
        
        File song1 = new File("song1.mp3", 5000); // 5MB
        File resume = new File("resume.pdf", 200); // 200KB
        
        root.addFile(resume);
        root.addDirectory(music);
        music.addFile(song1); // La música va dentro de la carpeta música

        System.out.println("Total Size: " + root.getTotalSizeKB() + " KB");
    }
}
```

## Tips

- 💡 Busca el denominador común: Tanto un `File` como un `Directory` son elementos del sistema de archivos y ambos tienen un "tamaño".
- 💡 Interfaz Común: Crea una interfaz (ej: FileSystemComponent) que declare el método `getSize()`.
- 💡 Uniformidad: Haz que `Directory` tenga una sola lista: `List<FileSystemComponent>`. Así no le importa si guarda archivos o más carpetas dentro.
- 💡 Recursividad Mágica: Al iterar esa lista única y llamar a `.getSize()`, el polimorfismo se encargará de decidir si devuelve el tamaño simple (si es archivo) o calcula la suma (si es carpeta).

## Recursos Adicionales

- [Refactoring Guru - Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
- [Source Making - Adapter Pattern](https://sourcemaking.com/design_patterns/adapter)

