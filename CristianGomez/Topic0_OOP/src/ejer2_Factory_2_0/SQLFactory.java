package ejer2_Factory_2_0;



public interface SQLFactory {

    public abstract SQLConnection getSQLConnection(String sqlConnection);

}
