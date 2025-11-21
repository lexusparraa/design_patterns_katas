# Kata: Composite

## Contexto
Estás programando el núcleo de un sistema operativo. Debes manejar archivos y carpetas. Al principio, trataste a las carpetas como objetos especiales que contenían listas de archivos Y listas de otras carpetas. Esto provocó que tu método `getSize()` fuera complejo: tenía que saber exactamente qué tipo de objeto estaba sumando.

El problema real surge de la jerarquía. Una carpeta contiene cosas que pueden contener otras cosas. Si usas el enfoque tradicional, necesitas código específico para cada nivel de profundidad o comprobaciones de tipo (instanceof) constantes.

## El Patrón: Compposite
El patrón Composite permite componer objetos en estructuras de árbol y trabajar con esas estructuras como si fueran objetos individuales.

La clave de este patrón es la uniformidad. Define una interfaz común (Componente) tanto para los objetos simples (Hojas/Leaves) como para los contenedores (Compuestos/Composites).

El Composite resuelve el problema de la jerarquía al:
- **Componente (Interfaz)**: Es la "máscara" común. Declara que todo elemento tiene un peso.
- **Hoja (Leaf)**: Es el objeto básico que hace el trabajo real (ej: el producto que sabe su precio).
- **Compuesto (Composite)**: Es el contenedor. Tiene una lista de hijos (que pueden ser Hojas u otros Compuestos). Cuando le pides el precio, el Compuesto recorre sus hijos, les pide su precio y devuelve la suma total.


Beneficios principales:
- **Uniformidad**: Puedes tratar a los componentes simples y a los grupos complejos de la misma manera. El código cliente se simplifica enormemente.
- **Principio Abierto/Cerrado**: Puedes introducir nuevos tipos de elementos (ej: una "CajaRefrigerada") sin romper el código existente que calcula los precios.
- **Recursividad implícita**: No tienes que escribir la lógica recursiva en el cliente; el patrón delega la ejecución hacia abajo en el árbol automáticamente.

## ¿Cuándo usar este patrón?
- **Estructuras de "Parte-Todo"**: Cuando necesitas implementar una estructura de objetos en forma de árbol (como un sistema de archivos con carpetas y archivos, o un menú con submenús).
- **Indiferencia del Cliente**: Cuando quieres que el código cliente trate a los objetos simples y a los compuestos de forma idéntica (por ejemplo, dibujar una forma simple o dibujar un grupo de formas en un editor gráfico).
- **Operaciones Recursivas**: Cuando necesitas ejecutar una operación sobre toda la jerarquía (calcular totales, renderizar gráficos, buscar en directorios).

## Challenge

Para poner en práctica el patrón Composite, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.



