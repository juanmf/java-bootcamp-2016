package com.bootcamp.Topic6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.Topic6.entity.Category;
import com.bootcamp.Topic6.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByName(String name);

	public Product findById(int id);

	public List<Product> findByCategory(Category category);
}
