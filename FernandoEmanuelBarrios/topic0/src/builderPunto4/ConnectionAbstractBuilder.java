package builderPunto4;

import java.sql.SQLException;

public abstract class ConnectionAbstractBuilder {
	protected SQL dataBase; 
	
	protected String driver;
	protected String url;
	protected String usr;
	protected String pwd;
	
	public ConnectionAbstractBuilder(String driver, String url, String usr, String pwd){
		this.driver=driver;
		this.url=url;
		this.usr=usr;
		this.pwd=pwd;
	}
	public abstract String getDataBase() throws SQLException,ClassNotFoundException;
}
