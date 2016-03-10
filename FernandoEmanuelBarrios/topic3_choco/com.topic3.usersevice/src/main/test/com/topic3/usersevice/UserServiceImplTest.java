package com.topic3.usersevice;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class UserServiceImplTest {
	UserServiceImp users;
	User usr, usr2;

	@Before
	public void setUp() {
		users = new UserServiceImp();
		usr = new User("choco", "12345");
		usr2 = new User("fernando", "54321");
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
		assertEquals("choco", users.listUsers().get(0).getNickName());
		users.updateUser(usr, "choco2", "34567");
		assertEquals("choco2", users.listUsers().get(0).getNickName());
	}
	
	@Test
	public void listUsers(){
		users.addUser(usr);
		users.addUser(usr2);
		assertEquals(2, users.listUsers().size());
		
	}
}
