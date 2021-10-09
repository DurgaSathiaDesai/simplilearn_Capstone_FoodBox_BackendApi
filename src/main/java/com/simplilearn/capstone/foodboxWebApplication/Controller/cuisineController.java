package com.simplilearn.capstone.foodboxWebApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Service.cuisineService;
import com.simplilearn.capstone.foodboxWebApplication.Service.loginService;


@RestController
@CrossOrigin(origins="http://54.173.120.218")  
@RequestMapping(value="/api")
public class cuisineController 
{
	@Autowired
	private cuisineService cuisineservice;
	
	@GetMapping("/cuisinelist")  
    public List<cuisines> getAllCuisines() {  
         return cuisineservice.getAllCuisines();
    }
    
	@PostMapping("/addcuisine")
	public cuisines addCuisine(@RequestBody cuisines cuisine) 
	{  
		return cuisineservice.addCuisine(cuisine);
	}
	 
	@DeleteMapping("/removecuisine/{id}")
	public cuisines removeCuisine(@PathVariable("id") long id)
	{
		return cuisineservice.removeCuisine(id);
	}

}
