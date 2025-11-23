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