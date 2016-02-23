package ejer3_Proxy;

public class ProxyOperation implements DatabaseOperation {


	RealOperation realOperation;

	@Override
	public String selectFromTable(String table, String where) {
		if (realOperation == null)
			realOperation = new RealOperation();

		return "Real operation triggered \n" + realOperation.selectFromTable(table, where);
	}

	@Override
	public String deleteFromTable(String table, String where) {
		if (realOperation == null)
			realOperation = new RealOperation();
		return "Real operation triggered \n" + realOperation.deleteFromTable(table, where);
	}

	@Override
	public String updateTable(String table, String where, String values) {
		if (realOperation == null)
			realOperation = new RealOperation();
		return "Real operation triggered \n" + realOperation.updateTable(table, where, values);
	}

}