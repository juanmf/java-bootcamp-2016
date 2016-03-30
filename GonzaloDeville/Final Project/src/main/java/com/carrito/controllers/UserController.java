package com.carrito.controllers;

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

import com.carrito.entities.User;
import com.carrito.services.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
@ComponentScan("com.carrito")
@Api(value = "User", description = "user Controller and all operations", produces = "application/json")
public class UserController {

	@Autowired
	IUserService iUserService;
	
	@ApiOperation(value = "List of all users")
	@RequestMapping(method = RequestMethod.GET)
	public List<User> listAllUsers() {
		return iUserService.listAllUsers();
	}
	
	@ApiOperation(value = "Find an user by username")
	@ApiImplicitParams({ @ApiImplicitParam(name = "username", required = true, dataType = "String") })
	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUsername(@PathVariable("username") String username) {
		return iUserService.findByUserName(username);
	}
	
	@ApiOperation(value = "Find an user by first name and last name")
	@ApiImplicitParams({ @ApiImplicitParam(name = "firstMame", required = true, dataType = "String"),
			@ApiImplicitParam(name = "lastName", required = true, dataType = "String") })
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findByName(@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName) {
		return iUserService.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@ApiOperation(value = "Delete an user")
	@ApiImplicitParams({ @ApiImplicitParam(name = "username", required = true, dataType = "String") })
	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("username") String username) {
		iUserService.deleteUser(iUserService.findByUserName(username));
	}
	
	@ApiOperation(value = "Update user info")
	@ApiImplicitParams({ @ApiImplicitParam(name = "username", required = true, dataType = "String") })
	@RequestMapping(value = "/{username}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@PathVariable("username") String username, @RequestBody User user) {
		iUserService.updateUser(user);
	}
	
	@ApiOperation(value = "Register a new user")
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {	
		if(!iUserService.findByUser(user)){
			iUserService.addUser(user);	
			return user.getFirstName() + " registered successfully :)";
		}
		return ":O Username "+ user.getUserName()+" alreaydy exist, please try another";
	}
}
