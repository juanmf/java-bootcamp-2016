package exercise4;

public class MainApp {

	public static void main(String[] args) {

		ConnectionType conn = new ConnectionType.ConnectionBuilder()
				.setConnectionType("Sql")
				.setConnectionUrl("localhost:8080").setDriver("com.mysql.jdbc.Driver").buildConnecttion();
		
		System.out.println(conn);
	}

}
