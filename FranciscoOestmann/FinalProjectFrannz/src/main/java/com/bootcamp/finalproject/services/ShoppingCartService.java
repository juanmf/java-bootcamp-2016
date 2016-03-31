package com.bootcamp.finalproject.services;


import java.util.List;

import com.bootcamp.finalproject.entities.Product;


/**
 * 
 * This Interface expose the methods to add, remove, display, update, clear and calculate the total of the purchase
 * for a Shopping Cart service.
 * 
 * @author Francisco Oestmann
 * 
 */

public interface ShoppingCartService {
	
	public void addItemToCart(Product product);
	
	public void removeItemFromCart(Product product);
	
	public void clearCart();
	
	public double calculateTotalPurchase();
	
	public void updateCart(Product product);

	public List<Product> getCartList();
	
	
}
