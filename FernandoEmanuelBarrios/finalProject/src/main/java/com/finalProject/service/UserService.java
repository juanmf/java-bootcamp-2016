package com.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finalProject.entity.Purchase;
import com.finalProject.entity.User;
import com.finalProject.repository.UserRepository;


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
	user.setId(this.findByUserName(user.getUserName()).getId());
	userRepository.save(user);
}

@Override
public List<User> listAllUser() {
	return userRepository.findAll();
}

@Override
public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
	return userRepository.findByFirstNameAndLastName(firstName, lastName);
}

@Override
public User findByUserName(String username) {
	return userRepository.findByUserName(username);
}


@Override
public List<Purchase> findAllPurchasedProducts(User user) {
	return user.getPurchases();
}

}
