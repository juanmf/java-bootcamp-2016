package ejer2_Factory;

import java.util.*;

public class DBConnectionFactory extends AbstractDBConnectionFactory {

	@Override
	public SqlConnection getConnection(String conType)throws IllegalFormatException {

		if (conType.equalsIgnoreCase("MySqlConnection")) {
			return new MySqlConnection();
		} else if (conType.equalsIgnoreCase("SQLServerConnection")) {
			return new SQLServerConnection();
		} else if (conType.equalsIgnoreCase("SQLiteConnection")) {
			return new SQLiteConnection();
		} else
			try {
				throw new InvalidDBConnectionTypeException("Illegal connection");
			} catch (InvalidDBConnectionTypeException e) {
				e.printStackTrace();
			}

	return null;

	}

}