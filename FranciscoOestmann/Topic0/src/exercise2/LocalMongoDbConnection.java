package exercise2;

public class LocalMongoDbConnection implements MongoDbConnection {

	@Override
	public void createConnection() {
		
		System.out.println("Local  Mongodb connection stablished.");
	}

}
