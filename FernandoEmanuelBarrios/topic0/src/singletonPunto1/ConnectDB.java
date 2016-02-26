package singletonPunto1;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 
public class ConnectDB {
	private static Connection connect = null;
	private static ConnectDB instance=null;
	
	private ConnectDB(){
		try{
			String driver="com.mysql.jdbc.Driver";//usamos el driver de la base de datos q queremos
			String url="jdbc:mysql://127.0.0.1/MyDataBase";
			String pwd="admin";
			String usr="user";
			Class.forName(driver);
			
			connect= DriverManager.getConnection(url,usr,pwd);
		
		}catch(SQLException ex){
		
			System.err.println(ex.getMessage());
		
		}catch(ClassNotFoundException ex){
		
			System.err.println(ex.getMessage());
		
		}
	}
	
	public static ConnectDB getInstance(){
		if(instance==null){
			instance=new ConnectDB();
			System.out.println("coneccion realizada");
		}
		return instance;
		}
	
	public static Connection getConnect(){
		return connect;
	}
	
	private static void closeConnection() {
        try {
            connect.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
	  public static void delInstance() {
	      
          closeConnection();
          instance = null;
   }
}
