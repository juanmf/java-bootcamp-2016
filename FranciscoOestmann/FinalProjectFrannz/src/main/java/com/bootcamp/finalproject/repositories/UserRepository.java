package com.bootcamp.finalproject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.finalproject.entities.User;



public interface UserRepository extends MongoRepository<User, String>{

	public User findById(String id);
	
	public User findByDni(int dni);

	public User findByUserName(String userName);

	public User findByFirstNameAndLastName(String firstName, String lastName);
}
