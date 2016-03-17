package ejer2_Factory_2_0;

public class MySqlFactory implements SQLConnectionFactory {

    @Override
    public SQLConnection getConnection() {
        
        return new MySql();
    }

}
