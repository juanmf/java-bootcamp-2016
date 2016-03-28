package com.bootcamp.finalproject.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bootcamp.finalproject.services.ShoppingCartService;
import com.bootcamp.finalproject.services.ShoppingCartServiceImpl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@ApiModel(value = "ShoppingCart Class.", description = "Class used to create a ShoppingCart Object.")
public class ShoppingCart implements ShoppingCartService{
	
	//State
	ShoppingCartService imp = null;
	
	@ApiModelProperty(value="ShoppingCart Id.")
	@Id
	private String id;

	//Constructor
	public ShoppingCart() {
		imp = new ShoppingCartServiceImpl();
		
	}
	
	
	

	//Getters & Setters
	public String getId() {
		return id;
	}
	

	//Behavior
	/**
	 * Adds item to Shopping Cart list
	 */
	public void AddItemToCart(Product item) {
		imp.AddItemToCart(item);
	}

	/**
	 * Remove item from Shopping Cart list
	 */
	
	public void removeItemFromCart(String name) {
		imp.removeItemFromCart(name);
	}
	/**
	 * Display ShoppingCart Content
	 */
	
	public void displayCartContent() {
		imp.displayCartContent();
	}
	/**
	 * Return the total purchase cost of the ShoppingCart
	 */
	
	public double calculateTotalPurchase() {
		return imp.calculateTotalPurchase();
	}
	/**
	 * Return ShoppingCart list
	 */
	
	public List<Product> getCartList() {
		
		return imp.getCartList();
	}

	/**
	 * Clears the cart Content
	 */
	@Override
	public void clearCart() {
		imp.clearCart();
	}

	@Override
	public void updateCart(String id, String productName, String category, int quantity, double productPrice) {
		imp.updateCart(id, category, productName, quantity, productPrice);
		
	}


	
}
