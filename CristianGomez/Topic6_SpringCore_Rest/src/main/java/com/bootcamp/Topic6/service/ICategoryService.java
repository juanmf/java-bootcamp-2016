package com.bootcamp.Topic6.service;

import java.util.List;

import com.bootcamp.Topic6.entity.Category;

public interface ICategoryService {
	public Category addCategory(Category category);

	public void deleteCategory(Category category);

	public Category findById(int categoryId);

	public List<Category> listAllCategories();

	public void updateCategory(Category category);

}
