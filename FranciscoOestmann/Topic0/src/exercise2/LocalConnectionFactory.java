package exercise2corregido;

public class LocalConnectionFactory implements SqlConnectionFactory{

	@Override
	public ConnectionType createConnection() {
		return new LocalDAO();
	}

}
