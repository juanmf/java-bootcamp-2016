import java.sql.DriverManager;

/**
 * Created by leandromaro on 1/7/16.
 */
public class ConnectionDB implements ConnectionBuilder {
    private DataBase dataBase;
    private static java.sql.Connection con = null;


    public ConnectionDB() {
        this.dataBase = new DataBase();
    }

    public void setConnectionData(String url, String dbName, String driver, String userName, String password) {
        dataBase.setUrl(url);
        dataBase.setDbName(dbName);
        dataBase.setDriver(driver);
        dataBase.setUserName(userName);
        dataBase.setPassword(password);
    }

    public void connect() {
        try {
            Class.forName(dataBase.getDriver()).newInstance();
            con = (java.sql.Connection) DriverManager.getConnection(dataBase.getUrl()+dataBase.getDbName(),dataBase.getUserName(),dataBase.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
