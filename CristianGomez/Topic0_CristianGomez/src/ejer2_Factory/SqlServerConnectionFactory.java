package ejer2_Factory;


import java.sql.Connection;

public class SqlServerConnectionFactory implements AbstractDBConnectionFactory {

    @Override
    public Connection getConnection() {

        return SqlServerConnection.getInstance();
    }

}