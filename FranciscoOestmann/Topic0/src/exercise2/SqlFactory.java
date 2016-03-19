package exercise2;

public class SqlFactory implements ConnectionFactory {

	@Override
	public SqlConnection getSqlFactory(String connectionType) {
		if(connectionType == null){
	         return null;
	      }		
	      
	      if(connectionType.equalsIgnoreCase("Local")){
	         return new LocalSqlConnection();
	         
	      }else if(connectionType.equalsIgnoreCase("Remote")){
	         return new RemoteSqlConnection();
	         
	      }
	   return null;
	}

	@Override
	public MongoDbConnection getMongoDbFactory(String connectionType) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
