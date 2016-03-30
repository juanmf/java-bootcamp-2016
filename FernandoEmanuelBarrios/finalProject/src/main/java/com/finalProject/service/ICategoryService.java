package com.finalProject.service;

import java.util.List;

import com.finalProject.entity.Category;


public interface ICategoryService {
	public Category addCategory(Category category);
	public void deleteCategory(Category category);
	public void updateCategory(Category category);
	public Category findById(int id);
	public List<Category> listAllCategories();
	
}
