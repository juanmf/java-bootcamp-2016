package exercise4;

public class OracleConnectionsBuilder implements ConnectionsBuilder{

	private DbConnections dbConnection;
	
	public OracleConnectionsBuilder(){
		dbConnection = new DbConnections();
	}

	
	@Override
	public void buildUrl() {
		dbConnection.setUrl("https:\\localhost");
	}

	@Override
	public void buildUser() {
		dbConnection.setUser("Nico");
	}

	@Override
	public void buildPassword() {
		dbConnection.setPassword("qwe");
	}

	@Override
	public void buildConnectionAddress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DbConnections getConnectionAddress() {
		return dbConnection;
	}

}
