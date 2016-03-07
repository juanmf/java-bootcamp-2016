package exercise2corregido;

public class LocalDAO implements ConnectionType{

	@Override
	public void connect() {
	
		System.out.println("Connected to Local Server");
	}

}
