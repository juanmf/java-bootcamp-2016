package ejer2_Factory;

public class RemoteLan implements RemoteSqlConnection{

    @Override
    public void connect() {
        System.out.println("LAN connection to a remote sql server established.");
    }
    
}