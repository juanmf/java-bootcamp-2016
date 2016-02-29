package ejer2_Factory_2_0;

import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;

public class DBConnectionFactory implements SQLFactory {

    private Map<String, SQLConnection> ConcreteFactories = new HashMap<>();

    public  DBConnectionFactory () {
        ConcreteFactories.put("MySqlConnection", new MySql());
        ConcreteFactories.put("SQLServerConnection", new SQLServer());
        ConcreteFactories.put("SQLiteConnection", new SQLite());
    }
    
    @Override
    public SQLConnection getSQLConnection(String conType)throws IllegalFormatException {
        return ConcreteFactories.get(conType);
    }
}
