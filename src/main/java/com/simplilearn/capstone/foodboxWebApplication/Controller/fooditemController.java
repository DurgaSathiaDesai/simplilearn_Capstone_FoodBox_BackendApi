package com.simplilearn.capstone.foodboxWebApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.foodboxWebApplication.Dto.fooditem;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;
import com.simplilearn.capstone.foodboxWebApplication.Service.fooditemService;


@RestController
@CrossOrigin(origins="http://54.173.120.218:80")  
@RequestMapping(value="/api")
public class fooditemController 
{
	@Autowired
	private fooditemService fooditemservice;
	
	@GetMapping("/foodlist")  
    public List<fooditem> getAllFoodItems() {  
         return fooditemservice.getAllFoodItems();
    }
    
    @PutMapping("/enablefooditem/{id}")
	 public fooditems enableFooditem(@PathVariable("id") long id, @RequestBody fooditem fditem)
	 {
		 return fooditemservice.enableFooditem(id, fditem);
	 }
    
    @PutMapping("/disablefooditem/{id}")
	 public fooditems disableFooditem(@PathVariable("id") long id, @RequestBody fooditem fditem)
	 {
		 return fooditemservice.disableFooditem(id, fditem);
	 }
    
    @PutMapping("/getfooditem")  
    public fooditem getFooditem(@RequestBody long id) {  
         return fooditemservice.getFooditem(id);
    }
    
    @PutMapping("/editfooditem")
    public fooditem updateFoodItem(@RequestBody fooditem fitem) {  
        return fooditemservice.updateFoodItem(fitem);
   }
    
    @PostMapping("/addfooditem")
    public fooditem saveFoodItem(@RequestBody fooditem fitem) {  
        return fooditemservice.saveFoodItem(fitem);
   }
}
