package exercise2;

public class RemoteSqlConnection implements SqlConnection {

	@Override
	public void createConnection() {
		System.out.println("Remote  SQL connection stablished.");

	}

}
