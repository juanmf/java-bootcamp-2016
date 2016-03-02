package builder;

import java.sql.SQLException;

public class ConnectionMysqlBuilder extends ConnectionAbstracBuilder {

	public ConnectionMysqlBuilder(String driver, String url, String pwd, String usr) throws SQLException, ClassNotFoundException {
		super(driver, url, pwd, usr);
		database = new MySqlBuilder();

	}

	@Override
	public String getDb() throws SQLException, ClassNotFoundException {
		String result;
		try {
			result = database.conectar(driver, url, usr, pwd);
		} catch (ClassNotFoundException ex) {
			throw ex;
		} catch (SQLException ex) {
			throw ex;
		}
		return result;
	}
}
