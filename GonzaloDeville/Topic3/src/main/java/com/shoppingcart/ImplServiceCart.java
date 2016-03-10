package com.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cota
 *
 */
public class ImplServiceCart implements IServiceCart {

	private List<Order> ordersList;

	public ImplServiceCart() {
		ordersList = new ArrayList<Order>();
	}

	/**
	 * The method allow add an item to a cart.
	 * @param o
	 */
	public void addOrder(Order o) {
		if (!ordersList.contains(o)) {
			ordersList.add(o);
		}
	}

	/**
	 * The method allow remove an selected item from the cart.
	 * @param o
	 */
	public void removeOrder(Order o) {
		ordersList.remove(o);
	}

	/**
	 * Get all orders from the cart.
	 * @return a list of orders from the cart
	 */
	public List<Order> getOrders() {
		return ordersList;
	}
	

	/**
	 * Get the total to pay for purchases.
	 * @return a double with the total to pay
 */
	public double getTotal() {
		double sbtotal = 0;
		for (Order order : getOrders())
			sbtotal = sbtotal + order.getSubTotal();
		return sbtotal;
	}

}
