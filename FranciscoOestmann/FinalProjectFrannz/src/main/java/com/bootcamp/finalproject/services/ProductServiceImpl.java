package com.bootcamp.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.finalproject.entities.Product;
import com.bootcamp.finalproject.repositories.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	//State
	@Autowired 
	ProductRepository productRepo;
	
	
	
	//Behavior
	@Override
	public Product addProduct(Product product) {

		return productRepo.save(product);
	}

	@Override
	public void deleteProduct(String productName) {

		productRepo.delete(productRepo.findByProductName(productName));
	}

	
	
	@Override
	public void updateProduct(Product product) {

		Product item = productRepo.findById(product.getId());
		
		item.setId(product.getId());
		item.setProductName(product.getProductName());
		item.setProductQuantity(product.getProductQuantity());
		
		productRepo.save(item);
	}

	@Override
	public List<Product> getProductList() {
		return productRepo.findAll();
	}

	public Product findByProductName(String productName){
		return productRepo.findByProductName(productName);
	}
	
	public void clearProductList(){
		productRepo.deleteAll();
	}

}
