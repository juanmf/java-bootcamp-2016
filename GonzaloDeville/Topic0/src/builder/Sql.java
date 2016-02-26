package builder;

import java.sql.SQLException;

public interface Sql {
	
	public String conectar(String driver, String url, String usr, String pwd) throws SQLException, ClassNotFoundException;

}
