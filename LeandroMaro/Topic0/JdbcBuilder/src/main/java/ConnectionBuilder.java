/**
 * Created by leandromaro on 1/7/16.
 */
public interface ConnectionBuilder {
    void setConnectionData(String url, String dbName, String driver, String userName, String password);
    void connect();
    DataBase getDataBase();
}
