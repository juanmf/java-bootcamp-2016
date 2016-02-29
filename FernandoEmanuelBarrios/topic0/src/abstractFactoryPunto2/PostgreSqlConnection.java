package abstractFactoryPunto2;


public class PostgreSqlConnection implements Connection {

  @Override
  public void connect() {
    System.out.println("Connecting to PostgreSQL...");
  }

}