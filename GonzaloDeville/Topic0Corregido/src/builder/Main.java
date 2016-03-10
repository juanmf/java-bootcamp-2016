package builder;

import java.sql.*;

/**
 * @author cota
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConnectionType connectionType = new ConnectionType.ConnectionBuilder("Test")
				.timeout(15)
				.driver("com.mysql.jdbc.Driver")
				.url("jdbc:postegrsql://192.168.2.10:3306/test")
				.build();
	}
}