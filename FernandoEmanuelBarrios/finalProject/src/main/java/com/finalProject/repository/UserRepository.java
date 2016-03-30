package com.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	public User findById(int id);

	
	public User findByUserName(String username);

	public List<User> findByFirstNameAndLastName(String firstName, String lastName);

}
