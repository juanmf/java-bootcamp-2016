package com.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Category findById(int id);
	
	public Category findByName(String name);
}
