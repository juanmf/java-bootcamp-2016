package ejer1_Singleton;

import java.sql.*;

/** Class singleton example for a database connection.
 * @author cristian Gomez
 * @since 1.0
 * @version 1.0
 *
 */

public class DbSingleton {
    public static DbSingleton db;
    private static String db_url;
    private static String db_port;
    private static String db_name;
    private static String db_user;
    private static String db_password;
    private static Statement connection;

    private DbSingleton() {
        /* 
         *Default database parameters 
         */
        db_url = "jdbc:mysql://localhost";
        db_port = "3306";
        db_name = "mysql";
        db_user = "root";
        db_password = "admin";
        /* Creation of an instance of the connection statement*/
        connection = setConnection();
    }
    /* Private method charge to set the connection statement*/
    private static Statement setConnection() {
        try {
            String url = db_url + ":" + db_port + "/" + db_name;
            java.sql.Connection conn = DriverManager.getConnection(url, db_user, db_password);
            /* Private method charge to set the connection statement*/
            java.sql.Statement state = conn.createStatement();
            return  state;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * @return
Public method, which is the only method allowed to return an instance of 
the singleton (the instance here is the database connection statement)
     */
    public static synchronized DbSingleton getInstance() {
        if (db == null) {
            db = new DbSingleton();
        }
        return db;

    }

    public static Statement getStatement() {
        return connection;
    }
}