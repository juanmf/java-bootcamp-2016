package com.userservice;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {
	UserServiceImpl users;
	User usr, usr2;

	@Before
	public void setUp() {
		users = new UserServiceImpl();
		usr = new User("Cota", "alagrandelepusecuca");
		usr2 = new User("Gonzalo", "callefalsa123");
	}

	@Test
	public void addUsertest() {
		assertTrue(users.listUsers().isEmpty());
	
		users.addUser(usr);
		assertFalse(users.listUsers().isEmpty());
		assertEquals(usr, users.listUsers().get(0));
		
		users.addUser(usr);
		assertEquals(1, users.listUsers().size());
	}
	
	@Test
	public void removeUserTest(){
		users.addUser(usr);
		assertEquals(usr, users.listUsers().get(0));
		users.removeUser(usr);
		assertTrue(users.listUsers().isEmpty());
	}
	
	@Test
	public void updateUserTest(){
		users.addUser(usr);
		assertEquals("Cota", users.listUsers().get(0).getUserName());
		users.updateUser(usr, "CotaCambiado", "aLaGrandeLePuseCuca");
		assertEquals("CotaCambiado", users.listUsers().get(0).getUserName());
	}
	
	@Test
	public void listUsers(){
		users.addUser(usr);
		users.addUser(usr2);
		assertEquals(2, users.listUsers().size());
		
	}
}
