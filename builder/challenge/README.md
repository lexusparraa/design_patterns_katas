# Reto (Builder)


## Instrucciones
Refactoriza la clase `DatabaseHelper`. El método `createSelectQuery` sufre del problema de los "Parámetros Telescópicos" en el método. Para hacer una consulta simple, el desarrollador está obligado a pasar `null` o `0` a un montón de parámetros que no le interesan (como `orderBy`, `limit`, `offset`). Además, el orden de los argumentos es confuso (¿el `where` iba antes o después del `orderBy?`).

Tu solución debe permitir construir consultas SQL complejas de forma legible y fluida, sin necesidad de pasar nulos explícitos.

## Código a Refactorizar

**Archivo: `challenge/DatabaseHelper.java`**
```java
package builder.challenge;

public class DatabaseHelper {
    
    // PROBLEMA: Demasiados argumentos. Es fácil confundir el orden.
    // Si no quiero filtrar (where) ni ordenar (orderBy), debo pasar nulls.
    public String createSelectQuery(String table, String[] columns, String whereClause, String orderBy, Integer limit, Integer offset) {
        StringBuilder query = new StringBuilder("SELECT ");
        
        if (columns == null || columns.length == 0) {
            query.append("*");
        } else {
            query.append(String.join(", ", columns));
        }
        
        query.append(" FROM ").append(table);
        
        if (whereClause != null && !whereClause.isEmpty()) {
            query.append(" WHERE ").append(whereClause);
        }
        
        if (orderBy != null && !orderBy.isEmpty()) {
            query.append(" ORDER BY ").append(orderBy);
        }
        
        if (limit != null) {
            query.append(" LIMIT ").append(limit);
        }
        
        if (offset != null) {
            query.append(" OFFSET ").append(offset);
        }
        
        return query.toString() + ";";
    }
}
```

**Archivo: `challenge/Main.java`**
```java
package builder.challenge;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper db = new DatabaseHelper();
        
        // El código cliente es sucio y difícil de leer:
        // ¿Qué son esos nulos? ¿Cuál es el límite y cuál el offset?
        String query = db.createSelectQuery("users", new String[]{"name", "email"}, "age > 18", null, 10, 0);
        
        System.out.println(query);
        
        // Peor aún para consultas simples:
        String simpleQuery = db.createSelectQuery("products", null, null, null, null, null);
        System.out.println(simpleQuery);
    }
}
```

## tips

- 💡 **Clase dedicada**: Crea una clase `SqlQueryBuilder`.
- 💡 **Acumulación de estado**: El builder debe guardar internamente las partes de la query (`table`, `columns`, `wheres`, etc.) en variables mientras se construye.
- 💡 **Fluent Interface**: Haz que `select()`, `where()`, etc., retornen `this`.
- 💡 **Validación final**: El método `.build()` es el encargado de juntar todo el String y verificar que al menos haya una tabla definida (no se puede hacer select de la nada).

## Recursos Adicionales

- [Refactoring Guru - Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- [Source Making - Factory Pattern](https://sourcemaking.com/design_patterns/factory_method)
