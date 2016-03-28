package com.bootcamp.finalproject.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	
	
	@Autowired
	UserRepository repo;
	
	
	//Constructor
	public UserServiceImpl(){
		
	}
	
	
	//Behavior
	/**
	 * Adds an User to the Database. First it checks for duplicates Usernames.
	 * If given Username is in use, doesn't added to the database.
	 * 
	 */
	@Override
	public void addUser(User user) {
		User temp = repo.findByUserName(user.getUserName());
		if(temp == null){
			repo.save(user);
		}
	}
	
	
	/**
	 * Removes an User from the Database. Takes an User Object to find and delete the correct User.
	 */
	@Override
	public void removeUser(User user) {
		repo.delete(user);
		
	}
	
	
	/**
	 * Finds an User in the Database by it's complete name.
	 */
	@Override
	public User findByName(String firstName, String lastName) {
		
		return repo.findByFirstNameAndLastName(firstName, lastName);
	}
	

	/**
	 * Finds an User in the Database by it's Username.
	 */
	@Override
	public User findByUserName(String userName) {
		return repo.findByUserName(userName);
	}
	
	/**
	 * Finds an User in the Database by it's DNI.
	 */
	@Override
	public User findByDni(int dni){
		return repo.findByDni(dni);
	}

	
	/**
	 * Updates given User Info.
	 */
	@Override
	public void updateUser(String firstName, String lastName, String userName, int dni) {

		User user = repo.findByFirstNameAndLastName(firstName, lastName);
		user.setId(repo.findByFirstNameAndLastName(firstName, lastName).getId());
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setDni(dni);
			
		repo.save(user);
		
	}
	
	
	/**
	 * Returns all users in the Database.
	 */
	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}


	/**
	 * Drops the User Collection.
	 */
	@Override
	public void dropUsers() {
		repo.deleteAll();
		
	}

}
