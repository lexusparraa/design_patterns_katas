# Kata: Builder

## Contexto
Estás diseñando la clase Computer para una tienda de hardware. Una computadora es un objeto complejo: tiene CPU, RAM, Disco Duro, pero también puede tener (o no) Tarjeta de Video dedicada, Refrigeración Líquida, Luces RGB, diferentes Sistemas Operativos, Bluetooth, WiFi, etc.

Trataste de manejar esto con un solo constructor. El resultado fue el "Anti-patrón del Constructor Telescópico": new Computer("Intel", null, 16, 512, "Windows", false, true, false, null...)

El código es una pesadilla porque:
- Es rígido: Si quieres una PC sin tarjeta de video, te ves obligado a pasar un null explícito.
- Es propenso a errores: Es muy fácil intercambiar dos números enteros (ej: poner la RAM donde va el disco duro) y el compilador no te avisará.
## El Patrón: Builder

El patrón Builder separa la construcción de un objeto complejo de su representación. Te permite construir objetos complejos paso a paso. El patrón extrae el código de construcción del objeto fuera de su propia clase y lo mueve a objetos separados llamados builders (constructores).

El Builder resuelve el problema de la complejidad en la creación al:
- Eliminar la necesidad de un constructor gigante con docenas de parámetros.
- Permitir la creación de diferentes representaciones del mismo objeto usando el mismo código de construcción.
- Habilitar la creación paso a paso (puedes pausar la construcción y reanudarla).

Beneficios principales en este escenario:
- **Control granular**: Tienes control total sobre el proceso de construcción; no estás obligado a configurar todo en una sola línea.
- **Principio de Responsabilidad Única**: Aíslas el complejo código de construcción de la lógica de negocio del producto final.
- **Reutilización**: Puedes usar el mismo proceso de construcción para crear diferentes representaciones (ej: una CasaDeMadera y una CasaDeCristal).
- **Código más limpio**: Evita el "constructor telescópico" y hace que el código cliente sea mucho más legible.

## ¿Cuándo usar este patrón?

- Constructor Telescópico: Cuando tu clase tiene un constructor con más de 4 o 5 parámetros, y muchos de ellos son opcionales.
- Construcción paso a paso: Cuando necesitas construir un objeto en una secuencia específica o necesitas posponer algunos pasos de la creación.
- Objetos Compuestos (Composite): Cuando estás construyendo árboles de objetos complejos (como un documento XML o HTML) y quieres separar la lógica de ensamblaje.
- Diferentes representaciones: Cuando quieres que el mismo código de creación sea capaz de producir distintos tipos de productos (ej: un menú de restaurante que puede ser "Vegano", "Infantil" o "Estándar" usando el mismo proceso de armado).
- 
## Challenge

Para poner en práctica el patrón Builder, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.




