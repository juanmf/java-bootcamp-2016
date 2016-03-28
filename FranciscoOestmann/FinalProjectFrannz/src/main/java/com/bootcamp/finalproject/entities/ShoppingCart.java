package com.bootcamp.finalproject.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bootcamp.finalproject.services.ShoppingCartService;
import com.bootcamp.finalproject.services.ShoppingCartServiceImpl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@ApiModel(value = "ShoppingCart Class.", description = "Class used to create a ShoppingCart Instance.")
public class ShoppingCart implements ShoppingCartService{
	
	//State
	ShoppingCartService imp = null;
	
	@ApiModelProperty(value="ShoppingCart Id.")
	@Id
	private String id;
	
	@ApiModelProperty(value="ShoppingCart User.")
	User user = null;

	//Constructor
	public ShoppingCart(User user) {
		imp = new ShoppingCartServiceImpl();
		this.user = user;
	}
	
	
	

	//Getters & Setters
	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public User getUser(){
		return user;
	}
	

	//Behavior
	/**
	 * Adds item to Shopping Cart list
	 */
	public void addItemToCart(Product product) {
		imp.addItemToCart(product);
	}

	/**
	 * Remove item from Shopping Cart list
	 */
	
	public void removeItemFromCart(Product product) {
		imp.removeItemFromCart(product);
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
	
	@Override
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
	public void updateCart(Product product) {
		imp.updateCart(product);
		
	}




}
