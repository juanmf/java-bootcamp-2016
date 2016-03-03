package DAOPunto3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected Connection conexion;

	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1/MyDataBase";
	private final String pwd = "admin";
	private final String usr = "user";

	public void conectar() throws SQLException, ClassNotFoundException {
		try {

			conexion = DriverManager.getConnection(url, usr, pwd);
			Class.forName(driver);

		} catch (SQLException ex) {

			throw ex;

		} catch (ClassNotFoundException ex) {

			throw ex;
		}
	}

	public void cerrar() throws SQLException {
		if (!(conexion == null)) {
			if (!conexion.isClosed()) {
				conexion.close();
			}
		}
	}
}
