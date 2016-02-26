package builder;

import java.sql.SQLException;

public class ConnectionPostgreSqlBuilder extends ConnectionAbstracBuilder {

	public ConnectionPostgreSqlBuilder(String driver, String url, String pwd, String usr) throws ClassNotFoundException, SQLException {
		super(driver, url, pwd, usr);
		database = new PostgreSqlBuilder();
		
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
