package ejer3_Proxy;

public interface DatabaseOperation {

    public String selectFromTable(String table, String where);

    public String deleteFromTable(String table, String where);

    public String updateTable(String table, String where, String values);

}
