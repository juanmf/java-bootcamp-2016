package com.carrito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.entities.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(Integer id);

	public User findByUserName(String userName);

	public List<User> findByFirstNameAndLastName(String firstName, String lastName);
		
	
}