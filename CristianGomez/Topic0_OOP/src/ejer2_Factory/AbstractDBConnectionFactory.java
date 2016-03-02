package ejer2_Factory;


import java.sql.Connection;

public interface AbstractDBConnectionFactory {
    public Connection getConnection();
}