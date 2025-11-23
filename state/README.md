# Kata : State

## Contexto
Estás creando un gestor de contenidos (como WordPress). Un documento tiene un ciclo de vida. Usaste una variable `String state = "DRAFT"`. Esto te obligó a llenar tu código de: `if (state == "DRAFT") { ... } else if (state == "PUBLISHED") { ... }`.

Este enfoque es una Máquina de Estados implementada con condicionales. El problema es que la lógica de transición (saber que después de Draft va Moderation) está mezclada con la lógica de negocio (saber que en Published no se puede escribir). Si añades un nuevo estado, el riesgo de introducir bugs en los estados existentes es altísimo. Cualquier cambio en la lógica de un estado requiere editar esa clase gigante, arriesgando romper el código de otros estados. Esto se vuelve insostenible y viola el principio de "Abierto/Cerrado".

## El Patrón: State
El patrón State permite que un objeto modifique su comportamiento cuando su estado interno cambia. Parece como si el objeto hubiera cambiado su clase.

La idea central es la Máquina de Estados Finitos. En lugar de guardar el estado en variables y usar condicionales, extraes cada comportamiento dependiente del estado a su propia clase.

El patrón State resuelve el problema de la complejidad lógica al:
- **Descentralizar la lógica**: `PublishedState` es el único lugar donde se define que "no se puede editar un documento publicado". No necesitas verificar esto en el código principal.
- **Transiciones Responsables**: Cada estado sabe cuál es su sucesor. Draft sabe crear un Moderation, pero no sabe nada sobre `Published`.
- **Comportamiento Polimórfico**: Cuando el usuario llama a `doc.publish()`, el resultado depende totalmente de qué objeto esté metido en la variable state en ese milisegundo.Publicado no hace nada o lanza un error.

Para cambiar de estado, simplemente se reemplaza el objeto de estado dentro del Contexto.

Beneficios principales:
- **Elimina condicionales masivos**: Desaparecen los switch e if gigantes.
- **Principio de Responsabilidad Única**: El código de cada estado vive en su propia clase.
- **Transiciones explícitas**: Las reglas de transición (pasar de A a B) están claras dentro de las clases de estado, en lugar de dispersas o implícitas en variables booleanas.

## ¿Cuándo usar este patrón?
- **Comportamiento dinámico**: Cuando el comportamiento de un objeto depende de su estado y debe cambiar en tiempo de ejecución.
- **Máquinas de estados complejas**: Cuando tienes un flujo con muchas reglas y transiciones (como un pedido de e-commerce: Creado -> Pagado -> Enviado -> Entregado -> Reembolsado).
- **Código duplicado en condicionales**: Cuando tienes la misma estructura de switch repetida en varios métodos de una clase.

## Challenge

Para poner en práctica el patrón State, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [Source Making - Observer Pattern](https://sourcemaking.com/design_patterns/observer)
