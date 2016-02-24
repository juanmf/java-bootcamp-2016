package exercise2;

public class Lan implements LocalSqlConnection{

	@Override
	public void connect() {
		System.out.println("LAN connection to a local sql server established.");
	}

}
