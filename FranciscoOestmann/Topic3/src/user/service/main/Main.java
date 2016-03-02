package user.service.main;

/**
 * @author frann
 *
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DbClient client = new DbClient();
		
		System.out.println("MySQL Database User Service: ");
		System.out.println();
		
		System.out.println("Enter the url of the database: ");
		String url = sc.nextLine();
		System.out.println();
		
		System.out.println("Enter the user name: ");
		String user = sc.nextLine();
		System.out.println();
		
		System.out.println("Enter the password: ");
		String pass = sc.nextLine();
		System.out.println();

		
		
		client.connect(url, user, pass);
		client.createTable();
		client.insertToTable();
		client.readFromTable();
		client.updateTable();
		client.deleteFromTable();
		client.disconnect();
	}

}
