package com.bootcamp.finalproject.entities;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bootcamp.finalproject.services.UserRegistrationService;
import com.bootcamp.finalproject.services.UserRegistrationServiceImpl;

import io.swagger.annotations.ApiModel;

@Document
@ApiModel(value = "UserRegistration Class.", description = "Class used to register a new User Object in the Database.")
public class UserRegistration implements UserRegistrationService {

	//State
	UserRegistrationService imp  = null;
	
	
	
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
	public User findByNickname(String nickname) {
		return imp.findByNickname(nickname);
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
	public List<User> getUsers() {
		return imp.getUsers();
	}

	/**
	 * Updates given user Info.
	 */
	@Override
	public void updateUser(String id, String firstName, String lastName, String userName, int dni) {
		imp.updateUser(id, firstName, lastName, userName, dni);
	}

	
	

	
}
