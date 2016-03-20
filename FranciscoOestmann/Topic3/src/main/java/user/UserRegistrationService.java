package user;

import java.util.List;
/**
 * Interface that defines the method signature for CRUD operations.
 * 
 * @author frann
 *
 */
public interface UserRegistrationService {

	public void addUser(User user);
	
	public User getUser(User user);
	
	public void removeUser(User user);
	
	public void updateUser(User user);
	
	public List<User> getUsers();
	
	public void displayUsers();
	
}
