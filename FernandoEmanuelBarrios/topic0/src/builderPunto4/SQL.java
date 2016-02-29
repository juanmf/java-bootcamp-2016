package builderPunto4;


import java.sql.SQLException;

public interface SQL {
	public String conectar(String driver,String url,String usr,String pwd) throws SQLException,ClassNotFoundException;
	
}
