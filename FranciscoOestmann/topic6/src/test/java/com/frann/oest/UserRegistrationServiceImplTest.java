package com.frann.oest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.entities.UserRegistration;

public class UserRegistrationServiceImplTest {

	UserRegistration userReg;
	User user1;
	User user2;
	User user3;
	User user4;
	User user5;
	
	@Before
	public void startup(){
		userReg = new UserRegistration();
		user1 = new User("Clark", "Kent", "Superman", 1234567);
		user2 = new User("Peter", "Parker", "Spiderman", 4567891);
		user3 = new User("Bruce", "Banner", "Hulk", 7418529);
		user4 = new User("Bruce", "Wayner", "Batman", 9638527);
		user5 = new User("Charles", "Xavier", "Hulk", 98657831);
	}
	
	
	/**
	 * Checks if the User was added to the list. The addUser method checks
	 * for duplicates Username before adding the User.
	 */
	@Test
	public void checkIfUserWasAddedToList(){
		userReg.addUser(user1);
		userReg.addUser(user2);
		userReg.addUser(user3);
		userReg.addUser(user4);
		userReg.addUser(user5);
		System.out.println(userReg.getUsers().size());
		List<User> users = userReg.getUsers();
		assertTrue(users.contains(user3));
	}
	
	/**
	 * Checks if the User has been removed. The removeUser method checks the list by Id of every User to ensure the
	 * deletion of the correct User.  
	 */
	@Test
	public void checkIfUserHasBeenRemoved(){
		userReg.addUser(user1);
		userReg.removeUser(user1);
		assertFalse(userReg.getUsers().contains(user1));
	}
	
	/**
	 * Checks if the given user has been updated. The updateUser method checks the list by Id of every User
	 * before performing the Update.
	 */
	@Test
	public void checkIfUserHasBeenUpdated(){
		userReg.addUser(user1);
		userReg.updateUser(user1.getId(), "Peter", "Parker", "Spiderman", 4567891);
			
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
