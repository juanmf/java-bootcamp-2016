package ejer2_Factory;


	public class SQLServerConnection  implements SqlConnection {

		SQLServerConnection()
		{
			
		connect();
		}
		@Override
		public void connect() {
			System.out.print("\nSqlServerConnection established; ");
		}

	}



