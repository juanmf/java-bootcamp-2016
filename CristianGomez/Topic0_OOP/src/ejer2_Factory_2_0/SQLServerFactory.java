package ejer2_Factory_2_0;

public class SQLServerFactory implements SQLConnectionFactory {

    @Override
    public SQLConnection getConnection() {
        
        return new SQLServer();
    }

}
