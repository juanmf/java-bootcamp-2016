package builderPunto4;

import java.sql.SQLException;

public class ConnectionPostgreSQLBuilder extends ConnectionAbstractBuilder {
	
	public ConnectionPostgreSQLBuilder(String driver, String url, String usr, String pwd) throws SQLException {
		super(driver, url, usr, pwd);
		dataBase=new PostgreSQL();
				
	}
	
	public String getDataBase() throws SQLException, ClassNotFoundException {
		String ddbb;
		try {
			ddbb = dataBase.conectar(driver, url, usr, pwd);
		} catch (SQLException ex) {
			throw ex;
		} catch (ClassNotFoundException ex) {
			throw ex;
		}
		return ddbb;
	}
	
}
