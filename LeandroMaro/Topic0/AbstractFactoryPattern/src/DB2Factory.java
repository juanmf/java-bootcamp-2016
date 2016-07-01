import db2.DB2;
import db2.LibraryDB;
import db2.StoreDB;
import mysql.MySQL;

/**
 * Created by leandromaro on 24/6/16.
 */
public class DB2Factory extends DataBaseAbstractFactory {

    @Override
    public DB2 getDB2DataBase(String DB) {
        if(DB.equalsIgnoreCase("LIBRARY")){
            return new LibraryDB();
        }else if(DB.equalsIgnoreCase("STORE")){
            return new StoreDB();
        }
        return null;
    }

    @Override
    public MySQL getMySQLDataBase(String DB) {
        return null;
    }
}
