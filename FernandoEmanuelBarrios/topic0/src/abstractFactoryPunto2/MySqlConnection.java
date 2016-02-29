package abstractFactoryPunto2;



public class MySqlConnection implements Connection {

  @Override
  public void connect() {
    System.out.println("Connecting to MySQL...");
  }

}
