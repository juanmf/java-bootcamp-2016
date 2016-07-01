/**
 * Created by leandromaro on 25/6/16.
 */
public class DBFactoryProducer {
    public static DataBaseAbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("DB2")){
            return new DB2Factory();

        }else if(choice.equalsIgnoreCase("MYSQL")){
            return new MySQLFactory();
        }
        return null;
    }

}
