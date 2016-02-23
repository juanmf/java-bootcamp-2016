package ejer2_Factory;

public class SQLiteConnection implements SqlConnection {

	SQLiteConnection()
		{
			
		connect();
		}
		@Override
		public void connect() {
			System.out.print("\nSQLiteConnection established; ");
		}

	}