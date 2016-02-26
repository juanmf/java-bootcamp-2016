package exercise4;

import java.util.Scanner;

public class OracleConnectionsBuilder implements ConnectionsBuilder{

	private Scanner sc = new Scanner(System.in);
	private DbConnections dbConnection;
	
	public OracleConnectionsBuilder(){
		dbConnection = new DbConnections();
	}

	@Override
	public void buildUrl() {
		System.out.println("Enter the url of the database: ");
		String urlAddress = sc.nextLine();
		dbConnection.setUrl(urlAddress);
	}

	@Override
	public void buildUser() {
		System.out.println("Enter the user name: ");
		String userName = sc.nextLine();
		dbConnection.setUser(userName);
	}

	@Override
	public void buildPassword() {
		System.out.println("Enter the password: ");
		String userPassword = sc.nextLine();
		dbConnection.setPassword(userPassword);
	}

	@Override
	public void buildConnectionAddress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DbConnections getConnectionAddress() {
		return dbConnection;
	}

}
