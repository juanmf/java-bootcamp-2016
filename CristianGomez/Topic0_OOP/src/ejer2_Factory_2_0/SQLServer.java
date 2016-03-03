package ejer2_Factory_2_0;

public class SQLServer implements SQLConnection {

    @Override
    public void connect() {
      System.out.println("Connecting to SQLServer...");
    }
    
}