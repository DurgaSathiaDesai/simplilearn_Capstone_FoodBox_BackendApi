package com.simplilearn.capstone.foodboxWebApplication.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Service.loginService;


@RestController
@CrossOrigin(origins="http://3.80.57.60")  
@RequestMapping(value="/api")
public class loginController 
{
	@Autowired
	private loginService loginservice;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @PostMapping("/loginvalidate")
	 public loginCredentials loginValidate(@RequestBody loginCredentials adminCreds) 
	 {  
		 return loginservice.loginValidate(adminCreds);
	 }
	 
		
	 @PutMapping("/updatecredentials") 
	 public loginCredentials updateCredentials(@RequestBody loginCredentials adminCreds) 
	 { 
		 logger.info("id-->{}",adminCreds.getLoginid());
		 return loginservice.updateCredentials(adminCreds); 
	 }
		 
	
}
