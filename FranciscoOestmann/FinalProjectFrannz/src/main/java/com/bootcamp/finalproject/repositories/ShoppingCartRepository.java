package com.bootcamp.finalproject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.finalproject.entities.ShoppingCart;
import com.bootcamp.finalproject.entities.User;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

	public ShoppingCart findByUser(User user);
}
