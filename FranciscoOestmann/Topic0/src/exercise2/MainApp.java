package exercise2;

public class MainApp {

	public static void main(String[] args) {

		ConnectionFactory sqlFactory = FactoryProducer.getFactory("sql");
		
		SqlConnection sql1 = sqlFactory.getSqlFactory("Local");
		sql1.createConnection();
		
		
		SqlConnection sql2 = sqlFactory.getSqlFactory("Remote");
		sql2.createConnection();
		
		System.out.println();
		
		ConnectionFactory MongoDbFactory = FactoryProducer.getFactory("Mongodb");
		
		MongoDbConnection MongoDb1 = MongoDbFactory.getMongoDbFactory("Local");
		MongoDb1.createConnection();
		
		
		MongoDbConnection MongoDb2 = MongoDbFactory.getMongoDbFactory("Remote");
		MongoDb2.createConnection();
		
	}

}
