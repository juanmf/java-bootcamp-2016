package exercise2corregido;

public class Main {

	public static void main(String[] args) {
		
		SqlConnectionFactory fact = new LocalConnectionFactory();
		SqlConnectionFactory fact2 = new RemoteConnectionFactory();
		
		fact.createConnection().connect();
		fact2.createConnection().connect();;
		
	}
}
