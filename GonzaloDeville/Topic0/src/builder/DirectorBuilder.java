package builder;

import java.sql.SQLException;

public class DirectorBuilder {

	protected ConnectionAbstracBuilder connection;
	
	public DirectorBuilder(ConnectionAbstracBuilder connection) {
		this.connection = connection;
	}
	
	public void connectBuilder() throws ClassNotFoundException, SQLException{
		System.out.println(connection.getDb());
	}

}
