package ejer2_Factory_2_0;



public class DemoFactory {
    
    static DatabaseType databaseType = DatabaseType.MySqlConnection;
    public static void main(String[] args) {
        
        DBConnectionFactory connectionFactory= new DBConnectionFactory();
        SQLConnection sql= connectionFactory.getSQLConnection(databaseType.toString());
        sql.connect();
        
       
    }
    private enum DatabaseType {
        MySqlConnection, SQLServerConnection,SQLiteConnection;
      }
}