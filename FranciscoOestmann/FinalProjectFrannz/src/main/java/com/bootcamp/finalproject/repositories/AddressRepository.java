package com.bootcamp.finalproject.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.finalproject.entities.Address;
import com.bootcamp.finalproject.entities.User;

public interface AddressRepository extends MongoRepository<Address, String> {

	public List<Address> findByUser(User user);
	
	public Address findByUserAndAddressType(User user, String addressType);
}
