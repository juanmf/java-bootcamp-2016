package mysql;

/**
 * Created by leandromaro on 24/6/16.
 */
public class PetShop implements MySQL {
    @Override
    public void getConnectDB(String host) {
        System.out.println("Connected to: "+ super.getClass().toString() + " at: " + host);
    }
}
