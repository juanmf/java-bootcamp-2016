package com.bootcamp.finalproject.entities;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bootcamp.finalproject.services.UserService;
import com.bootcamp.finalproject.services.UserServiceImpl;

import io.swagger.annotations.ApiModel;

@Document
@ApiModel(value = "UserRegistration Class.", description = "Class used to register a new User Object in the Database.")
public class UserRegistration implements UserService {

	//State
	UserService imp  = null;
	
	
	
	//Constructor
	public UserRegistration(){
		imp = new UserServiceImpl();
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
	 * Removes an User.
	 */
	@Override
	public void removeUser(User user) {
		imp.removeUser(user);
	}

	/**
	 * Finds User by full name.
	 */
	@Override
	public User findByName(String firstName, String lastName) {
		return imp.findByName(firstName, lastName);
	}

	/**
	 * Finds User by Username.
	 */
	@Override
	public User findByUserName(String userName) {
		return imp.findByUserName(userName);
	}
	
	/**
	 * Finds User by DNI.
	 */
	@Override
	public User findByDni(int dni) {
		return imp.findByDni(dni);
	}

	/**
	 * Returns a list of registered Users.
	 */
	@Override
	public List<User> getAllUsers() {
		return imp.getAllUsers();
	}

	/**
	 * Updates given user Info.
	 */
	@Override
	public void updateUser(String firstName, String lastName, String userName, int dni) {
		imp.updateUser(firstName, lastName, userName, dni);
	}


	@Override
	public void dropUsers() {
		imp.dropUsers();
	}

	
	

	
}
