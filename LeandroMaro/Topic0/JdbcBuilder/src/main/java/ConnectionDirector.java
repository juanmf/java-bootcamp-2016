/**
 * Created by leandromaro on 1/7/16.
 */
public class ConnectionDirector {
    private ConnectionBuilder connectionBuilder = null;

    public ConnectionDirector(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }
    public void constructConnection(){
        connectionBuilder.setConnectionData("jdbc:mysql://localhost:3306/",
                "argentina","com.mysql.jdbc.Driver","root","racing31720700");
        connectionBuilder.connect();
    }

    private DataBase getConnectionBuilder(){
        return connectionBuilder.getDataBase();
    }
}
