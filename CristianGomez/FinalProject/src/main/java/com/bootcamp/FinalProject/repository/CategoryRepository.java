package com.bootcamp.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.FinalProject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findById(int id);
}
