package com.carrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public Category findById(Integer id);
	
	public Category findByName(String name);

}
