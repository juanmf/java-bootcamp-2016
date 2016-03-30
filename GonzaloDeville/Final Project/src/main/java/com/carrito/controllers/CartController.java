package com.carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.entities.Cart;
import com.carrito.entities.Purchase;
import com.carrito.services.ICartService;
import com.carrito.services.IProductService;
import com.carrito.services.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@EnableAutoConfiguration
@RestController
@RequestMapping("/cart")
//@ComponentScan("com.carrito")
@Api(value = "cart", description = "cart Controller", produces = "application/json")
public class CartController {

	@Autowired
	IProductService iProductService;

	@Autowired
	ICartService iCartService;

	@Autowired
	IUserService iUserService;
	
	/*@Autowired
	PurchaseRepository purchaseRepository;*/

	@ApiOperation(value = "show the cart of an user")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "the username of the user", required = false, dataType = "string", paramType = "query") })
	@RequestMapping(method = RequestMethod.GET)
	public Cart showCart(@RequestParam(value = "username", required = false, defaultValue = "") String username) {
		return iCartService.showCart(username);
	}

	@ApiOperation(value = "delete the car of an user")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "the username of the user", required = false, dataType = "string", paramType = "query") })
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteCart(@RequestParam(value = "username", required = true) String username) {
		iCartService.deleteCart(iCartService.findByUser(iUserService.findByUserName(username)));
	}

	@ApiOperation(value = "update the cart of an user")
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCart(@RequestBody Cart cart) {
		iCartService.updateCart(cart);
	}

	@ApiOperation(value = "create a cart")
	@RequestMapping(method = RequestMethod.POST)
	public Cart createCart(@RequestBody Cart cart) {
		return iCartService.createCart(cart);
	}

	@ApiOperation(value = "add an order to the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "the id of the product", required = true, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "quantity", value = "quantity of products", required = true, dataType = "Integer", paramType = "query") })
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public void addOrderToCart(@RequestParam(value = "productId", required = true) Integer productId,
			@RequestParam(value = "quantity", required = true) int quantity,
			@RequestParam(value = "cartId", required = true) Integer cartId) {
		iCartService.addOrderToCart(iProductService.findById(productId), quantity, iCartService.findById(cartId));
	}

	@ApiOperation(value = "Remove an order from the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "the id of the product", required = true, dataType = "Integer", paramType = "query") })
	@RequestMapping(value = "/product", method = RequestMethod.DELETE)
	public void removeOrderFromCart(@RequestParam(value = "productId", required = true) Integer productId,
			@RequestBody Cart cart) {
		iCartService.removeProductFromCart(iProductService.findById(productId), cart);
	}

	@ApiOperation(value = "Update the quantity of a product in the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "the id of the product", required = true, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "quantity", value = "quantity of the product", required = true, dataType = "Integer", paramType = "query") })
	@RequestMapping(value = "/cartproduct", method = RequestMethod.PUT)
	public void updateQuantity(@RequestParam(value = "productId", required = true) Integer productId,
			@RequestParam(value = "quantity", required = true) Integer quantity, @RequestParam(value = "cartId", required = true) Integer cartId) {
		iCartService.updateQuantity(iProductService.findById(productId), quantity, cartId);
	}

	@ApiOperation(value = "purchase", notes = "generate a purchase from the cart, them empties the cart")
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public Purchase purchase(@RequestParam(value = "cartId", required = true) Integer cartId) {
		return iCartService.addPurchaseMade(iCartService.findById(cartId));
	}

	@ApiOperation(value = "List of all purchases")
	@RequestMapping(value = "/purchase/made",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Purchase> listAllpurchases() {
		return iCartService.showPurchase();
	}
}
