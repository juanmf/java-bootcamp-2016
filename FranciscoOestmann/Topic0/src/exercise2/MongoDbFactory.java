package exercise2;

public class MongoDbFactory implements ConnectionFactory {

	@Override
	public SqlConnection getSqlFactory(String connectionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MongoDbConnection getMongoDbFactory(String connectionType) {
		if(connectionType == null){
	         return null;
	      }		
	      
	      if(connectionType.equalsIgnoreCase("Local")){
	         return new LocalMongoDbConnection();
	         
	      }else if(connectionType.equalsIgnoreCase("Remote")){
	         return new RemoteMongoDbConnection();
	         
	      }
	   return null;
	}

}
