package exercise2corregido;

public class RemoteDAO implements ConnectionType{

	@Override
	public void connect() {
		
		System.out.println("Connected to Remote Server");
	}

}
