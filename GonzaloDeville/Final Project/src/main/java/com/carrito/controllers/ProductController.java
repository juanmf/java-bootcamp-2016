package com.carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.entities.Product;
import com.carrito.services.ICategoryService;
import com.carrito.services.IProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@EnableAutoConfiguration
@ComponentScan("com.carrito")
@RestController
@RequestMapping("/product")
@Api(value = "Product", description = "category Controller", produces = "application/json")
public class ProductController {

	@Autowired
	IProductService iProductService;
	@Autowired
	ICategoryService iCategoryService;
	
	@ApiOperation(value = "List of products", notes = "With a productName in the param, shows the product with that name, without the productName, list all the products")
	@ApiImplicitParam(name = "productName", required = false, dataType = "String", defaultValue = "")
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> listProducts(
			@RequestParam(value = "productName", required = false, defaultValue = "") String productName) {
		if (productName.compareTo("") == 0) {
			return iProductService.listAllProducts();
		}
		return iProductService.findByProductName(productName);
	}
	
	@ApiOperation(value = "Return a product for a given id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "Integer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable Integer id) {
		return iProductService.findById(id);
	}
	
	@ApiOperation(value = "Return a product for a given category name")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", required = true, dataType = "String") })
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public List<Product> findByCategory(@PathVariable String name) {
		return iProductService.findByCategory(iCategoryService.findByName(name));
	}
	
	
	@ApiOperation(value = "Delete a product for a given id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "Integer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id) {
		iProductService.deleteProduct(iProductService.findById(id));
	}
	
	@ApiOperation(value = "Update a product for a given id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "Integer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		iProductService.updateProduct(product);
	}
	
	@ApiOperation(value = "Add a new product")
	@RequestMapping(method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return iProductService.addProduct(product);
	}

}
