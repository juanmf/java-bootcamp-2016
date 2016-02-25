package Topic0.Ejercicio2;

import Topic0.Ejercicio2.SQLConnections.SQLAnotherServer;
import Topic0.Ejercicio2.SQLConnections.SQLConnection;
import Topic0.Ejercicio2.SQLConnections.SQLServer;
import Topic0.Ejercicio2.SQLConnections.SQLVipServer;

public class SQLConnectionFactory extends SQLFactory {
	
	@Override
	public SQLConnection getSQLConnection(String sqlConnection) {
		if(sqlConnection==null){
			return null;
		}else if("SQL Server 1".equals(sqlConnection)){
			return new SQLServer();
		}else if("SQL Server 2".equals(sqlConnection)){
			return new SQLVipServer();
		}else if("SQL Server 3".equals(sqlConnection)){
			return new SQLAnotherServer();
		}
		return null;
	}
}
