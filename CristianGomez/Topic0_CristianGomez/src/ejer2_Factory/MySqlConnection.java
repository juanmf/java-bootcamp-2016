package ejer2_Factory;

public class MySqlConnection  implements SqlConnection {

	MySqlConnection()
	{
		
	connect();
	}
	@Override
	public void connect() {
		System.out.print("\nMySqlConnection established; ");
	}

}


