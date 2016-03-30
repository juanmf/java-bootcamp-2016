package com.carrito.services;

import java.util.List;

import com.carrito.entities.Purchase;
import com.carrito.entities.User;



public interface IUserService {
	
	public User addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public List<User> listAllUsers();

	public User findByUserName(String userName);
	
	public boolean findByUser(User user);
	
	public List<User> findByFirstNameAndLastName(String firstName, String lastName);
	
}
