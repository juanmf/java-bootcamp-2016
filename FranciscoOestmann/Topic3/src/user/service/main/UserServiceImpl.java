package user.service.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author frann
 * 
 * This Class is lacking the actual MySQL command line implementation.
 *
 */

public class UserServiceImpl implements UserService {
	DbClient user = new DbClient();
	UserServiceDAOImpl conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	//Constructor
	UserServiceImpl(){
		conn = new UserServiceDAOImpl();
	}
	
	public void connect(String url, String user, String pass) {
		
		conn.connect(url, user, pass);
	}
	
	
	/**
	 * This method creates a table, by user request,  in the specified database  
	 * Can be overload to manage different types of database commands
	 */
	@Override
	public void createTable() {
		
		try {
			
			rs = st.executeQuery("create table " + user.getTableName() + "(" + ")") ;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * This method adds values to the table by user request
	 * Can be overload to manage different types of database commands
	 */
	@Override
	public void insertToTable() {
		try {
			
			rs = st.executeQuery("insert into " + user.getTableName() + "values " + "(" + ")");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * This method retrieve data from database by user request
	 * Can be overload to manage different types of database commands
	 */
	@Override
	public void readFromTable() {
		try {
			
			rs = st.executeQuery("select from " + user.getTableName() + ":");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateTable() {
		try {
			
			rs = st.executeQuery("update " + user.getTableName() + ":");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * Deletes an entry from the database by user request
	 * Can be overload to manage different types of database commands
	 */
	@Override
	public void deleteFromTable() {
		try {
			
			rs = st.executeQuery("delete from " + user.getTableName() + "[table name] where [column name]=[field text]");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	

	

}
