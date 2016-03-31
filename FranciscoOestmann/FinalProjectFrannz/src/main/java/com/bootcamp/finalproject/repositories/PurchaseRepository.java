package com.bootcamp.finalproject.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.finalproject.entities.Purchase;
import com.bootcamp.finalproject.entities.User;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {

	public List<Purchase> findByUser(User user);
}
