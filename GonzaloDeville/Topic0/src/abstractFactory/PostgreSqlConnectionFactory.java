package abstractFactory;

public class PostgreSqlConnectionFactory implements ConnectionFactory {

	@Override
	public Connection getConnection() {
		return new PostgreSqlConnection();
	}
}
