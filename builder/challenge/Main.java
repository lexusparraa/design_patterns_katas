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