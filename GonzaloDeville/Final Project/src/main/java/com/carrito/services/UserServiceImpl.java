package com.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carrito.entities.Purchase;
import com.carrito.entities.User;
import com.carrito.repositories.UserRepository;
import com.carrito.services.ICartService;

@Component
public class UserServiceImpl implements IUserService {

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
		user.setId(this.findByUserName(user.getUserName()).getId());
		userRepository.save(user);
	}

	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public boolean findByUser(User user) {
		if (userRepository.findByUserName(user.getUserName()) != null) {
			return true;
		} else {
			return false;
		}
	}

}
