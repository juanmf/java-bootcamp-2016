package user;


import java.util.List;


public class UserRegistration implements UserRegistrationService {

	//State
	UserRegistrationService imp;
	
	
	
	//Constructor
	public UserRegistration(){
		imp = new UserRegistrationServiceImpl();
	}
	
	
	//Behavior
	/**
	 * Adds an User.
	 */
	@Override
	public void addUser(User user) {
		imp.addUser(user);
	}
	
	/**
	 * Retrieves User.
	 */
	@Override
	public User getUser(User user){
		return imp.getUser(user);
	}

	/**
	 * Removes an User.
	 */
	@Override
	public void removeUser(User user) {
		imp.removeUser(user);
	}

	/**
	 * Updates given user Info.
	 */
	@Override
	public void updateUser(User user) {
		imp.updateUser(user);
	}
	
	/**
	 * Returns a list of registered Users.
	 */
	@Override
	public List<User> getUsers() {
		return imp.getUsers();
	}

	/**
	 * Displays all User.
	 */
	@Override
	public void displayUsers() {
		imp.displayUsers();
	}

	
}
