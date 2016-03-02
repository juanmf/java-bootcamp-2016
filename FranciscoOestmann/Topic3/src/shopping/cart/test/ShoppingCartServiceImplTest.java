package shopping.cart.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import shopping.cart.main.Item;
import shopping.cart.main.ShoppingCart;

public class ShoppingCartServiceImplTest {

	ShoppingCart myCart = new ShoppingCart();
	LinkedList<Object> list = new LinkedList<Object>();
	Item item = new Item("Video Cammera", 249.99);
	Item item2 = new Item("Photo Cammera", 149.99);
	
	
	/**
	 * Test if when the Client adds an item to his cart, it's really added 
	 * 
	 */
	@Test
	public void testIfItemWasAddedToCart() {
		myCart.AddItemToCart(item);
		assertTrue(myCart.getCartList().contains(item));
		
	}
	/**
	 * Test if when the Client removes an item from his cart, it's actually removed
	 * 
	 */
	@Test
	public void testIfItemWasRemoveFromCart(){
		myCart.removeItemFromCart(item);
		assertFalse(myCart.getCartList().contains(item));
	}
	
	/**
	 * Test to see if the return value of the method is the correct value
	 * 
	 */
	@Test
	public void testCalculationOfShoppingListTotal(){
		
		myCart.AddItemToCart(item);
		myCart.AddItemToCart(item2);
		
		assertEquals(399.98, myCart.calculateTotalPurchase(), 0.01);
	}
	
	@Test
	public void testIfListNotNull(){
		assertNotNull(myCart.getCartList());
	}

}
