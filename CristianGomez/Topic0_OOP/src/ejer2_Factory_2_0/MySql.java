package ejer2_Factory_2_0;

public class MySql implements SQLConnection {
    
    @Override
    public void connect() {
      System.out.println("Connecting to MySQL...");
   
    }
    
}

