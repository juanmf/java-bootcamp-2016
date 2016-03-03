package ejer2_Factory_2_0;

public class SQLiteFactory implements SQLConnectionFactory{

    @Override
    public SQLConnection getConnection() {
      
        return new SQLite();
    }

}
