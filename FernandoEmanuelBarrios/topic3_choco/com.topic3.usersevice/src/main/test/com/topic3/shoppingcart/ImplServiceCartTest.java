package com.topic3.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImplServiceCartTest {
	private ImplServiceCart cart;
	private Order order1;
	private Order order2;
	private Product prod1;
	private Product prod2;
	private double aux;
	
	@Before
	public void setUp(){
		cart = new ImplServiceCart();
		prod1 = new Product("Carrot", 4.50);
		prod2 = new Product("Onion", 6.20);
		order1 = new Order(prod1,12);
		order2 = new Order(prod2,6);
		aux = 4.50 * 12 + 6.20 * 6;
	}
	
	@Test
	public void addOrderTest(){
		cart.addOrder(order1);
		assertEquals(order1, cart.getOrders().get(0));
	}
	
	@Test
	public void removeOrderTest(){
		assertTrue(cart.getOrders().isEmpty());
		
		cart.addOrder(order1);
		assertFalse(cart.getOrders().isEmpty());
		
		cart.removeOrder(order1);
		assertTrue(cart.getOrders().isEmpty());
	}
	
	@Test
	public void getOrdersTest(){
		cart.addOrder(order1);
		cart.addOrder(order2);
		assertEquals(2, cart.getOrders().size());
	}

	@Test
	public void getTotalTest(){
		cart.addOrder(order1);
		cart.addOrder(order2);
		assertEquals(aux, cart.getTotal(),0.00001);
	}
}
