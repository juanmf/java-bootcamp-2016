package com.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finalProject.entity.Category;
import com.finalProject.repository.CategoryRepository;

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
	public void updateCategory(Category category) {
		categoryRepository.save(category);

	}

	@Override
	public Category findById(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> listAllCategories() {
		return categoryRepository.findAll();
	}

}
