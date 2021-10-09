package com.simplilearn.capstone.foodboxWebApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.foodboxWebApplication.Dto.Userdetails;
import com.simplilearn.capstone.foodboxWebApplication.Entity.userInfo;
import com.simplilearn.capstone.foodboxWebApplication.Service.userService;

@RestController
@CrossOrigin(origins="http://54.173.120.218")  
@RequestMapping(value="/api")
public class userInfoController 
{
	@Autowired
	private userService userservice;
	
	 @PostMapping("/signup")
	 public userInfo register(@RequestBody Userdetails userdet) 
	 {  
		 return userservice.registerUser(userdet);
	 }
}
