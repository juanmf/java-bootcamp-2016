package com.bootcamp.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.services.UserRegistrationServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/registration")
@Api(value = "User Registration Controller")
public class UserRegistrationController {

	@Autowired
	UserRegistrationServiceImpl userReg;
	
	
	
	@ApiOperation(value = "Add a User", notes = "Register a new User")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User added.", response=String.class), 
		@ApiResponse(code = 400, message = "Failed to add User.", response=String.class),
	})
	@RequestMapping(value = "/adduser", method=RequestMethod.POST)
	public void addUser(
			@RequestParam(value="First name") String firstName, 
			@RequestParam(value="Last name") String lastName, 
			@RequestParam(value="Username") String userName,
			@RequestParam(value="Dni") int dni,
			@RequestParam(value="Street") String street,
			@RequestParam(value="Number") int number,
			@RequestParam(value="City") String city,
			@RequestParam(value="Country") String country
			){
		//Address address = new Address(street, number, city, country);
		User user = new User(firstName, lastName, userName, dni);
		
			userReg.addUser(user);
	}
	
	
	
	@ApiOperation(value = "Removes a User", notes = "Removes a User from the  list. It takes a int DNI to identify the correct User to be deleted.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User removed.", response=String.class),
		@ApiResponse(code = 400, message = "Failed to remove User.", response=String.class)
	})
	@RequestMapping(method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void removeUser(@RequestParam(value="Dni") int dni) {
		userReg.removeUser(userReg.findByDni(dni));
	}
		 
	
	
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
	
	
	
	@ApiResponses({
		@ApiResponse(code = 200, message = "User found.", response=String.class), 
		@ApiResponse(code = 400, message = "Failed to find User.", response=String.class),
	})
	@RequestMapping(value = "/findbynickname", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User findByNickname(@RequestParam(value="Username") String userName){
		
		return userReg.findByNickname(userName);
	} 
	
	
	
	@ApiOperation(value="Updates Cart content.", notes="Takes an int DNI of the User that is going to be changed.")
	@ApiResponses({
		@ApiResponse(code=200, message="User updated.", response=String.class),
		@ApiResponse(code=400, message="Failed to update User.", response=String.class)
	})
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestParam(value="id") String id,
			@RequestParam(value="first name") String firstName,
			@RequestParam(value="last name") String lastName,
			@RequestParam(value="Username") String userName, 
			@RequestParam(value="dni") int dni
			){
		
		userReg.updateUser(id, firstName, lastName, userName, dni);
	}
	
	
	
	@ApiOperation(value = "Displays User List",response = List.class, notes = "Display Users in list.")
	@ApiResponses(
		@ApiResponse(code = 200, message = "Users list", response=String.class)
	)
	@RequestMapping(value = "/userslist", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(){
		return userReg.getUsers();
	}
	
}










