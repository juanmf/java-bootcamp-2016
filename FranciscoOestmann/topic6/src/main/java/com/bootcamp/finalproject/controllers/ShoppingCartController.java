package com.bootcamp.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.finalproject.entities.Product;
import com.bootcamp.finalproject.services.ShoppingCartServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/shoppingcart")
@Api(value = "Shopping Cart Controller")
public class ShoppingCartController {


	@Autowired
	ShoppingCartServiceImpl cart;

		
	
	@ApiOperation(value = "Add a Product", notes = "Adds a new Product to the ShoppingCart")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Product added.", response=String.class), 
		@ApiResponse(code = 400, message = "Failed to add Product.", response=String.class),
	})
	@RequestMapping(method = RequestMethod.POST, value = "/addproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addProduct( 
			@RequestParam(value="Name") String productName, 
			@RequestParam(value="Category") String category,
			@RequestParam(value="Quantity") int quantity,
			@RequestParam(value="Price") double productPrice){
		
		Product item = new Product(productName, category, quantity, productPrice);
		
		cart.AddItemToCart(item);
				
	}
	

	
	
	@ApiOperation(value = "Deletes a Product", notes = "Deletes a Product from the Cart list. It takes a String Name to identify the correct Product to be deleted.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Product deleted.", response=String.class),
		@ApiResponse(code = 400, message = "Failed to delete Product.", response=String.class)
	})
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void removeProduct(@RequestParam String productName) {
		
		cart.removeItemFromCart(productName);   
		   	   
	}
	
	
	
	
	@ApiOperation(value = "Displays Cart Content",response = List.class, notes = "Display Products in Shopping Cart")
		@ApiResponses(
		@ApiResponse(code = 200, message = "Product list"))
	@RequestMapping(value = "/showlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> showCartList(){
		return cart.getCartList();
	}
	
	
	
	
	@ApiOperation(value = "Clears Cart content.", notes = "Deletes all Product in the Cart list.")
	@ApiResponses({
		@ApiResponse(code = 200, message="Cart cleared.", response=String.class),
		@ApiResponse(code = 400, message="Failed to clear Cart.", response=String.class)
	})
	@RequestMapping(value="/clearcart", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void clearCart(){
		cart.clearCart();
	}
	
	
	
	
	@ApiOperation(value="Updates Cart content.", notes="Takes an int id of the Product that is going to be changed.")
	@ApiResponses({
		@ApiResponse(code=200, message="Cart content updated.", response=String.class),
		@ApiResponse(code=400, message="Failed to update cart content.", response=String.class)
	})
	@RequestMapping(value="/updatecart", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCart(
			@RequestParam(value="Id") String id, 
			@RequestParam(value="Name") String productName,
			@RequestParam(value="Category") String category,
			@RequestParam(value="Quantity") int quantity,
			@RequestParam(value="Price") double productPrice) {
		
		cart.updateCart(id, productName, category, quantity, productPrice); 
	}
	 
	 
}
