package ejer3_Proxy;

public class RealOperation implements DatabaseOperation {

	@Override
	public String selectFromTable(String table, String where) {
		return "SELECT FROM " + table + " WHERE " + where;
	}

	@Override
	public String deleteFromTable(String table, String where) {
		return "DELETE FROM " + table + " WHERE " + where;
	}

	@Override
	public String updateTable(String table, String where, String values) {
		return "ALTER TABLE " + table + " SET " + values + " WHERE " + where;
	}

}