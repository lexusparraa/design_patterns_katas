package builder.solution;

public class Main {
    public static void main(String[] args) {
        
        // EJEMPLO 1: Consulta Compleja
        // Antes: db.createSelectQuery("users", new String[]{"name", "email"}, "age > 18", null, 10, 0);
        // Ahora: Fluent Interface legible
        
        SqlQueryBuilder userQueryBuilder = new SqlQueryBuilder();
        
        String complexQuery = userQueryBuilder
                .from("users")
                .select("name", "email")
                .where("age > 18")
                .where("active = true") // Podemos encadenar múltiples wheres si queremos
                .limit(10)
                .offset(0)
                .build();
        
        System.out.println("Generated Query 1: " + complexQuery);

        
        // EJEMPLO 2: Consulta Simple
        // Antes: db.createSelectQuery("products", null, null, null, null, null);
        // Ahora: Solo especificamos lo que necesitamos
        
        String simpleQuery = new SqlQueryBuilder()
                .from("products")
                .build(); // Por defecto selecciona * si no llamamos a .select()
        
        System.out.println("Generated Query 2: " + simpleQuery);
    }
}