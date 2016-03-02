package user.service.main;

/**
 * @author frann
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class UserServiceDAOImpl implements UserServiceDAO {

	//State
	Connection conn = null;
	DbClient user = new DbClient();
	
	
	//Behavior
	/**
	 * Connects to a  MySQL database, asking for URL, USER, and PASS input from the user
	 * If more functionality is necessary, can be converted into a DAO Factory to manage different database types
	 */
	public Connection connect(String url, String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			
			conn = DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}

	/**
	 * Disconnects from the database
	 */
	@Override
	public void disconnect() {
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
