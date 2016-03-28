package com.bootcamp.finalproject.services;

import java.util.List;

import com.bootcamp.finalproject.entities.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public void deleteProduct(String productName);
	
	public void updateProduct(Product product);
	
	public List<Product> getProductList();
}
