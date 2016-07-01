
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Created by leandromaro on 28/6/16.
 */
public class ConnectionDB implements ConnectionInterface {
    private static Connection con = null;

    @Override
    public void connect(String url, String dbName, String driver, String userName, String password) throws Exception  {
        Class.forName(driver).newInstance();
        con = (Connection) DriverManager.getConnection(url+dbName,userName,password);
    }

    @Override
    public Connection getConnect() {
        return con;
    }


}
