package exercise4;

public class SqlConnectionsBuilder implements ConnectionsBuilder{

	private DbConnections dbConnection;
	
	public SqlConnectionsBuilder(){
		dbConnection = new DbConnections();
	}

	@Override
	public void buildUrl() {
		dbConnection.setUrl("https:\\localhost");
	}

	@Override
	public void buildUser() {
		dbConnection.setUser("Frann");
	}

	@Override
	public void buildPassword() {
		dbConnection.setPassword("asd");
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
