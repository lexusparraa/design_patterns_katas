# Kata: Builder

## Contexto
Estás diseñando la clase Computer para una tienda de hardware. Una computadora es un objeto complejo: tiene CPU, RAM, Disco Duro, pero también puede tener (o no) Tarjeta de Video dedicada, Refrigeración Líquida, Luces RGB, diferentes Sistemas Operativos, Bluetooth, WiFi, etc.

Trataste de manejar esto con un solo constructor. El resultado fue el "Anti-patrón del Constructor Telescópico": new Computer("Intel", null, 16, 512, "Windows", false, true, false, null...)

El código es una pesadilla porque:
- Es rígido: Si quieres una PC sin tarjeta de video, te ves obligado a pasar un null explícito.
- Es propenso a errores: Es muy fácil intercambiar dos números enteros (ej: poner la RAM donde va el disco duro) y el compilador no te avisará.
## El Patrón: Builder

El patrón Builder separa la construcción de un objeto complejo de su representación final. En lugar de pedirle al cliente que ensamble todas las piezas en una sola línea (el constructor gigante), le das un objeto constructor (el Builder) que permite configurar el producto paso a paso.

- **El Producto (Computer)**: Es el objeto final. Ahora es inmutable (sus campos son final), lo que significa que una vez creada, la PC no cambia "mágicamente".
- **El Constructor (ComputerBuilder)**: Es una clase auxiliar. Tiene los mismos campos que la PC, pero son mutables. Acumula la configuración que el cliente desea.
- **Fluent Interface**: Usamos métodos que devuelven this (como withRGB()), permitiendo encadenar las llamadas como una frase legible.

El Builder resuelve el problema del constructor gigante al:

- Valores por defecto: El Builder ya tiene valores predefinidos (ej: gpu = "Integrated"). Si el cliente no llama a setGPU(), simplemente se usa el valor por defecto.
- Claridad: Reemplaza parámetros posicionales (true, false) por llamadas con nombre (.withLiquidCooling()).
- Validación: El método .build() es el lugar perfecto para verificar que la configuración sea válida (ej: "No puedes tener refrigeración líquida sin un gabinete grande") antes de crear el objeto real.

Beneficios principales en este escenario:
- **Código Cliente Legible**: new ComputerBuilder(...).withRGB().build() se lee como lenguaje natural.
- **Inmutabilidad Garantizada**: El objeto Computer no tiene "setters". Una vez que haces build(), esa configuración es segura y definitiva.
- **Flexibilidad**: Puedes crear una PC de oficina básica o una PC Gamer monstruosa usando la misma clase, sin tener docenas de constructores sobrecargados.

## ¿Cuándo usar este patrón?
- Constructores con más de 4 parámetros: Especialmente si varios son opcionales.
- Prevención de errores de parámetros: Cuando tienes varios parámetros del mismo tipo seguidos (ej: int ram, int storage, int psuWatts).
- Creación de objetos inmutables: Cuando quieres que el objeto final sea de solo lectura, pero necesitas una forma cómoda de configurarlo antes de crearlo.

## Challenge
Para poner en práctica el patrón Builder, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.



