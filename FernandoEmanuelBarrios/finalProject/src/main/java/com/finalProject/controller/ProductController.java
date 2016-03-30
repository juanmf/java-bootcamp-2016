package com.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.entity.Product;
import com.finalProject.service.IProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@EnableAutoConfiguration
@ComponentScan("com.carrito")
@RestController
@RequestMapping("/product")
@Api(value = "Product", description = "Product API", produces = "application/json")
public class ProductController {

	@Autowired
	IProductService iProductService;

	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list Prodcut", notes = "Returns all products")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Product at least")
    })
	public List<Product> listProducts(
			@RequestParam(value = "productName", required = false, defaultValue = "") String productName) {
		if (productName.compareTo("") == 0) {
			return iProductService.listAllProducts();
		}
		return iProductService.findByName(productName);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find Product", notes = "Return a product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Product at least")
    })
	public Product findById(@PathVariable Integer id) {
		return iProductService.findById(id);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "delete product", notes = "delete a product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Product at least")
    })
	public void deleteProduct(@PathVariable int id) {
		iProductService.deleteProduct(iProductService.findById(id));
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update Product", notes = "update a product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Product at least")
    })
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		iProductService.updateProduct(product);
	}
	

	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "add Product", notes = "add a product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Product at least")
    })
	public Product addProduct(@RequestBody Product product) {
		return iProductService.addProduct(product);
	}

}
