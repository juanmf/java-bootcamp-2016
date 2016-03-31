package service_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.finalproject.entities.Product;
import com.bootcamp.finalproject.entities.ShoppingCart;


public class ShoppingCartServiceImplTest {

	@Autowired
	ShoppingCart cart;
	Product item;
	Product item2;
	
	
	@Before
	public void setup(){
		
		item = new Product("Video Cammera", "Technology", 1, 249.99);
		item2 = new Product("Photo Cammera", "Technology", 1, 149.99);
	}
	
	/**
	 * Test if when the Client adds an item to his cart, it's really added 
	 * 
	 */
	@Test
	public void testIfItemWasAddedToCart() {
		cart.addItemToCart(item);
		assertTrue(cart.getCartList().contains(item));
		
	}
	/**
	 * Test if when the Client removes an item from his cart, it's actually removed
	 * 
	 */
	@Test
	public void testIfItemWasRemoveFromCart(){
		cart.addItemToCart(item);
		cart.removeItemFromCart(item);
		assertFalse(cart.getCartList().contains(item));
	}
	
	/**
	 * Test to verify if the return value of the method is the correct value
	 * 
	 */
	@Test
	public void testCalculationOfShoppingListTotal(){
		
		cart.addItemToCart(item);
		cart.addItemToCart(item2);
		
		assertEquals(399.98, cart.calculateTotalPurchase(), 0.01);
	}
	
	@Test
	public void testIfListNotNull(){
		assertNotNull(cart.getCartList());
	}
	
	@After
	public void teardown(){
		cart = null;
		item =  null;
		item2 =  null;
	}

}
