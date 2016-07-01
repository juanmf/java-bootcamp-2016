/**
 * Created by leandromaro on 1/7/16.
 */
public class Demo {
    public static void main(String[] args){
        ConnectionBuilder connectionBuilder = new ConnectionDB();
        ConnectionDirector connectionDirector = new ConnectionDirector(connectionBuilder);
        connectionDirector.constructConnection();
        DataBase dataBase = connectionBuilder.getDataBase();
        System.out.println("Works " + dataBase);
    }
}
