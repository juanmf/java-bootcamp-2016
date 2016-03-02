package ejer2_Factory_2_0;

public class DemoFactory {
    
    public static void main(String[] args) {
        SQLFactory sqlfactory= FactoryProducer.getFactory("SQLConnection");
        
        SQLConnection connection1= sqlfactory.getSQLConnection("MySqlConnection");
        SQLConnection connection2= sqlfactory.getSQLConnection("SQLServerConnection");
        SQLConnection connection3= sqlfactory.getSQLConnection("SQLiteConnection");
        
        System.out.println(connection1.connection());
        System.out.println(connection2.connection());
        System.out.println(connection3.connection());
        
    }
}