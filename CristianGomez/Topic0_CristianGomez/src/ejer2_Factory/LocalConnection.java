package ejer2_Factory;

public class LocalConnection extends AbstractConnectionFactory{

    @Override
    LocalSqlConnection getLocalType(String local) {
        if(local==null){
            return null;
        }
        if(local.equalsIgnoreCase("lan")){
            return new Lan();
        }
        
        else{
            if(local.equalsIgnoreCase("wifi")){
                return new Wifi();
            }
        }
        return null;
    }

    @Override
    RemoteSqlConnection getRemoteType(String remote) {
        // TODO Auto-generated method stub
        return null;
    }
    
}