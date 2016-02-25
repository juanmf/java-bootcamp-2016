package Topic0.Ejercicio2;

import Topic0.Ejercicio2.SQLConnections.SQLConnection;

public abstract class SQLFactory {
	public abstract SQLConnection getSQLConnection(String sqlConnection);
}
