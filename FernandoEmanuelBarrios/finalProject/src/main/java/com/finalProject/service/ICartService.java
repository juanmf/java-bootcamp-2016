package com.finalProject.service;

import com.finalProject.entity.Cart;
import com.finalProject.entity.Order;
import com.finalProject.entity.Product;
import com.finalProject.entity.Purchase;
import com.finalProject.entity.User;

public interface ICartService {
	public Cart createCart(Cart cart);

	public Cart showCart(String name);

	public void updateCart(Cart cart);

	public void addOrderToCart(Integer cartId, Integer productId, Integer quantity);

	public void removeOrderFromCart(Product product, Cart cart);

	public void updateQuantity(Product product, Integer quantity, Cart cart);

	public Order findProductInCart(Cart cart, Product product);

	public Purchase buy(Cart cart);

	public Cart findByUser(User user);
	
	public Cart findById(Integer id);

	public void deleteCart(Cart cart);

	public void saveCart(Cart cart);

	public void deletePurchase(Purchase purchase);

}
