package com.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.entity.Cart;
import com.finalProject.entity.Purchase;
import com.finalProject.service.ICartService;
import com.finalProject.service.IProductService;
import com.finalProject.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@EnableAutoConfiguration
@RestController
@RequestMapping("/cart")
@ComponentScan("com.finalProject")
@Api(value = "Cart", description = "Cart API", produces = "application/json")
public class CartController {
	
	@Autowired
	IProductService iProductService;
	
	@Autowired
	ICartService iCartService;
	
	@Autowired
	IUserService iUserService;
	
	@RequestMapping(method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Cart", notes = "Returns a cart")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Cart at least")
    })
	public Cart showCart(@RequestParam(value = "username", required = false, defaultValue = "") String username) {
		return iCartService.showCart(username);
	}
	
	@RequestMapping(method = RequestMethod.DELETE ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Cart", notes = "remove a cart")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Cart at least")
    })
	public void emptyCart(@RequestParam(value = "username", required = true) String username) {
		iCartService.deleteCart(iCartService.findByUser(iUserService.findByUserName(username)));
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update Cart", notes = "update a Cart")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Cart at least")
    })
	public void updateCart(@RequestBody Cart cart) {
		iCartService.updateCart(cart);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create Cart", notes = "Returns a cart ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Cart at least")
    })
	public Cart createCart(@RequestBody Cart cart) {
		return iCartService.createCart(cart);
	}
	
	
    @ApiOperation(value = "add cart", notes = "add a order to the cart")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Cart at least")
    })
    @RequestMapping(value = "/cartOrder", method = RequestMethod.GET)
	public void addOrderToCart(@RequestParam(value = "productId", required = true) Integer productId,
			@RequestParam(value = "quantity", required = true) Integer quantity,
			@RequestParam(value = "cartId", required = true)Integer id) {
		iCartService.addOrderToCart(id,productId, quantity);
	}
	
	@RequestMapping(value = "/cartOrder", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "remove Cart", notes = "remove order to cart")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Cart at least")
    })
	public void removeOrderFromCart(@RequestParam(value = "productId", required = true) int productId, @RequestBody Cart cart) {
		iCartService.removeOrderFromCart(iProductService.findById(productId), cart);
	}
	
	@RequestMapping(value = "/cartOrder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update cart", notes = "update order in cart")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Cart at least")
    })
	public void updateQuantity(@RequestParam(value = "productId", required = true) Integer productId,
			@RequestParam(value = "quantity", required = true) Integer quantity, @RequestBody Cart cart) {
		iCartService.updateQuantity(iProductService.findById(productId), quantity, cart);
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "buy Cart", notes = "Return a purchase")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one cart at least")
    })
	public Purchase buy(@RequestParam Integer cartId) {
		return iCartService.buy(iCartService.findById(cartId)); 
	}

}
