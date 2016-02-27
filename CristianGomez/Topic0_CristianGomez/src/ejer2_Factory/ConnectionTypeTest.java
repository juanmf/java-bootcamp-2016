package ejer2_Factory;
public class ConnectionTypeTest {

    public static void main(String[] args) {

        AbstractConnectionFactory localConn = ConnGenerator.getConnect("local");
        
        System.out.println();
        LocalSqlConnection conn1 = localConn.getLocalType("lan");
        conn1.connect();
        
        System.out.println();
        LocalSqlConnection conn2 = localConn.getLocalType("wifi");
        conn2.connect();
        
        
        AbstractConnectionFactory remoteConn = ConnGenerator.getConnect("remote");
        
        System.out.println();
        RemoteSqlConnection remConn1 = remoteConn.getRemoteType("lan");
        remConn1.connect();
        
        System.out.println();
        RemoteSqlConnection remConn2 = remoteConn.getRemoteType("wifi");
        remConn2.connect();
        
        
    }

}