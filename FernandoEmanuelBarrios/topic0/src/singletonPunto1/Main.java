package singletonPunto1;
 import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
	public static void main(String[] args){
		try{
			ConnectDB con = ConnectDB.getInstance();
			Statement stmt=con.getConnect().createStatement();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			ConnectDB.delInstance();
		}
	}
	
}
