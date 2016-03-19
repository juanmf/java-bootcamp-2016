package exercise2;

public interface ConnectionFactory {

	public SqlConnection getSqlFactory(String connectionType);
	public MongoDbConnection getMongoDbFactory(String connectionType);
}
