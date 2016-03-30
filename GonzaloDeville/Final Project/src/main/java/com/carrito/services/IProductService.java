package com.carrito.services;

import java.util.List;

import com.carrito.entities.Category;
import com.carrito.entities.Product;

public interface IProductService {
	
	public Product findById(Integer productId);

	public Product addProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> listAllProducts();

	public void updateProduct(Product product);

	public List<Product> findByProductName(String productName);
	
	public List<Product> findByCategory(Category category);

}
