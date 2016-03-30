package com.carrito.services;

import java.util.List;

import com.carrito.entities.Cart;
import com.carrito.entities.CartProduct;
import com.carrito.entities.Product;
import com.carrito.entities.Purchase;
import com.carrito.entities.User;

public interface ICartService {
	
	public Cart createCart(Cart cart);

	public Cart showCart(String userName);

	public void updateCart(Cart cart);

	public void addOrderToCart(Product product, int quantity, Cart cart);

	public void removeProductFromCart(Product product, Cart cart);

	public void updateQuantity(Product product, Integer quantity, Integer cartId);

	public CartProduct findProductInCart(Cart cart, Product product);

	public Cart findByUser(User user);
	
	public Cart findById(Integer id);

	public void deleteCart(Cart cart);

	public void saveCart(Cart cart);
	
	public Purchase addPurchaseMade(Cart cart);
	
	public List <Purchase> showPurchase();

}
