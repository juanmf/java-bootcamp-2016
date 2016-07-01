import java.sql.Connection;

/**
 * Created by leandromaro on 28/6/16.
 */
public class ConnectionInterfaceProxy implements ConnectionInterface {
    private static Connection con = null;
    @Override
    public void connect(String url, String dbName, String driver, String userName, String password) {
        if (!url.isEmpty() || !dbName.isEmpty() || !driver.isEmpty() || !userName.isEmpty() ||
                !password.isEmpty()){
            ConnectionDB connectionDB = new ConnectionDB();
            try {
                connectionDB.connect(url, dbName, driver, userName, password);
                con = connectionDB.getConnect();
            } catch (Exception e) {
                System.out.println("Can not connect propertly");
            }
        }
    }

    @Override
    public Connection getConnect() {
        return con;
    }
}
