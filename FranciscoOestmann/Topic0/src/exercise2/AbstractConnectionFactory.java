package exercise2;

public abstract class AbstractConnectionFactory {
	
	abstract LocalSqlConnection getLocalType(String local);
	abstract RemoteSqlConnection getRemoteType(String remote);
}
