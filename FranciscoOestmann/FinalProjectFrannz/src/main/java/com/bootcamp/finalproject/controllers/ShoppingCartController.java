package com.bootcamp.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.finalproject.entities.Login;
import com.bootcamp.finalproject.entities.Product;
import com.bootcamp.finalproject.entities.Purchase;
import com.bootcamp.finalproject.entities.ShoppingCart;
import com.bootcamp.finalproject.repositories.AddressRepository;
import com.bootcamp.finalproject.repositories.PurchaseRepository;
import com.bootcamp.finalproject.repositories.ShoppingCartRepository;
import com.bootcamp.finalproject.services.ProductServiceImpl;
import com.bootcamp.finalproject.services.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/shoppingcart")
@Api(value = "Shopping Cart Controller")
public class ShoppingCartController {

	
	@Autowired
	ProductServiceImpl iProduct;
	
	@Autowired
	UserServiceImpl iUser;
	
	@Autowired
	ShoppingCartRepository cartRepo;
	
	@Autowired
	PurchaseRepository purchaseRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	Login login;
	
	ShoppingCart cart;
	
	Product product;
	
	Purchase purchase;

	
	
	@ApiOperation(value = "Add a Product.", notes = "Adds a new Product to the ShoppingCart.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Product added.", response=String.class), 
		@ApiResponse(code = 400, message = "User not Logged.", response=String.class),
	})
	@RequestMapping(method = RequestMethod.POST, value = "/addproducttocart", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>  addProduct(
			@RequestParam(value="User name") String userName,
			@RequestParam(value="Product") String productName
			){
		
		
		if(login.findLoggedUser(userName)){
			
			cart = cartRepo.findByUser(iUser.findByUserName(userName));
			cart.setId(cartRepo.findByUser(iUser.findByUserName(userName)).getId());
			product = iProduct.findByProductName(productName);
			product.setProductQuantity(1);
			cart.addItemToCart(product);
			cartRepo.save(cart);
			
			return new ResponseEntity<String>("Product added.", HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("User not Logged.", HttpStatus.BAD_REQUEST);
		}
				
	}
	

	
	
	@ApiOperation(value = "Deletes a Product.", notes = "Deletes a Product from the Cart list. It takes a String Name to identify the correct Product to be deleted.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Product deleted.", response=String.class),
		@ApiResponse(code = 400, message = "Failed to delete Product.", response=String.class)
	})
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeProduct(
			@RequestParam(value="User Name") String userName,
			@RequestParam(value="Product Name") String productName
			){
		if(login.findLoggedUser(userName)){
			
			cart = cartRepo.findByUser(iUser.findByUserName(userName));
			cart.setId(cartRepo.findByUser(iUser.findByUserName(userName)).getId());
			product = iProduct.findByProductName(productName);
			cart.removeItemFromCart(product); 
			cartRepo.save(cart);
			
			return new ResponseEntity<String>("Product Removed.", HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("User not Logged.", HttpStatus.BAD_REQUEST);
		}
			
	}
	
	
	
	
	@ApiOperation(value = "Displays Cart Content.",response = List.class, notes = "Display Products in Shopping Cart.")
	@ApiResponses(
			@ApiResponse(code = 200, message = "Product list"))
	@RequestMapping(value = "/showlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> showCartList(@RequestParam(value="User name") String userName){

			cart = cartRepo.findByUser(iUser.findByUserName(userName));
			return cart.getCartList();
	}
	
	
	
	
	@ApiOperation(value = "Clears Cart content.", notes = "Deletes all Product in the Cart list.")
	@ApiResponses({
		@ApiResponse(code = 200, message="Cart cleared.", response=String.class),
		@ApiResponse(code = 400, message="Failed to clear Cart.", response=String.class)
	})
	@RequestMapping(value="/clearcart", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> clearCart(@RequestParam(value="User name") String userName){
		
		if(login.findLoggedUser(userName)){
			
			cart = cartRepo.findByUser(iUser.findByUserName(userName));
			cart.clearCart();
			cartRepo.save(cart);
			
			return new ResponseEntity<String>("Cart Cleared.", HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("User not Logged.", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	@ApiOperation(value="Updates Cart content.", notes="Takes an productName, and the quantity of the Product that is going to be changed.")
	@ApiResponses({
		@ApiResponse(code=200, message="Cart content updated.", response=String.class),
		@ApiResponse(code=400, message="Failed to update cart content.", response=String.class)
	})
	@RequestMapping(value="/updatecart", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCart(
			@RequestParam(value="User Name") String userName,
			@RequestParam(value="Product Name") String productName,
			@RequestParam(value="Product Quantity") int quantity){
		
		if(login.findLoggedUser(userName)){
			
			cart = cartRepo.findByUser(iUser.findByUserName(userName));
			product = iProduct.findByProductName(productName);
			product.setProductQuantity(quantity);
			cart.updateCart(product); 
			cartRepo.save(cart);
			
			return new ResponseEntity<String>("Cart updated.", HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("User not Logged.", HttpStatus.BAD_REQUEST);
		}
	}
	 
	 
	
	
	@ApiOperation(value="Checkout.", notes="Calculates and returns the total of the purchase and the product list.")
	@ApiResponses({
		@ApiResponse(code=200, message="Checkout generated.", response=String.class),
		@ApiResponse(code=400, message="Failed to checkout.", response=String.class)
	})
	@RequestMapping(value="/checkout", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> checkoutCart(
			@RequestParam(value="User Name") String userName
			){

		if(login.findLoggedUser(userName)){

			purchase = new Purchase();
			cart = cartRepo.findByUser(iUser.findByUserName(userName));
			purchase.setUser(cart.getUser());
			purchase.setProducts(cart.getCartList());
			purchase.setAddresses(addressRepo.findByUser(iUser.findByUserName(userName)));
			purchase.setTotal(cart.calculateTotalPurchase());
			purchase.setDate();
			purchaseRepo.save(purchase);
			cart.clearCart();
			cartRepo.save(cart);
			
			return new ResponseEntity<String>("CheckOut finish.", HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("User not Logged.", HttpStatus.BAD_REQUEST);
		}
	}
	
}
