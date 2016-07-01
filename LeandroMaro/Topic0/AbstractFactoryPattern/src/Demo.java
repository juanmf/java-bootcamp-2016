import db2.DB2;
import mysql.MySQL;

/**
 * Created by leandromaro on 25/6/16.
 */
public class Demo {
    public static void main (String[] args){
        //get DB2 factory
        DataBaseAbstractFactory db2Factory = DBFactoryProducer.getFactory("DB2");

        //get an object of Library
        DB2 db2DataBase1 = db2Factory.getDB2DataBase("LIBRARY");

        db2DataBase1.getConnectDB("localhost");

        //get an object of STORE
        DB2 db2DataBase2 = db2Factory.getDB2DataBase("STORE");

        db2DataBase2.getConnectDB("127.0.0.1");

        //get MYSQL factory
        DataBaseAbstractFactory mySQLFactory = DBFactoryProducer.getFactory("MYSQL");

        //get an object of Color Red
        MySQL mySQLDataBase1 = mySQLFactory.getMySQLDataBase("COFFEESHOP");

        mySQLDataBase1.getConnectDB("192.168.0.1");

        MySQL mySQLDataBase2 = mySQLFactory.getMySQLDataBase("PETSHOP");

        mySQLDataBase2.getConnectDB("192.168.0.0");
    }
}
