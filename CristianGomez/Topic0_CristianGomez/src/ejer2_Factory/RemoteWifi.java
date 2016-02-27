package ejer2_Factory;

public class RemoteWifi implements RemoteSqlConnection{

    @Override
    public void connect() {
        System.out.println("WIFI connection to a remote sql server established.");      
    }

}