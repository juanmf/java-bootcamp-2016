package ejer2_Factory;

import java.sql.Connection;

public class MySqlConnectionFactory implements AbstractDBConnectionFactory {

    @Override
    public Connection getConnection() {
        return MySqlConnection.getInstance();

    }

}