import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by leandromaro on 28/6/16.
 */
public class Demo {
    public static void main (String[] args) throws SQLException {
        ConnectionInterfaceProxy connectionInterfaceProxy = new ConnectionInterfaceProxy();
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "argentina";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "racing31720700";
        connectionInterfaceProxy.connect(url,dbName,driver,userName,password);
        Statement statement = connectionInterfaceProxy.getConnect().createStatement();
        statement.execute("SELECT * FROM `provincias`;");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
    }
}
