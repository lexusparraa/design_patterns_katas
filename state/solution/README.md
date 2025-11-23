# Solución (State)

⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. **Interfaz `State`**: Define las acciones comunes (`addText`, `publish`, `reject`).
2. **Estados Concretos**: Tres clases (`DraftState`, `ModerationState`, `PublishedState`) que implementan la lógica específica.
3. **Transiciones encapsuladas**: Ahora es el estado `Draft` quien sabe que el siguiente paso es `Moderation`. El documento no sabe nada de reglas de transición.

## Salida Esperada

```
Text added. Current content: Hello World
[Draft -> Moderation] Document sent for review.
Text added. Current content: Hello World (Edit attempt)
[Moderation -> Published] Document approved and published.
Error: Cannot edit a published document.
Error: Cannot reject a published document.
```
