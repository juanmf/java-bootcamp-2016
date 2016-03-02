package ejer2_Factory_2_0;

public class SQLite implements SQLConnection {
    @Override
    public String connection() {
    
        return "SQLite Connecting";
    
    }
    
}

