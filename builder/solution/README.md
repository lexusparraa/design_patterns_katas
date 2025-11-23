# Solución (Builder)

⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. `SqlBuilder`: Una clase que reemplaza al método gigante.
2. Verbos como métodos: En lugar de parámetros posicionales, usamos métodos con nombres claros (`.from()`, `.where()`).
3. Flexibilidad: Puedes llamar a `.where()` varias veces (si lo diseñas así) o no llamarlo nunca. El código resultante se lee casi como SQL real.

## Salida Esperada

```
Generated Query: SELECT name, email FROM users WHERE age > 18 LIMIT 10;
Generated Query: SELECT * FROM products;
```
