package ejer2_Factory_2_0;

public class MySql implements SQLConnection {
    
    @Override
    public String connection() {
    
        return "MySQL Connecting";
    
    }
    
}

