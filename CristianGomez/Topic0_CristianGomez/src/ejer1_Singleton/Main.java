package ejer1_Singleton;


import java.sql.*;

public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		/* Creation of the statement instance */
		DbSingleton single = DbSingleton.getInstance();
		Statement state = DbSingleton.getStatement();
		/* put your SQL code in the variable sqlString */
		String sqlString = "" ;
		ResultSet result = state.executeQuery(sqlString);
	}

}
