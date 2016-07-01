package db2;

/**
 * Created by leandromaro on 24/6/16.
 */
public class LibraryDB implements DB2 {

    @Override
    public void getConnectDB(String host) {
        System.out.println("Connected to: "+ super.getClass().toString() + " at: " + host);
    }
}
