package com.carrito.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.entities.Category;
import com.carrito.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByProductName(String productName);
	
	public Product findById(Integer id);
	
	public List<Product> findByCategory(Category category);

}
