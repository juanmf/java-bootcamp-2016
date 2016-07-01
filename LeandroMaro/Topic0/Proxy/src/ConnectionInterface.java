import java.sql.Connection;

/**
 * Created by leandromaro on 28/6/16.
 */
public interface ConnectionInterface {
    void connect (String url, String dbName, String driver, String userName, String password) throws Exception;
    Connection getConnect();
}
