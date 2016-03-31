package com.bootcamp.finalproject.entities;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.finalproject.repositories.UserRepository;

import io.swagger.annotations.ApiModel;

@Component
@ApiModel(value = "Login Class", description = "Class use to Log in or Log out an User to the system.")
public class Login {

	
	private User user;
	
	private List<User> list;
	
	@Autowired
	private UserRepository userRepo;
	
	
	public Login(){
		list = new LinkedList<User>();
	}
	
	public String login(String userName){
		
		user = userRepo.findByUserName(userName);
		
		if(user == null){
			return "User not registered.";
		}
		else{
			if(list.contains(user)){
				user.setConnected(true);
				list.set(list.indexOf(user), user);
				return "User Logged.";
			}
			else{
				user.setConnected(true);
				list.add(user);
				return "User Logged.";
			}
		}
	}
	
	
	
	public String logout(String userName){
		
		user = userRepo.findByUserName(userName);
		
		if(user == null){
			return "User not registered.";
		}
		else{
			if(list.contains(user)){
				user.setConnected(false);
				list.set(list.indexOf(user), user);
				return "User unlogged.";
			}
			else{
				return "User not found";
			}
		}
	}

	
	
	
	public List<User> getList() {
		return list;
	}
	
	
	
	
	public boolean findLoggedUser(String userName){
		
		boolean flag = false;
		user = userRepo.findByUserName(userName);
		for(User temp: list){
			if(temp.equals(user)){
				flag = temp.isConnected();
			}
		}
		
		if(list.contains(user) && flag == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
}
