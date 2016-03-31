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

import com.bootcamp.finalproject.entities.ShoppingCart;
import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.repositories.PurchaseRepository;
import com.bootcamp.finalproject.repositories.ShoppingCartRepository;
import com.bootcamp.finalproject.repositories.UserRepository;
import com.bootcamp.finalproject.services.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/registration")
@Api(value = "User Registration Controller")
public class UserController {

	@Autowired
	UserServiceImpl userReg;
	
	@Autowired
	ShoppingCartRepository cartRepo;
	
	@Autowired 
	UserRepository userRepo;
	
	@Autowired
	PurchaseRepository purchaseRepo;

	ShoppingCart cart;
	
	User user;
	
	
	/**
	 * This controls the addUser method. When a new user is added, it also creates a ShoppingCart object and passes the created user as an
	 * argument for the ShoppingCart. At the same time, it saves the ShoppingCart into the corresponding repository.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param dni
	 */
	@ApiOperation(value = "Add a User.", notes = "Register a new User.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User added.", response=String.class), 
		@ApiResponse(code = 400, message = "Invalid Username.", response=String.class),
	})
	@RequestMapping(value = "/adduser", method=RequestMethod.POST)
	public ResponseEntity<String> addUser(
			@RequestParam(value="First name") String firstName, 
			@RequestParam(value="Last name") String lastName, 
			@RequestParam(value="Username") String userName,
			@RequestParam(value="Password") String password,
			@RequestParam(value="eMail") String eMail,
			@RequestParam(value="Dni") int dni
		){
		
		user = userRepo.findByUserName(userName);
		
		if(user != null){
	
			return new ResponseEntity<String>("Invalid Username", HttpStatus.BAD_REQUEST);
		}
		else{
			
			user = new User(firstName, lastName, userName, password, eMail, dni);
			cart = new ShoppingCart(user);
			userReg.addUser(user);
			cartRepo.save(cart);
			
			return new ResponseEntity<String>("User added.", HttpStatus.OK);
		}
	}
	
	
	/**
	 * This controls the removeUser method. When a User is remove, that user's ShoppingCart object persisted in the 
	 * ShoppingCart repository gets delete
	 * 
	 * @param userName
	 */
	@ApiOperation(value = "Removes a User.", notes = "Removes a User from the  list. It takes the Username to identify the correct User to be deleted.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User removed.", response=String.class),
		@ApiResponse(code = 400, message = "User not found.", response=String.class)
	})
	@RequestMapping(method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void removeUser(@RequestParam(value="Username") String userName){
		
		//Arreglar para q devuelva una response para usuario no encontrado
		purchaseRepo.delete(purchaseRepo.findByUser(userRepo.findByUserName(userName)));
		cartRepo.delete(cartRepo.findByUser(userReg.findByUserName(userName)));
		userReg.removeUser(userRepo.findByUserName(userName));
	}
		 
	
	
	/**
	 * This controls the findByName method. It takes the first and last name of the user that needs to be found
	 * and returns the matching User object for those parameters.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@ApiResponses({
		@ApiResponse(code = 200, message = "User found.", response=String.class), 
		@ApiResponse(code = 400, message = "Failed to find User.", response=String.class),
	})
	@RequestMapping(value = "/findbyname", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User findByName(
			@RequestParam(value="First name")String firstName, 
			@RequestParam(value="Last name") String lastName){
	
		return userReg.findByName(firstName, lastName);
	}
	
	
	/**
	 * This controls the findByName method. It takes the Username of the user that needs to be found
	 * and returns the matching User object for those parameters.
	 * @param userName
	 * @return
	 */
	@ApiResponses({
		@ApiResponse(code = 200, message = "User found.", response=String.class), 
		@ApiResponse(code = 400, message = "Failed to find User.", response=String.class),
	})
	@RequestMapping(value = "/findbynickname", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User findByNickname(@RequestParam(value="Username") String userName){
		
		return userReg.findByUserName(userName);
	} 
	
	
	/**
	 * This controls the updateUser method. It takes the Username to update the correct user info.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param dni
	 */
	@ApiOperation(value="Updates User information.", notes="Takes the first and last name to identify the correct User that is going to be changed.")
	@ApiResponses({
		@ApiResponse(code=200, message="User updated.", response=String.class),
		@ApiResponse(code=400, message="Failed to update User.", response=String.class)
	})
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(
			@RequestParam(value="Username") String userName,
			@RequestParam(value="New email.") String eMail
			){
		
		userReg.updateUser(userName, eMail);
	}
	
	
	/**
	 * Shows all Users persisted in Repository.
	 * @return
	 */
	@ApiOperation(value = "Displays User List.",response = List.class, notes = "Display Users in list.")
	@ApiResponses(
		@ApiResponse(code = 200, message = "Users list.", response=String.class)
	)
	@RequestMapping(value = "/userslist", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getUsers(){
		return userReg.getAllUsers();
	}
	
	
	
}










