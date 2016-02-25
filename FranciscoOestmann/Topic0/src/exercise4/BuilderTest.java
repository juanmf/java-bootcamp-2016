package exercise4;

public class BuilderTest {

	public static void main(String[] args) {
		
		ConnectionsBuilder connectionsBuilder = new SqlConnectionsBuilder();
		ConnectionsDirector connectionsDirector = new ConnectionsDirector(connectionsBuilder);
		connectionsDirector.createDbConnection();
		DbConnections sqlConnection = connectionsDirector.getConnection();
		System.out.println("Connection info is: " + sqlConnection);
		
		connectionsBuilder = new OracleConnectionsBuilder();
		connectionsDirector = new ConnectionsDirector(connectionsBuilder);
		connectionsDirector.createDbConnection();
		DbConnections oracleConnection = connectionsDirector.getConnection();
		System.out.println("Connection info is: " + oracleConnection);
	}

}
