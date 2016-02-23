package ejer2_Factory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		AbstractDBConnectionFactory conFactory = new DBConnectionFactory();
		conFactory.getConnection("MySqlConnection");
		conFactory.getConnection("SQLiteConnection");
		conFactory.getConnection("SQLServerConnection");
}
	}