# Solución (Composite)
⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. **Interfaz `FileSystemComponent`**: Define el comportamiento común (getSize).
2. **Clase `File` (Leaf)**: Implementa la interfaz devolviendo su tamaño fijo.
3. **Clase `Directory` (Composite)**: Implementa la interfaz. Contiene una lista de Componentes (no de archivos ni carpetas específicas). Su método getSize delega la llamada a sus hijos.

## Salida Esperada

```
-- Estructura --
File: resume.pdf (200 KB)
Directory: Music
  File: song1.mp3 (5000 KB)

Total Size: 5200 KB
```
