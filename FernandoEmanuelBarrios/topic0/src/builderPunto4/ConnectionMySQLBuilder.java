package builderPunto4;

import java.sql.SQLException;

public class ConnectionMySQLBuilder extends ConnectionAbstractBuilder {

	public ConnectionMySQLBuilder(String driver, String url, String usr, String pwd) throws SQLException, ClassNotFoundException {
		super(driver, url, usr, pwd);
		dataBase = new MySQL();

	}

	@Override
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
