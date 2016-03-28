package com.bootcamp.finalproject.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.finalproject.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
	public Product findById(String id);

	public List<Product> findByProductName(String productName);
	
	public List<Product> findByCategory(String category);
}
