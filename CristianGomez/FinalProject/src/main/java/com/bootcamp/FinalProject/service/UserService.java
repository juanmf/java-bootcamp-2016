package com.bootcamp.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.FinalProject.entity.User;
import com.bootcamp.FinalProject.repository.UserRepository;

@Component
public class UserService implements IUserService {
    
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ICartService iCartService;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public void deleteUser(User user) {
		iCartService.deleteCart(iCartService.findByUser(user));
		userRepository.delete(user);

	}

	@Override
	public void updateUser(User user) {
		user.setId(this.findByUsername(user.getUsername()).getId());
		userRepository.save(user);
	}

	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
