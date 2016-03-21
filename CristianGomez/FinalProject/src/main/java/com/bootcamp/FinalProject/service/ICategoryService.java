package com.bootcamp.FinalProject.service;

import java.util.List;

import com.bootcamp.FinalProject.entity.Category;

public interface ICategoryService {
	public Category addCategory(Category category);

	public void deleteCategory(Category category);

	public Category findById(int categoryId);

	public List<Category> listAllCategories();

	public void updateCategory(Category category);

}
