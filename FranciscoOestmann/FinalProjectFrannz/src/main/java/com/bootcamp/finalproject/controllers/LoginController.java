package com.bootcamp.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.finalproject.entities.Login;
import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.repositories.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LoginController {
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	Login login;
	
	String text;
	
	
	@ApiOperation(value = "Login", notes = "Logs in an User.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User Logged", response=String.class), 
		@ApiResponse(code = 400, message = "Invalid Username", response=String.class),
	})
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam (value="Username") String userName) {
		
        return login.login(userName);
    }
	
	
	
	
	
	
	@ApiOperation(value = "Logout", notes = "Logs out an User.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User Unlogged", response=String.class), 
		@ApiResponse(code = 400, message = "Invalid Username", response=String.class),
	})
	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String logout(@RequestParam (value="Username") String userName) {

        return login.logout(userName);
    }
	
	
	
	
	@ApiOperation(value = "Logged Users.", notes = "shows a list of logged Users.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User Unlogged", response=String.class), 
		@ApiResponse(code = 400, message = "Invalid Username", response=String.class),
	})
	@RequestMapping(value = "/showloggedusers", method = RequestMethod.GET)
    public List<User> showLoggedUser() {
		return login.getList();
    }
}
