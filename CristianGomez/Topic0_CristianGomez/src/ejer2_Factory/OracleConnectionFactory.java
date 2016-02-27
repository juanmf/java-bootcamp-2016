package ejer2_Factory;

import java.sql.Connection;

public class OracleConnectionFactory implements AbstractDBConnectionFactory {

    @Override
    public Connection getConnection() {
        return OracleConnection.getInstance();
    }

}