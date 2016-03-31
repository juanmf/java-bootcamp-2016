package com.bootcamp.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.finalproject.entities.Purchase;
import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.repositories.PurchaseRepository;
import com.bootcamp.finalproject.repositories.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/purchase")
@Api(value = "Purchase Controller")
public class PurchaseController {
	
	@Autowired 
	PurchaseRepository purchaseRepo;
	
	@Autowired
	UserRepository userRepo;

	@ApiOperation(value = "Shows Purchase History.", notes = "Display Purchase History.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Purchase History Found.", response=String.class), 
		@ApiResponse(code = 400, message = "Purchase History not Found.", response=String.class),
	})
	@RequestMapping(method = RequestMethod.GET, value = "/showpurchasehistory", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Purchase> showPurchaseHistory(
			@RequestParam(value="User name") String userName){
		
		User user = userRepo.findByUserName(userName);
		
		return purchaseRepo.findByUser(user);	
	}
	
	@ApiOperation(value = "Clear Purchase History.", notes = "Clears Purchase History.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Purchase History clear.", response=String.class), 
		@ApiResponse(code = 400, message = "Purchase History not Found.", response=String.class),
	})
	@RequestMapping(method = RequestMethod.GET, value = "/clearpurchasehistory", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void clearPurchaseHistory(
			@RequestParam(value="User name") String userName){
		
		User user = userRepo.findByUserName(userName);
		
		purchaseRepo.delete(purchaseRepo.findByUser(user));	
	}
}
