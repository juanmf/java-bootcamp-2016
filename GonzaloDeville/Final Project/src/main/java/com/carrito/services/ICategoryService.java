package com.carrito.services;

import java.util.List;

import com.carrito.entities.Category;

public interface ICategoryService {
	
	public Category addCategory(Category category);

	public void deleteCategory(Category category);

	public Category findById(Integer categoryId);
	
	public Category findByName(String categoryname);

	public List<Category> listAllCategories();

	public void updateCategory(Category category);

}
