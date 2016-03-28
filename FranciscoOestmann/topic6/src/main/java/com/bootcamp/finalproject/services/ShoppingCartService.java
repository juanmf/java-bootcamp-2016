package com.bootcamp.finalproject.services;


import java.util.List;

import com.bootcamp.finalproject.entities.Product;

/**
 * 
 * This Interface expose the methods to add, remove, display an calculate the total of the purchase
 * for a Shopping Cart service.
 * 
 * @author Francisco Oestmann
 * 
 */

public interface ShoppingCartService {

	public void AddItemToCart(Product item);
	
	public void removeItemFromCart(String name);
	
	public void clearCart();
	
	public void displayCartContent();
	
	public double calculateTotalPurchase();
	
	public List<Product> getCartList();
	
	public void updateCart(String id, String productName, String category, int quantity, double productPrice);
	
	
	
}
