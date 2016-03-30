package com.carrito.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carrito.entities.Cart;
import com.carrito.entities.CartProduct;
import com.carrito.entities.Product;
import com.carrito.entities.Purchase;
import com.carrito.entities.User;
import com.carrito.repositories.CartRepository;
import com.carrito.repositories.PurchaseRepository;

@Component
public class CartServiceImpl implements ICartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	IUserService iUserService;

	@Autowired
	PurchaseRepository purchaseRepository;

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart showCart(String username) {
		return findByUser(iUserService.findByUserName(username));
	}

	@Override
	public void updateCart(Cart cart) {
		cartRepository.save(cart);
	}

	@Override
	public void addOrderToCart(Product product, int quantity, Cart cart) {
		Double total = 0.0;

		Iterator<CartProduct> it = cart.getCartProduct().iterator();
		CartProduct first = null;
		if (it.hasNext()) {
			first = it.next();
		}else{
			total = total + product.getPrice() * quantity;
		}
		while (it.hasNext()) {
			CartProduct temp = first;
			total = total + temp.getProduct().getPrice() * temp.getQuantity();
			first = it.next();
		}

		CartProduct cartProduct = new CartProduct();
		cartProduct.setProduct(product);
		cartProduct.setQuantity(quantity);
		cartProduct.setCart(cart);
		cart.getCartProduct().add(cartProduct);
		cart.setTotal(total);
		updateCart(cart);
	}

	@Override
	public void removeProductFromCart(Product product, Cart cart) {
		cart.getCartProduct().remove(findProductInCart(cart, product));
		updateCart(cart);
	}

	@Override
	public void updateQuantity(Product product, Integer quantity, Integer cartId) {
		Cart cart = cartRepository.findById(cartId);
		CartProduct cartProduct = findProductInCart(cart, product);
		cartProduct.setQuantity(quantity);
		updateCart(cart);
	}

	@Override
	public CartProduct findProductInCart(Cart cart, Product product) {
		Iterator<CartProduct> it = cart.getCartProduct().iterator();
		while (it.hasNext()) {
			CartProduct item = it.next();
			if (item.getProduct().equals(product)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public Cart findByUser(User user) {
		return cartRepository.findByUser(user);
	}

	@Override
	public Cart findById(Integer id) {
		return cartRepository.findById(id);
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
	public Purchase addPurchaseMade(Cart cart) {
		Double total = 0.0;
		Iterator<CartProduct> it = cart.getCartProduct().iterator();
	
		while (it.hasNext()) {
			CartProduct temp = it.next();
			total = total + temp.getProduct().getPrice() * temp.getQuantity();
		}
		cart.setTotal(total);
		updateCart(cart);
		
		Purchase purchase = new Purchase();
		purchase.create(cart);
		deleteCart(cart);
		return purchaseRepository.save(purchase);
	}

	@Override
	public List<Purchase> showPurchase() {
		return purchaseRepository.findAll();
	}

}
