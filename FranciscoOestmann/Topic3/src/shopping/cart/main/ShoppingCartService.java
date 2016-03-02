package shopping.cart.main;

import java.util.LinkedList;

public interface ShoppingCartService {

	public void AddItemToCart(Item item);
	
	public void removeItemFromCart(Item item);
	
	public void displayCartContent();
	
	public double calculateTotalPurchase();
	
	public LinkedList<Item> getCartList();
	
	
	
}
