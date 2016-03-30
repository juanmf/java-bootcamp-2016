package com.finalProject.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finalProject.entity.Cart;
import com.finalProject.entity.Order;
import com.finalProject.entity.Product;
import com.finalProject.entity.Purchase;
import com.finalProject.entity.User;
import com.finalProject.repository.CartRepository;
import com.finalProject.repository.PurchaseRepository;

@Component
public class CartService implements ICartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private IUserService iUserService;
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private IProductService iProductService;


	

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart showCart(String name) {
		return cartRepository.findByUser(iUserService.findByUserName(name));
	}

	@Override
	public void updateCart(Cart cart) {
		cartRepository.save(cart);
	}

	@Override
	public void addOrderToCart(Integer cartId, Integer productId, Integer quantity) {
		Double total=0.0;
		Cart cart = cartRepository.findById(cartId);
		Product product = iProductService.findById(productId);
		
		  Iterator<Order> it = cart.getOrder().iterator(); while (it.hasNext())
		  {
		  
		  total+= it.next().getQuantity()*product.getPrice();
		  
		  }
		 
		Order order = new Order();
		order.setProduct(product);
		order.setQuantity(quantity);
		cart.getOrder().add(order);
		updateCart(cart);

	}

	@Override
	public void removeOrderFromCart(Product product, Cart cart) {
		cart.getOrder().remove(findProductInCart(cart, product));
		updateCart(cart);
	}

	@Override
	public void updateQuantity(Product product, Integer quantity, Cart cart) {
		cart.getOrder().get(product.getId()).setQuantity(quantity);

	}

	@Override
	public Order findProductInCart(Cart cart, Product prodcut) {
		Iterator<Order> it = cart.getOrder().iterator();
		while (it.hasNext()) {
			if (it.equals(prodcut)) {
				return it.next();
			}
		}
		return null;
	}

	@Override
	public Purchase buy(Cart cart) {
		// cart.setTotal();
		updateCart(cart);
		Purchase purchase = new Purchase();
		purchase.create(cart);
		deleteCart(cart);
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

	@Override
	public Cart findById(Integer id) {
		return cartRepository.findById(id);
	}

}
