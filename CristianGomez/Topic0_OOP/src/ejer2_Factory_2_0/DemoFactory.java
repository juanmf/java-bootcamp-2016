package ejer2_Factory_2_0;

public class DemoFactory {
    
    static DatabaseType databaseType = DatabaseType.MySqlConnection;   
    
           
    public static void main(String[] args) {
        

        SQLConnectionFactory connectionFactory = getConnectionFactory(databaseType);

        Application application = new Application(connectionFactory);
        application.start();
      }

      private static SQLConnectionFactory getConnectionFactory(
          DatabaseType databaseType) {
        switch (databaseType) {
        case MySqlConnection:
          return new MySqlFactory();
        case SQLiteConnection:
            return new SQLiteFactory();
        default:
          return new SQLServerFactory();
        }
      }
        
       
    
    private enum DatabaseType {
        MySqlConnection, SQLServerConnection,SQLiteConnection;
      }
}
    