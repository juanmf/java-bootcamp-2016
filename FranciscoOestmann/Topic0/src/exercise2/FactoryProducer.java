package exercise2;

public class FactoryProducer {

	public static ConnectionFactory getFactory(String conn){
		
		if(conn.equalsIgnoreCase("Sql")){
			return new SqlFactory();
		}
		
		else if(conn.equalsIgnoreCase("Mongodb")){
			return new MongoDbFactory();
		}
		return null;
	}
}
