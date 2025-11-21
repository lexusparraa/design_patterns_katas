# Kata: Composite

## Contexto
Imagina que estás diseñando una aplicación de envíos para una tienda en línea. Un pedido puede consistir en un producto simple (como un teléfono), pero también puede ser una caja que contiene varios productos (un cargador, audífonos) e incluso otras cajas más pequeñas dentro (una caja con accesorios).

Si intentas calcular el precio total del pedido, tu código se vuelve una pesadilla de bucles y condicionales: "Si es un producto, suma su precio. Si es una caja, ábrela, mira qué tiene dentro, si hay otra caja, ábrela...". Tienes que distinguir constantemente entre objetos simples y contenedores complejos, lo que hace que el sistema sea muy rígido y difícil de mantener.

## El Patrón: Compposite
El patrón Composite permite componer objetos en estructuras de árbol y trabajar con esas estructuras como si fueran objetos individuales.

La clave de este patrón es la uniformidad. Define una interfaz común (Componente) tanto para los objetos simples (Hojas/Leaves) como para los contenedores (Compuestos/Composites).

El Composite resuelve el problema de la jerarquía al:
- **Componente (Interfaz)**: Declara las operaciones comunes (ej: obtenerPrecio()).
- **Hoja (Leaf)**: Es el objeto básico que hace el trabajo real (ej: el producto que sabe su precio).
- **Compuesto (Composite)**: Es el contenedor. Tiene una lista de hijos (que pueden ser Hojas u otros Compuestos). Cuando le pides el precio, el Compuesto recorre sus hijos, les pide su precio y devuelve la suma total.

- Para el cliente (tu código principal), no hay diferencia. Solo llama a orden.obtenerPrecio(), sin importarle si orden es un solo objeto o un árbol gigante de objetos anidados.

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


