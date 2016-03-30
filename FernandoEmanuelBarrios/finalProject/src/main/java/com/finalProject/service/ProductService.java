package com.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finalProject.entity.Category;
import com.finalProject.entity.Product;
import com.finalProject.repository.ProductRepository;


@Component
public class ProductService implements IProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product findById(Integer productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
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
	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> findByName(String productName) {
		return productRepository.findByProductName(productName);
	}

	

	

	

}
