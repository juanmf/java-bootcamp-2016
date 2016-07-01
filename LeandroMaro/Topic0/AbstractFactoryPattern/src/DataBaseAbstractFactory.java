import db2.DB2;
import mysql.MySQL;

/**
 * Created by leandromaro on 24/6/16.
 */
public abstract class DataBaseAbstractFactory {
    public abstract DB2 getDB2DataBase(String DB);
    public abstract MySQL getMySQLDataBase(String DB);
}
