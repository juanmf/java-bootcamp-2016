package ejer1_Singleton;

import java.sql.*;


public class DbSingleton {
	public static DbSingleton db;
    private static String db_url;
    private static String db_port;
    private static String db_name;
    private static String db_user;
    private static String db_password;
    private static Statement connection;

    private DbSingleton() {

        db_url = "jdbc:mysql://localhost";
        db_port = "3306";
        db_name = "mysql";
        db_user = "root";
        db_password = "admin";

        connection = setConnection();
    }

    private static Statement setConnection() {
        try {
            String url = "" + db_url + ":" + db_port + "/" + db_name + "";
            java.sql.Connection conn = DriverManager.getConnection(url, db_user, db_password);           
            java.sql.Statement state = conn.createStatement();
            return (Statement) state;
        	} 
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return null;
    }
    
    public static synchronized DbSingleton getInstance() {
        if ( db == null ) {
            db = new DbSingleton();
        }
        return db;
 
    }

    public static Statement getStatement() {
        return connection;
    }
}