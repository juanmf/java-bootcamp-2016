package exercise4;

public class ConnectionsDirector {

	ConnectionsBuilder connectionsBuilder = null;
	
	public ConnectionsDirector(ConnectionsBuilder connectionsBuilder){
		this.connectionsBuilder = connectionsBuilder;
	}
	
	public void createDbConnection(){
		connectionsBuilder.buildUrl();
		connectionsBuilder.buildUser();
		connectionsBuilder.buildPassword();
	}
	
	public DbConnections getConnection(){
		return connectionsBuilder.getConnectionAddress();
	}
}
