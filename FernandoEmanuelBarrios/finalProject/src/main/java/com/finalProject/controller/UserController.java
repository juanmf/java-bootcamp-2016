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

import com.finalProject.entity.User;
import com.finalProject.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
@ComponentScan("com.carrito")
@Api(value = "User", description = "User API", produces = "application/json")
public class UserController {

	@Autowired
	IUserService iUserService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "list User", notes = "Returns all users")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one User at least") })
	public List<User> listAllUsers() {
		return iUserService.listAllUser();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "find User", notes = "Return a user")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one user at least") })
	public User findByUsername(@PathVariable("username") String username) {
		return iUserService.findByUserName(username);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "find User", notes = "Return a user firstname and lastname")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one Product at least") })
	public List<User> findByName(@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName) {
		return iUserService.findByFirstNameAndLastName(firstName, lastName);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete User", notes = "delete a user")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one user at least") }) 
	public void deleteUser(@PathVariable("username") String username) {
		iUserService.deleteUser(iUserService.findByUserName(username));
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.PUT,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update User", notes = "update a user")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one user at least") })
	public void updateUser(@PathVariable("username") String username, @RequestBody User user) {
		iUserService.updateUser(user);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "add User", notes = "Return a string")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one user at least") }) 
	public String addUser(@RequestBody User user) {
		iUserService.addUser(user);
		return "success";
	}
}
