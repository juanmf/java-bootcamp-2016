package shopping.cart.main;

import java.util.LinkedList;

public class ShoppingCart implements ShoppingCartService{
	
	ShoppingCartService imp = new ShoppingCartServiceImpl();
	

	//Constructor
	public ShoppingCart() {
		
		
	}

	@Override
	/**
	 * Adds item to Shopping Cart list
	 */
	public void AddItemToCart(Item item) {
		imp.AddItemToCart(item);
	}
	/**
	 * Remove item from Shopping Cart list
	 */
	@Override
	public void removeItemFromCart(Item item) {
		imp.removeItemFromCart(item);
	}
	/**
	 * Display ShoppingCart Content
	 */
	@Override
	public void displayCartContent() {
		imp.displayCartContent();
	}
	/**
	 * Return the total purchase cost of the ShoppingCart
	 */
	@Override
	public double calculateTotalPurchase() {
		return imp.calculateTotalPurchase();
	}
	/**
	 * Return ShoppingCart list
	 */
	@Override
	public LinkedList<Item> getCartList() {
		return imp.getCartList();
	}

	
}
