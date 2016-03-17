package com.bootcamp.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.FinalProject.entity.Category;
import com.bootcamp.FinalProject.repository.CategoryRepository;

@Component
public class CategoryService implements ICategoryService {
    
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);

	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);

	}

	@Override
	public Category findById(int categoryId) {
		return categoryRepository.findById(categoryId);
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
