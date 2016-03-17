package ejer2_Factory_2_0;

public class Application  {

    private final SQLConnectionFactory connectionFactory;

    public Application(SQLConnectionFactory connectionFactory) {
      this.connectionFactory = connectionFactory;
    }

    public void start() {
        SQLConnection connection = connectionFactory.getConnection();
      connection.connect();
    }
}
    