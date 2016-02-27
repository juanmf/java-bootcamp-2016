package ejer2_Factory;
public class RemoteConnection extends AbstractConnectionFactory{

    @Override
    LocalSqlConnection getLocalType(String local) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    RemoteSqlConnection getRemoteType(String remote) {
        
        if(remote==null){
            return null;
        }
        if(remote.equalsIgnoreCase("lan")){
            return new RemoteLan();
        }
        
        else{
            if(remote.equalsIgnoreCase("wifi")){
                return new RemoteWifi();
            }
        }
        return null;
    }

}