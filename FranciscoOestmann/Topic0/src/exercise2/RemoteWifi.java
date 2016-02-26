package exercise2;

public class RemoteWifi implements RemoteSqlConnection{

	@Override
	public void connect() {
		System.out.println("WIFI connection to a remote sql server established.");		
	}

}
