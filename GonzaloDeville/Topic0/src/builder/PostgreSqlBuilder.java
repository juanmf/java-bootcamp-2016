package builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlBuilder implements Sql {

	@Override
	public String conectar(String driver, String url, String usr, String pwd) throws SQLException, ClassNotFoundException {
			try {

			Connection conexion = DriverManager.getConnection(url, usr, pwd);
			Class.forName(driver);
			

		} catch (SQLException ex) {

			throw ex;

		} catch (ClassNotFoundException ex) {

			throw ex;
		}
		
		return "Connecting to PostgreSql";
	}

}
