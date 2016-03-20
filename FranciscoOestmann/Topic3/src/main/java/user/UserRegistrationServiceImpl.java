package user;



import java.util.LinkedList;
import java.util.List;


public class UserRegistrationServiceImpl implements UserRegistrationService{

	//State
	List<User> userList = null;
	
	//Constructor
	public UserRegistrationServiceImpl(){
		
		userList = new LinkedList<User>();
	}
	
	
	//Behavior
	/**
	 * Adds an User to the Database. First it checks for duplicates Usernames.
	 * If given Username is in use, doesn't added to the database.
	 */
	@Override
	public void addUser(User user) {
		for(int i = 0; i<10; i++){
			User tempUser = userList.get(i);
			if(!tempUser.getUserName().equals(user.getUserName())){
				
				userList.add(user);
			}
		}
	}
	
	
	/**
	 * Removes an User from the Database. Takes an User Object to find and delete the correct one.
	 */
	@Override
	public void removeUser(User user) {
		for(int i = 0; i<10; i++){
			if(userList.get(i).getId() == user.getId()){
				userList.remove(user);
			}
		}
		
	}

	
	/**
	 * Updates given User Info. Takes an User Object to find and delete the correct one.
	 */
	@Override
	public void updateUser(User user) {
		for(int i = 0; i<10; i++){
			if(userList.get(i).getId() == user.getId()){
				userList.add(i, user);
			}
		}
		System.out.println(userList.size());
	}
	/**
	 * Returns a specific User in the Database. Takes an User Object to find and delete the correct one.
	 * If User it's not in the Database, returns null;
	 */
	@Override
	public User getUser(User user){
		for(int i= 0; i<10; i++){
			if(userList.get(i).getId() == user.getId()){
				return userList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Returns all users in the Database.
	 */
	@Override
	public List<User> getUsers() {
		return userList;
	}

	/**
	 * Display all Users.
	 */
	@Override
	public void displayUsers() {
		for(User user: userList){
			System.out.println("User: " + user.getFirstName() + ", " 
										+ user.getLastName() + "\n" + "Username: " 
										+ user.getUserName() + "Dni: " 
										+ user.getDni());
		}
		
	}


}
