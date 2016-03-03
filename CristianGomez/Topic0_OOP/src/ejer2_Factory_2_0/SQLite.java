package ejer2_Factory_2_0;

public class SQLite implements SQLConnection {
    
    @Override
    public void connect() {
      System.out.println("Connecting to SQLite...");
    }
    
}

