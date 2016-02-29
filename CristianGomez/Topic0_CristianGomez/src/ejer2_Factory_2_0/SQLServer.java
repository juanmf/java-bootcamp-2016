package ejer2_Factory_2_0;

public class SQLServer implements SQLConnection {

    @Override
    public String connection() {
    
        return "SQL Server Connecting";
    
    }
    
}