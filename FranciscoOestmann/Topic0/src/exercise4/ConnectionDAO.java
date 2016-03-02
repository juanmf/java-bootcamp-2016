package exercise4;

import java.sql.*;

public class ConnectionDAO {

	Connection conn = null;

	public void connect(){
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(getUrlAddress());
			
			////Print on console to verify the connection
			System.out.println("Connected");
		} catch (Exception e) {
			
			System.out.println(e);
		}*/
		System.out.println("Connected");
	}
	
	public String getUrlAddress(){
		ConnectionsBuilder connectionsBuilder = new SqlConnectionsBuilder();
		ConnectionsDirector connectionsDirector = new ConnectionsDirector(connectionsBuilder);
		connectionsDirector.createDbConnection();
		DbConnections sqlConnection = connectionsDirector.getConnection();
		
		return sqlConnection.toString();
		
	}
	
}
