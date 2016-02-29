package builderPunto4;

import java.sql.SQLException;

public class DirectorBuilder {

	ConnectionAbstractBuilder connection;
	public DirectorBuilder(ConnectionAbstractBuilder connection){
		this.connection=connection;
	}
	public void builderConnection() throws ClassNotFoundException, SQLException{
		System.out.println(connection.getDataBase());
	}
}
