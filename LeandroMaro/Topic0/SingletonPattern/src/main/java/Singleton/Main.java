package Singleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by leandromaro on 14/6/16.
 */
public class Main {
    public static void main(String[] args){
        ConnectionDB connectionDB = ConnectionDB.getInstance();
        try {
            Statement statement = connectionDB.getConnect().createStatement();
            statement.execute("SELECT * FROM `provincias`;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.delInstance();
        }
    }
}
