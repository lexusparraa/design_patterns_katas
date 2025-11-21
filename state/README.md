# Kata : State

## Contexto
Imagina que estás programando el comportamiento de un reproductor de música o el flujo de aprobación de un documento (Borrador -> Moderación -> Publicado).

Al principio, usas una variable simple y condicionales: if (estado == "REPRODUCIENDO") { ... } else if (estado == "PAUSADO") { ... }. Pero a medida que añades más estados y transiciones (ej: "Bloqueado", "Rebobinando", "Error"), tu clase principal se llena de sentencias switch o if-else monstruosas. Cualquier cambio en la lógica de un estado requiere editar esa clase gigante, arriesgando romper el código de otros estados. Esto se vuelve insostenible y viola el principio de "Abierto/Cerrado".

## El Patrón: State
El patrón State permite que un objeto modifique su comportamiento cuando su estado interno cambia. Parece como si el objeto hubiera cambiado su clase.

La idea central es la Máquina de Estados Finitos. En lugar de guardar el estado en variables y usar condicionales, extraes cada comportamiento dependiente del estado a su propia clase.

El State resuelve el problema de la complejidad lógica al:
- **Contexto**: Es la clase original (ej: Documento). Mantiene una referencia a uno de los objetos de estado concretos que representa su estado actual.
- **Interfaz de Estado**: Define los métodos comunes que todos los estados deben tener (ej: publicar(), rechazar()).
- **Estados Concretos**: Implementan comportamientos específicos. Por ejemplo, el método publicar() en el estado Borrador mueve el documento a Moderación, pero el método publicar() en el estado Publicado no hace nada o lanza un error.

El Contexto simplemente delega el trabajo: estadoActual.publicar(). Para cambiar de estado, simplemente se reemplaza el objeto de estado dentro del Contexto.

Beneficios principales:
- **Elimina condicionales masivos**: Desaparecen los switch y if gigantes.
- **Principio de Responsabilidad Única**: El código de cada estado vive en su propia clase.
- **Transiciones explícitas**: Las reglas de transición (pasar de A a B) están claras dentro de las clases de estado, en lugar de dispersas o implícitas en variables booleanas.

## ¿Cuándo usar este patrón?
- **Comportamiento dinámico**: Cuando el comportamiento de un objeto depende de su estado y debe cambiar en tiempo de ejecución.
- **Máquinas de estados complejas**: Cuando tienes un flujo con muchas reglas y transiciones (como un pedido de e-commerce: Creado -> Pagado -> Enviado -> Entregado -> Reembolsado).
- **Código duplicado en condicionales**: Cuando tienes la misma estructura de switch repetida en varios métodos de una clase.

## Challenge

Para poner en práctica el patrón State, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.
