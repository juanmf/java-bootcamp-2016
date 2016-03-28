package com.bootcamp.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.finalproject.entities.Product;
import com.bootcamp.finalproject.repositories.ShoppingCartRepository;

@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	//State
	@Autowired
	ShoppingCartRepository repo;
	
	//Constructor
	public ShoppingCartServiceImpl() {
	
	}
	
	
	//Behavior
	
	/**
	 * The Method takes an element and add it to the ShopingCart list.
	 * 
	 */
	@Override
	public void AddItemToCart(Product item) {
		repo.save(item);
	}
	/**
	 * This Method takes an element and remove it from the ShopingCart list.
	 * 
	 */
	@Override
	public  void removeItemFromCart(String productName) {
		repo.deleteProductByProductName(productName);
	}
	/**
	 * This Method display the content of the Shopping Cart in Console.
	 * 
	 */

	@Override
	public void displayCartContent() {
		repo.findAll();
		
	}

	/**
	 * This Method Calculates the total cost of all the Items in the Shopping Cart.
	 * 
	 */
	@Override
	public double calculateTotalPurchase() {
		double totalCost = 0;
		List<Product> list = repo.findAll();
		for(int i = 0; i<list.size(); i++){
			totalCost = totalCost + (list.get(i).getProductPrice() * list.get(i).getProductQuantity());
		}
		return totalCost;
	}
	
	/**
	 * This Method returns the list of Items in Shopping Cart.
	 * 
	 */
	@Override
	public List<Product> getCartList(){
		List<Product> list =  repo.findAll();
		return list;
	}

	/**
	 * Clears cart from every Product.
	 */
	@Override
	public void clearCart() {
		repo.deleteAll();
		
	}

	/**
	 * Updates cart's Product content. It takes an String id (that can be retrieve with the expose getCartList() method) to find the correct 
	 * product an modify it's content.
	 */
	@Override
	public void updateCart(String id, String productName, String category, int productQuantity, double productPrice) {

		Product item = repo.findById(id);
		item.setId(id);
		item.setProductName(productName);
		item.setCategory(category);
		item.setProductQuantity(productQuantity);
		item.setProductPrice(productPrice);
		
		repo.save(item);
		
	}
	


}
