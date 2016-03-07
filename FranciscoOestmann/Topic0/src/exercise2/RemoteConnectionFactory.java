package exercise2corregido;

public class RemoteConnectionFactory implements SqlConnectionFactory{

	@Override
	public ConnectionType createConnection() {
		return new RemoteDAO();
	}
	
}
