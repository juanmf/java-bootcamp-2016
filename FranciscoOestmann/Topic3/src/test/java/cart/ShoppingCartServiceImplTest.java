package cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cart.Item;
import cart.ShoppingCart;

public class ShoppingCartServiceImplTest {

	ShoppingCart myCart;
	Item item;
	Item item2;
	
	
	@Before
	public void setup(){
		myCart = new ShoppingCart();
		item = new Item("Video Cammera", 249.99);
		item2 = new Item("Photo Cammera", 149.99);
	}
	
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
		myCart.AddItemToCart(item);
		myCart.removeItemFromCart(item);
		assertFalse(myCart.getCartList().contains(item));
	}
	
	/**
	 * Test to verify if the return value of the method is the correct value
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
	
	@After
	public void teardown(){
		myCart = null;
		item =  null;
		item2 =  null;
	}

}
