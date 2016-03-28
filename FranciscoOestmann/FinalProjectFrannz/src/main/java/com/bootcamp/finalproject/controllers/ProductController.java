package com.bootcamp.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.finalproject.entities.Product;
import com.bootcamp.finalproject.services.ProductServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Api(value = "Product Controller")
public class ProductController {

	@Autowired
	ProductServiceImpl iProduct;

	
	@ApiOperation(value = "Add a Product to repository", notes = "Adds a new Product to the Product Repository")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Product added.", response=String.class), 
		@ApiResponse(code = 400, message = "Failed to add Product.", response=String.class),
	})
	@RequestMapping(method = RequestMethod.POST, value = "/addproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct( 
			@RequestParam(value="Name") String productName, 
			@RequestParam(value="Category") String category,
			@RequestParam(value="Price") double productPrice){
		
		Product product = new Product();
		product.setProductName(productName);
		product.setCategory(category);
		product.setProductPrice(productPrice);
		
		return iProduct.addProduct(product);
				
	}
	
	
	
	@ApiOperation(value = "Deletes a Product from the repository", notes = "Deletes a Product from the Product Repository. It takes a String Name to identify the correct Product to be deleted.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Product deleted.", response=String.class),
		@ApiResponse(code = 400, message = "Failed to delete Product.", response=String.class)
	})
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void removeProduct(@RequestParam String productName) {
		
		iProduct.deleteProduct(productName);  
		   	   
	}
	
	
	
	@ApiOperation(value="Updates a Product Quantity", notes="Takes the Name and the quantity of the Product that is going to be changed.")
	@ApiResponses({
		@ApiResponse(code=200, message="Cart content updated.", response=String.class),
		@ApiResponse(code=400, message="Failed to update cart content.", response=String.class)
	})
	@RequestMapping(value="/updateproduct", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCart(
			@RequestParam(value="Product Name") String productName,
			@RequestParam(value="Product Quantity") int quantity){
		
		Product product = new Product();
		product.setId(iProduct.findByProductName(productName).getId());
		product.setProductName(productName);
		product.setProductQuantity(quantity);
		
		iProduct.updateProduct(product); 
	}
	
	
	
	@ApiOperation(value = "Displays Product List",response = List.class, notes = "Display a list with all the Products.")
	@ApiResponses(
	@ApiResponse(code = 200, message = "Product list"))
	@RequestMapping(value = "/productlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> showProductList(){
		return iProduct.getProductList();
	}
}
