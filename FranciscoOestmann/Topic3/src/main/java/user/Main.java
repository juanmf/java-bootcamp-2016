package user;


public class Main {

	public static void main(String[] args) {
		
		UserRegistration reg = new UserRegistration();
		
		User user1 = new User("Clark", "Kent", "Superman", 1234567);
		User user2 = new User("Peter", "Parker", "Spiderman", 4567891);
		User user3 = new User("Bruce", "Banner", "Hulk", 7418529);
		User user4 = new User("Bruce", "Wayner", "Batman", 9638527);
		User user5 = new User("Charles", "Xavier", "Hulk", 98657831);
		
		reg.addUser(user1);
		reg.addUser(user2);
		reg.addUser(user3);
		reg.addUser(user4);
		reg.addUser(user5);
		
		reg.displayUsers();
		
		
		reg.removeUser(user2);
		reg.removeUser(user4);
		
		reg.displayUsers();
		
		user1.setFirstName("Lex");
		user1.setLastName("Luthor");
		user1.setUserName("LexCorp");
		user1.setDni(2794617);
		
		reg.updateUser(user1);
		
		
		reg.displayUsers();
		
		
	}
}
