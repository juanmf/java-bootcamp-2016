package com.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.entity.Category;
import com.finalProject.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findById(Integer idprod);

	public List<Product> findByCategory(Category category);
	public List<Product> findByProductName(String productName);
	//public List<Product> findByProductName(String productName);
}




