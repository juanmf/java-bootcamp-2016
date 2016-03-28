package com.bootcamp.finalproject.services;

import java.util.List;

import com.bootcamp.finalproject.entities.User;

public interface UserRegistrationService {

	public void addUser(User user);
	
	public void removeUser(User user);
	
	public User findByName(String firstName, String lastName);
	
	public User findByNickname(String nickname);
	
	public User findByDni(int dni);
	
	public void updateUser(String id, String firstName, String lastName, String userName, int dni);
	
	public List<User> getUsers();
	
}
