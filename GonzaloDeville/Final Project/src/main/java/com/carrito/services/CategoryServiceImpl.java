package com.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carrito.entities.Category;
import com.carrito.repositories.CategoryRepository;

@Component
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public Category findById(Integer categoryId) {
		return categoryRepository.findById(categoryId);
	}
	
	@Override
	public Category findByName(String categoryname) {
		return categoryRepository.findByName(categoryname);
	}

	@Override
	public List<Category> listAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

}
