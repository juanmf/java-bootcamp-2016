package com.bootcamp.finalproject.services;

import java.util.List;

import com.bootcamp.finalproject.entities.User;

public interface UserService {

	public void addUser(User user);
	
	public void removeUser(User user);
	
	public User findByName(String firstName, String lastName);
	
	public User findByUserName(String userName);
	
	public User findByDni(int dni);
	
	public void updateUser(String firstName, String lastName, String userName, int dni);
	
	public List<User> getAllUsers();
	
	public void dropUsers();
	
}
