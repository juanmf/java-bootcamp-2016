package com.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carrito.entities.Category;
import com.carrito.entities.Product;
import com.carrito.repositories.CategoryRepository;
import com.carrito.repositories.ProductRepository;

@Component
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Product findById(Integer productId) {
		return productRepository.findById(productId);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public List<Product> findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(categoryRepository.findByName(category.getName()));
	}

}
