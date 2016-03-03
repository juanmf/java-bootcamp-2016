package builderPunto4;

/**
 * @author choco
 *
 */
public class Connection {

	private final String driver;

	private Connection(ConnectionBuilderPostgreSQL connBuilder) {
		this.driver = connBuilder.driver;
		System.out.println("Connection Path: " + driver);
		System.out.println("postgreSQL Connection established");

	}

	public static class ConnectionBuilderPostgreSQL {

		private static String conn;

		private String driver;

		public ConnectionBuilderPostgreSQL(String conn) {
			this.conn = conn;
		}

		public ConnectionBuilderPostgreSQL connectionPath(String driver) {
			this.driver = driver;
			return this;
		}

		public Connection build() {
			Connection connection = new Connection(this);
			return connection;
		}

	}

	

}