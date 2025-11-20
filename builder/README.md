# Kata: Builder

## Contexto
Estás desarrollando un simulador de construcción de casas (o quizás un generador de reportes complejos). Tu clase principal, Casa, ha crecido descontroladamente. Una casa puede tener garaje, piscina, estatuas, jardín, o quizás nada de eso.

Para crear una casa, terminas con un constructor monstruoso ("Telescoping Constructor") que se ve así: new Casa(paredes, puertas, ventanas, tieneGaraje, tienePiscina, tieneJardin, ...). La mayoría de las veces, pasas null o false a los parámetros que no necesitas, haciendo que el código sea sucio, difícil de leer y propenso a errores si confundes el orden de los argumentos.

## El Patrón: Builder

El patrón Builder separa la construcción de un objeto complejo de su representación. Te permite construir objetos complejos paso a paso. El patrón extrae el código de construcción del objeto fuera de su propia clase y lo mueve a objetos separados llamados builders (constructores).

El Builder resuelve el problema de la complejidad en la creación al::
- Eliminar la necesidad de un constructor gigante con docenas de parámetros.
- Permitir la creación de diferentes representaciones del mismo objeto usando el mismo código de construcción.
- Habilitar la creación paso a paso (puedes pausar la construcción y reanudarla).

A menudo se implementa con una "interfaz fluida" (method chaining), donde cada paso devuelve el objeto builder, permitiendo llamadas encadenadas como: builder.setMuros(4).setTecho("Tejas").build().

Beneficios principales:
- **Control granular**: Tienes control total sobre el proceso de construcción; no estás obligado a configurar todo en una sola línea.

- **Principio**: de Responsabilidad Única: Aíslas el complejo código de construcción de la lógica de negocio del producto final.

- **Reutilización**: Puedes usar el mismo proceso de construcción para crear diferentes representaciones (ej: una CasaDeMadera y una CasaDeCristal).

- **Código más**: limpio: Evita el "constructor telescópico" y hace que el código cliente sea mucho más legible.

## ¿Cuándo usar este patrón?
- **Constructor Telescópico**: Cuando tu clase tiene un constructor con más de 4 o 5 parámetros, y muchos de ellos son opcionales.

- **Construcción paso a paso**: Cuando necesitas construir un objeto en una secuencia específica o necesitas posponer algunos pasos de la creación.

- **Objetos Compuestos (Composite)**: Cuando estás construyendo árboles de objetos complejos (como un documento XML o HTML) y quieres separar la lógica de ensamblaje.

- **Diferentes representaciones**: Cuando quieres que el mismo código de creación sea capaz de producir distintos tipos de productos (ej: un menú de restaurante que puede ser "Vegano", "Infantil" o "Estándar" usando el mismo proceso de armado).
## Challenge
Para poner en práctica el patrón Adapter, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.

