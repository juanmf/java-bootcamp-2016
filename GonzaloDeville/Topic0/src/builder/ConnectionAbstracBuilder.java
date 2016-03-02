package builder;

import java.sql.SQLException;

public abstract class ConnectionAbstracBuilder {

	protected String driver;
	protected String url;
	protected String pwd;
	protected String usr;

	protected Sql database;
	
	public ConnectionAbstracBuilder(String driver, String url, String pwd, String usr) {
		this.driver = driver;
		this.url = url;
		this.usr = usr;
		this.pwd = pwd;
	}
	
	public abstract String getDb() throws SQLException, ClassNotFoundException;
}
