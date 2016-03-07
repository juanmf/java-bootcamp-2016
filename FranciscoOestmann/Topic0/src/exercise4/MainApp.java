package exercise4corregido;

public class MainApp {

	public static void main(String[] args) {
		
	
	ConnectionBuilder myConn = new ConnectionType();
	ConnDirector conDir = new ConnDirector(myConn);
	conDir.connect();
	SqlConnection sqlConn = conDir.getConnection();
	
	
	System.out.println(sqlConn);
	
	
	}
}
