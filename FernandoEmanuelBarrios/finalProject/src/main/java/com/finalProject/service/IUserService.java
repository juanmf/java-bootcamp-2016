package com.finalProject.service;

import java.util.List;

import com.finalProject.entity.Purchase;
import com.finalProject.entity.User;

public interface IUserService {
	public User addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public List<User> listAllUser();

	public User findByUserName(String username);

	public List<User> findByFirstNameAndLastName(String firstName, String lastName);

	public List<Purchase> findAllPurchasedProducts(User user);

}
