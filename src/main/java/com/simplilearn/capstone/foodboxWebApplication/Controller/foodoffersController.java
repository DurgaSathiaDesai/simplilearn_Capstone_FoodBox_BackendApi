package com.simplilearn.capstone.foodboxWebApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;
import com.simplilearn.capstone.foodboxWebApplication.Service.foodoffersService;

@RestController
@CrossOrigin(origins="http://3.80.57.60")  
@RequestMapping(value="/api")
public class foodoffersController 
{

	@Autowired
	private foodoffersService foodofferservice;
	
	@GetMapping("/offerslist")  
    public List<foodOffers> getAllOffers() {  
         return foodofferservice.getAllOffers();
    }

}
