package builderPunto4;

public class Main {

	public static void main(String[] args) {
		Connection conn = new Connection.ConnectionBuilderPostgreSQL("Test")
		.connectionPath("postgresql://host:127.0.0.1:8080/database").build();
		
		
	}

}
