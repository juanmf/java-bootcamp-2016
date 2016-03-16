package com.bootcamp.Topic6.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.Topic6.entity.Cart;
import com.bootcamp.Topic6.entity.CartItem;
import com.bootcamp.Topic6.entity.Product;
import com.bootcamp.Topic6.entity.Purchase;
import com.bootcamp.Topic6.entity.User;
import com.bootcamp.Topic6.repository.CartRepository;
import com.bootcamp.Topic6.repository.PurchaseRepository;

@Component
public class CartService implements ICartService {
    
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);

	}

	@Override
	public Cart showCart(String username) {
		return findByUser(iUserService.findByUsername(username));

	}

	@Override
	public void updateCart(Cart cart) {
		cartRepository.save(cart);

	}

	@Override
	public void emptyCart(Cart cart) {
		cartRepository.delete(cart);

	}

	@Override
	public void addItemToCart(Product product, int quantity, Cart cart) {
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setQuantity(quantity);
		item.setCart(cart);
		cart.getCartItem().add(item);
		updateCart(cart);

	}

	@Override
	public void removeItemFromCart(Product product, Cart cart) {
		cart.getCartItem().remove(findProductInCart(cart, product));
		updateCart(cart);

	}

	@Override
	public void updateQuantity(Product product, int quantity, Cart cart) {
		CartItem cartItem = findProductInCart(cart, product);
		cartItem.setQuantity(quantity);
		updateCart(cart);

	}

	@Override
	public CartItem findProductInCart(Cart cart, Product product) {
		Iterator<CartItem> it = cart.getCartItem().iterator();
		while (it.hasNext()) {
			CartItem item = it.next();
			if (item.getProduct().equals(product)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * Creates an order from the current cart, then empties the cart.
	 */

	@Override
	public Purchase checkout(Cart cart) {
		double total = 0;
		Iterator<CartItem> it = cart.getCartItem().iterator();
		while (it.hasNext()) {
			CartItem temp = it.next();
			total = total + temp.getProduct().getPrice() * temp.getQuantity();
		}
		cart.setTotal(total);
		updateCart(cart);
		deleteCart(cart);
		Purchase purchase = new Purchase();
		purchase.create(cart);
		return purchaseRepository.save(purchase);

	}

	@Override
	public Cart findByUser(User user) {
		return cartRepository.findByUser(user);
	}

	@Override
	public void deleteCart(Cart cart) {
		if (cart != null) {
			cartRepository.delete(cart);
		}

	}

	@Override
	public void saveCart(Cart cart) {
		cartRepository.save(cart);

	}

	@Override
	public void deletePurchase(Purchase purchase) {
		purchaseRepository.delete(purchase);

	}

}
