package exercise4corregido;

public class ConnDirector {

	private ConnectionBuilder connBuilder = null;

	public ConnDirector(ConnectionBuilder connBuilder) {
		this.connBuilder = connBuilder;
	}
	
	public void connect(){
		connBuilder.buildConnection();
	}
	
	public SqlConnection getConnection(){
		return connBuilder.getConnection();
	}
	
}
