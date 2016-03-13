package com.bootcamp.Topic6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.Topic6.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findById(int id);
}
