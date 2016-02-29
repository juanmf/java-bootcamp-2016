package abstractFactoryPunto2;


public class Main {

  public static void main(String[] args) {

    DatabaseType databaseType = DatabaseType.MYSQL;
    ConnectionFactory connectionFactory = 
             getConnectionFactory(databaseType);

    Application application = new Application(connectionFactory);
    application.start();
  }

  private static ConnectionFactory getConnectionFactory(
      DatabaseType databaseType) {
    switch (databaseType) {
    case MYSQL:
      return new MySqlConnectionFactory();
    default:
      return new PostgreSqlConnectionFactory();
    }
  }

  private enum DatabaseType {
    MYSQL, POSTGRE;
  }

}
