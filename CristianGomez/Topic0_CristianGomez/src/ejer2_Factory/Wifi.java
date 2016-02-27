package ejer2_Factory;

public class Wifi implements LocalSqlConnection{

    @Override
    public void connect() {
        System.out.println("WIFI connection to a local sql server established.");       
    }

}