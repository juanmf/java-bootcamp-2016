package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by leandromaro on 14/6/16.
 */
public class ConnectionDB {

    private static Connection con = null;

    private ConnectionDB() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "argentina";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Connected");
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    private static class LazyHolder {
        private static final ConnectionDB INSTANCE = new ConnectionDB();
    }

    public static ConnectionDB getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static Connection getConnect(){
        return con;
    }

    public static void delInstance() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




