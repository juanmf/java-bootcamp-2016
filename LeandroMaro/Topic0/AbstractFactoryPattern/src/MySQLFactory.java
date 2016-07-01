import db2.DB2;
import mysql.CoffeShop;
import mysql.MySQL;
import mysql.PetShop;

/**
 * Created by leandromaro on 25/6/16.
 */
public class MySQLFactory extends DataBaseAbstractFactory {

    @Override
    public DB2 getDB2DataBase(String DB) {
        return null;
    }

    @Override
    public MySQL getMySQLDataBase(String DB) {
        if(DB.equalsIgnoreCase("COFFEESHOP")){
            return new CoffeShop();
        }else if(DB.equalsIgnoreCase("PETSHOP")){
            return new PetShop();
        }
        return null;
    }
}
