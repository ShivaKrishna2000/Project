package com.orchard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.orchard.entity.User;

import com.orchard.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUsers(@RequestBody User user) throws Exception {
        
		String tempUser=user.getUserName();
		
		if(tempUser!=null && !"".equals(tempUser)) {
		 User userobj=userService.fetchByUserName(tempUser);
		 if(userobj!=null) {
			 throw new Exception("user with "+user.getUserName()+ " is already exist"); 
		 }
		}
		return userService.registerUsers(user); 
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		
		String tempUserName=user.getUserName();
		String tempPassword=user.getPassword();
		User userObj=null;
		if(tempUserName!=null&&tempPassword!=null) {
			 userObj=userService.fetchByUserNameAndPassword(tempUserName,tempPassword);
		}
		if(userObj==null) {
			throw new Exception("Bad Creadential");
		}
		return userObj;
		
	}
	
}
