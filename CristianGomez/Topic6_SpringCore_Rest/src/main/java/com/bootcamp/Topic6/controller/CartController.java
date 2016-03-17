package com.bootcamp.Topic6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Topic6.entity.Cart;
import com.bootcamp.Topic6.entity.Purchase;
import com.bootcamp.Topic6.service.ICartService;
import com.bootcamp.Topic6.service.IProductService;
import com.bootcamp.Topic6.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cart")
@Api(value = "Cart", description = "All operations related to a cart")
public class CartController {
    
	@Autowired
	private ICartService iCartService;
	
	@Autowired
	private IProductService iProductService;
	
	@Autowired
	private IUserService iUserService;
	

	@ApiOperation(value = "Show the cart of a given user")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "") })
	@RequestMapping(method = RequestMethod.GET)
	public Cart showCart(@RequestParam String username) {
		return iCartService.showCart(username);
	}

	@ApiOperation(value = "Empty the cart of a given user")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "User's name", required = true, dataType = "string", paramType = "query") })
	@RequestMapping(method = RequestMethod.DELETE)
	public void emptyCart(@RequestParam String username) {
		iCartService.emptyCart(iCartService.findByUser(iUserService.findByUsername(username)));
	}

	@ApiOperation(value = "Update the current cart")
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCart(@RequestBody Cart cart) {
		iCartService.updateCart(cart);
	}

	@ApiOperation(value = "Create a cart")
	@RequestMapping(method = RequestMethod.POST)
	public Cart createCart(@RequestBody Cart cart) {
		return iCartService.createCart(cart);
	}

	@ApiOperation(value = "Add an item to the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "Product's id number", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "quantity", value = "Quantity of the product", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/cartItem", method = RequestMethod.POST)
	public void addItemToCart(@RequestParam int productId,
			@RequestParam int quantity, @RequestBody Cart cart) {
		iCartService.addItemToCart(iProductService.findById(productId), quantity, cart);
	}

	@ApiOperation(value = "Remove an item from the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "Product's id number", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/cartItem", method = RequestMethod.DELETE)
	public void removeItemFromCart(@RequestParam int productId, @RequestBody Cart cart) {
		iCartService.removeItemFromCart(iProductService.findById(productId), cart);
	}

	@ApiOperation(value = "Update the quantity of a product in the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "Product's id number", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "quantity", value = "Quantity of the product", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/cartItem", method = RequestMethod.PUT)
	public void updateQuantity(@RequestParam int productId,
			@RequestParam int quantity, @RequestBody Cart cart) {
		iCartService.updateQuantity(iProductService.findById(productId), quantity, cart);
	}

	@ApiOperation(value = "Checkout", notes = "Generate an order with the current cart")
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public Purchase checkout(@RequestBody Cart cart) {
		return iCartService.checkout(cart);
	}
}
