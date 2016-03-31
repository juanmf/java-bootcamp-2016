package com.bootcamp.finalproject.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.finalproject.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
	
	public List<Product> findByCategory(String category);
	
	public Product findByProductName(String productName);
	
	public List<Product> findByProductCategory(String productCategory);
	
	public Product findById(String id);
	
}
