package exercise2;

public class RemoteMongoDbConnection implements MongoDbConnection {

	@Override
	public void createConnection() {
		
		System.out.println("Remote  Mongodb connection stablished.");
	}

}
