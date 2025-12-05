package builder.solution;

import java.util.ArrayList;
import java.util.List;

public class SqlQueryBuilder {

    private String table;
    private List<String> columns = new ArrayList<>();
    private List<String> whereClauses = new ArrayList<>();
    private String orderBy;
    private Integer limit;
    private Integer offset;

    public SqlQueryBuilder() {
        // Constructor vacío
    }

    // Paso 1: Definir la tabla (Obligatorio para que la query sea válida al final, 
    // pero lo validamos en el build)
    public SqlQueryBuilder from(String table) {
        this.table = table;
        return this; // Retornamos 'this' para Fluent Interface
    }

    // Paso 2: Definir columnas. Si se llama varias veces, se acumulan.
    public SqlQueryBuilder select(String... columns) {
        if (columns != null) {
            for (String col : columns) {
                this.columns.add(col);
            }
        }
        return this;
    }

    // Paso 3: Cláusulas Where. Permite agregar múltiples condiciones.
    public SqlQueryBuilder where(String condition) {
        if (condition != null && !condition.isEmpty()) {
            this.whereClauses.add(condition);
        }
        return this;
    }

    public SqlQueryBuilder orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public SqlQueryBuilder limit(int limit) {
        this.limit = limit;
        return this;
    }

    public SqlQueryBuilder offset(int offset) {
        this.offset = offset;
        return this;
    }

    // El método final que construye el String
    public String build() {
        // Validación final
        if (table == null || table.isEmpty()) {
            throw new IllegalStateException("La consulta debe tener una tabla definida (método .from())");
        }

        StringBuilder query = new StringBuilder("SELECT ");

        // Manejo de columnas (si está vacío, es *)
        if (columns.isEmpty()) {
            query.append("*");
        } else {
            query.append(String.join(", ", columns));
        }

        query.append(" FROM ").append(table);

        // Manejo inteligente del WHERE
        if (!whereClauses.isEmpty()) {
            query.append(" WHERE ").append(String.join(" AND ", whereClauses));
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