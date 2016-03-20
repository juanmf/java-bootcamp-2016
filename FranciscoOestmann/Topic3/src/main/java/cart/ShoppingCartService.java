package cart;

import java.util.LinkedList;
/**
 * Interface that provides the method signatures for ShoppingCart operations.
 * 
 *  
 * @author frann
 *
 */
public interface ShoppingCartService {

	public void AddItemToCart(Item item);
	
	public void removeItemFromCart(Item item);
	
	public void displayCartContent();
	
	public double calculateTotalPurchase();
	
	public LinkedList<Item> getCartList();
	
	
	
}
