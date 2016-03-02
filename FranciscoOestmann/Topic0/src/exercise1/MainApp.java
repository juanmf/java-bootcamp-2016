package exercise1;

public class MainApp {

	public static void main(String[] args) {
		SingletonDBConnection connection = SingletonDBConnection.getInstance();
		
		connection.getConnection();
	}

}
