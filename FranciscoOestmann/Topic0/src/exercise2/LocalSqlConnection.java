package exercise2;

public class LocalSqlConnection implements SqlConnection {

	@Override
	public void createConnection() {
		System.out.println("Local  SQL connection stablished.");
	}

}
