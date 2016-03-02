package user.service.main;

/**
 * @author frann
 *
 */

import java.sql.Connection;
import java.util.Scanner;

public class DbClient implements UserService, UserServiceDAO{

	//State
	UserService ser = new UserServiceImpl();
	UserServiceDAO conn = new UserServiceDAOImpl();
	Scanner sc = new Scanner(System.in);
	private String url = " ";
	private String userName = " ";
	private String userPass = " ";
	private String dbType = " ";
	public String tableName = " ";
	
	//Constructor
	public DbClient(){
		setTableName(tableName);
	}
	

	//Getters & Setter
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		System.out.println("Enter the table name: ");
		tableName = sc.nextLine();
	}
	
	public String getDbType() {
		return dbType;
	}
	
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	

	
	//Behavior
	@Override
	public Connection connect(String url, String user, String pass) {
		return conn.connect(url, user, pass);
	}
	
	@Override
	public void disconnect() {
		conn.disconnect();
	}
	
	@Override
	public void createTable() {
		ser.createTable();
	}

	@Override
	public void insertToTable() {
		ser.insertToTable();
	}

	@Override
	public void readFromTable() {
		ser.readFromTable();
	}

	@Override
	public void updateTable() {
		ser.updateTable();
	}

	@Override
	public void deleteFromTable() {
		ser.deleteFromTable();
	}


	


	

	
}
