package exercise3;

import java.sql.*;

public class SqlDAO implements SelectorDAOImpl{
	
	Connection conn = null;
	private int id;
	
	//Constructor
	public SqlDAO(int id) {
		super();
		this.id = id;
	}

	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public void connect(){
		try {
			/*Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("url");
			*/
			////Print on console to verify the connection
			System.out.println("Connected");
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	@Override
	public void close() {
		try {
			//conn.close();
			//Print on console to verify the connection
			System.out.println("Disconnected");
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
	}
}
