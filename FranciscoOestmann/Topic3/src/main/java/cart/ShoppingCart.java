package cart;

import java.util.LinkedList;

public class ShoppingCart implements ShoppingCartService {
	
	//State
	ShoppingCartService imp = new ShoppingCartServiceImpl();
	

	//Constructor
	public ShoppingCart() {
		
	}

	
	//Behavior
	/**
	 * Adds item to Shopping Cart list
	 */
	public void AddItemToCart(Item item) {
		imp.AddItemToCart(item);
	}
	/**
	 * Remove item from Shopping Cart list
	 */
	
	public void removeItemFromCart(Item item) {
		imp.removeItemFromCart(item);
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
	
	public LinkedList<Item> getCartList() {
		return imp.getCartList();
	}

	
}
