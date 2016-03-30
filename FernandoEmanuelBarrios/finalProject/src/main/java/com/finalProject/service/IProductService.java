package com.finalProject.service;

import java.util.List;

import com.finalProject.entity.Category;
import com.finalProject.entity.Product;



public interface IProductService {
	
	public Product findById(Integer productId);

	public Product addProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> listAllProducts();

	public void updateProduct(Product product);

	public List<Product> findByCategory(Category category);

	public List<Product> findByName(String productName);

}
