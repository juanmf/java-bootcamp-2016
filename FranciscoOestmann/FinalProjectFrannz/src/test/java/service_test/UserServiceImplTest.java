package service_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.entities.UserRegistration;
import com.bootcamp.finalproject.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMongoConfig.class})
public class UserServiceImplTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	MongoTemplate template;

	private UserRegistration userReg;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private User user5;
	
	@Before
	public void setUp(){
		template.dropCollection("user");
		template.createCollection("user");
		//String firstName, String lastName, String userName, String password, String eMail, int dni
		userReg = new UserRegistration();
		userRepo.save(new User("Clark", "Kent", "Superman", "Kal-El", "superman@justiceLeague.com", 1234567));
		userRepo.save(new User("Peter", "Parker", "Spiderman", "Spidey", "spiderman@marvel.com",  4567891));
		userRepo.save(new User("Bruce", "Banner", "Hulk", "Green", "hulk@marvel.com",  7418529));
		userRepo.save(new User("Bruce", "Wayner", "Batman", "detective","batman@justiceLeague.com", 9638527));
		userRepo.save(new User("Charles", "Xavier", "ProfessorX", "Baldie", "professorX@marvel.com", 98657831));
	}
	
	
	/**
	 * Checks if the User was added to the list. The addUser method checks
	 * for duplicates Username before adding the User.
	 */
	@Test
	public void checkIfUserWasAddedToRepository(){
		/*userReg.addUser(user1);
		userReg.addUser(user2);
		userReg.addUser(user3);
		userReg.addUser(user4);
		userReg.addUser(user5);
		*/
		//List<User> users = userRepo.findAll();
		assertNotNull(userRepo.findByUserName("Superman"));
		/*assertTrue(users.contains(user1));
		assertTrue(users.contains(user2));
		assertTrue(users.contains(user3));
		assertTrue(users.contains(user4));
		assertTrue(users.contains(user5));*/
	}
	
	/**
	 * Checks if the User has been removed. The removeUser method checks the list by Id of every User to ensure the
	 * deletion of the correct User.  
	 */
	@Test
	public void checkIfUserHasBeenRemoved(){
		userReg.addUser(user1);
		userReg.removeUser(user1);
		assertFalse(userReg.getAllUsers().contains(user1));
	}
	
	/**
	 * Checks if the given user has been updated. The updateUser method checks the list by Id of every User
	 * before performing the Update.
	 */
	@Test
	public void checkIfUserHasBeenUpdated(){
		userReg.addUser(user1);
		//String userName, String eMail
		userReg.updateUser("Erradicator", "erradicator@supermanisdeath.com");
		assertEquals(user1.getUserName(), "Erradicador");
		assertEquals(user1.geteMail(), "erradicator@supermanisdeath.com");
			
	}
	
	/**
	 * Checks if the User returned is the requested one. the getUser method checks the list by Id of every User
	 * and returns the required one if found.
	 */
	@Test
	public void checkIfRetrievedUserIsWantedOne(){
		userReg.addUser(user3);
		userReg.addUser(user4);
	}
	
	@After
	public void teardown(){
		userReg = null;
		user1 = null;
		user2 = null;
		user3 = null;
		user4 = null;
		user5 = null;
	}
}
