package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cota
 *
 */
public class ConnectionDB {

	private static Connection con = null;
	private static ConnectionDB instance = null;


	private ConnectionDB() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1/MyDataBase";
			String pwd = "admin";
			String usr = "user";
			Class.forName(driver);

			con = DriverManager.getConnection(url, usr, pwd);

		} catch (SQLException ex) {

			System.err.println(ex.getMessage());

		} catch (ClassNotFoundException ex) {

			System.err.println(ex.getMessage());

		}
	}


	public static synchronized ConnectionDB getInstance() {
		if (instance == null) {
			instance = new ConnectionDB();
			System.out.println("coneccion realizada");
		}
		return instance;
	}

	
	public static Connection getConnect() {
		return con;
	}

	private static void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexión.");
		}
	}

	public static void delInstance() {
		closeConnection();
		instance = null;
	}
}
