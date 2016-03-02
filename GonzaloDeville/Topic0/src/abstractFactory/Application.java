package abstractFactory;

public class Application {

	private final ConnectionFactory connectionFactory;
	
	public Application(ConnectionFactory connectionFactory){
		this.connectionFactory = connectionFactory;
	}
	
	public void start(){
		Connection connection = connectionFactory.getConnection();
		connection.connect();
 	}
}
