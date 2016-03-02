package singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		try {
			ConnectionDB con = ConnectionDB.getInstance();
			Statement stmt = con.getConnect().createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ConnectionDB.delInstance();
		}
	}

}
