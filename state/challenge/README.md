# Reto (State)

## Instrucciones

Refactoriza la clase `Document`. Actualmente, el documento gestiona sus estados (`Draft`, `Moderation`, `Published`) utilizando una variable String y múltiples sentencias `if-else` dentro de cada método. Esto provoca que la lógica de negocio esté dispersa. Por ejemplo, el método `publish()` hace cosas totalmente diferentes dependiendo del estado actual. Si quisiéramos agregar un estado "Archivado", tendríamos que modificar todos los métodos de la clase, rompiendo el principio Abierto/Cerrado.

Tu solución debe encapsular el comportamiento de cada estado en su propia clase, eliminando los condicionales del documento principal.

## Código a Refactorizar

**Archivo: `challenge/Document.java`**
```java
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
```

**Archivo: `challenge/Main.java`**
```java
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
```

## Tips

- 💡 **Identifica los comportamientos**: Observa que `addText`, `publish` y `reject` actúan diferente según el valor de `state`.
- 💡 **Contexto**: La clase `Document` será el "Contexto". Debe tener un método `changeState(State newState)` para permitir las transiciones.
- 💡 **Delegación**: El documento ya no decide qué hacer. Simplemente llama a `state.publish()`. Es el Estado actual quien decide si cambia al siguiente estado o lanza un error.

## Recursos Adicionales

- [Refactoring Guru - Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [Source Making - Observer Pattern](https://sourcemaking.com/design_patterns/observer)
