package user.service.main;

/**
 * @author frann
 *
 */

import java.sql.Connection;

public interface UserServiceDAO {
	
	public Connection connect(String url, String user, String pass);
	
	public void disconnect();
}
