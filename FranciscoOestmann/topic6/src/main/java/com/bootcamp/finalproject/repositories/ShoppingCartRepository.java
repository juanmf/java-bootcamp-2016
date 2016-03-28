package com.bootcamp.finalproject.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.finalproject.entities.Product;

public interface ShoppingCartRepository extends MongoRepository<Product, String> {

	public List<Product> findByCategory(String category);
	
	public Product findByProductName(String productName);
	
	public Product findById(String id);
	
	public void deleteProductByProductName(String productName);
}
