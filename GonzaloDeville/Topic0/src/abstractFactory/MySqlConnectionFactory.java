package abstractFactory;

public class MySqlConnectionFactory implements ConnectionFactory{

	@Override
	public Connection getConnection() {
		return new MySqlConnection();
	}
}
