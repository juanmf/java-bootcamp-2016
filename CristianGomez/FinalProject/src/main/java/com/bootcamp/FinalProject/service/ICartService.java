package com.bootcamp.FinalProject.service;

import com.bootcamp.FinalProject.entity.Cart;
import com.bootcamp.FinalProject.entity.CartItem;
import com.bootcamp.FinalProject.entity.Product;
import com.bootcamp.FinalProject.entity.Purchase;
import com.bootcamp.FinalProject.entity.User;

public interface ICartService {

	public Cart createCart(Cart cart);

	public Cart showCart(String username);

	public void updateCart(Cart cart);

	public void emptyCart(Cart cart);

	public void addItemToCart(Product product, int quantity, Cart cart);

	public void removeItemFromCart(Product product, Cart cart);

	public void updateQuantity(Product product, int quantity, Cart cart);

	public CartItem findProductInCart(Cart cart, Product product);

	public Purchase checkout(Cart cart);

	public Cart findByUser(User user);

	public void deleteCart(Cart cart);

	public void saveCart(Cart cart);

	public void deletePurchase(Purchase purchase);

}
