package ejer2_Factory;

public abstract class AbstractConnectionFactory {

    abstract LocalSqlConnection getLocalType(String local);

    abstract RemoteSqlConnection getRemoteType(String remote);
}
