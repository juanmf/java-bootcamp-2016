package shopping.cart.main;

import java.util.Iterator;
import java.util.LinkedList;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	//State
	private LinkedList<Item> list;
	
	//Constructor
	public ShoppingCartServiceImpl() {
	
		list = new LinkedList<Item>();
	}
	
	
	//Behavior
	
	/**
	 * The Method takes an element and add it to the ShopingCart list
	 * 
	 */
	@Override
	public void AddItemToCart(Item item) {
		list.add(item);
	}
	/**
	 * This Method takes an element and remove it to the ShopingCart list
	 * 
	 */
	@Override
	public  void removeItemFromCart(Item item) {
		list.remove(item);
		
	}
	/**
	 * This Method display the content of the Shopping Cart in Console
	 * 
	 */

	@Override
	public void displayCartContent() {
		for(Item item: list){
			System.out.println("Product: " + item.getProductName() + "   " + "Price: $" + item.getProductPrice() + ".\n");
		}
		
	}

	/**
	 * This Method Calculates the total cost of all the Items in the Shopping Cart
	 * 
	 */
	@Override
	public double calculateTotalPurchase() {
		
		double totalCost = 0;
		for(Iterator<Item> it = list.iterator(); it.hasNext();){
			totalCost += it.next().getProductPrice();
		}
		
		return totalCost;
		
	}
	
	/**
	 * This Method returns the list of Items in Shopping Cart
	 * 
	 */
	@Override
	public LinkedList<Item> getCartList(){
		return list;
	}
	


}
