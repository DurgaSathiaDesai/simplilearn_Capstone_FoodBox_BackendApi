package com.simplilearn.capstone.foodboxWebApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.foodboxWebApplication.Dto.Purchase;
import com.simplilearn.capstone.foodboxWebApplication.Dto.PurchaseResponse;
import com.simplilearn.capstone.foodboxWebApplication.Service.orderService;


@RestController
@CrossOrigin(origins="http://54.173.120.218")  
@RequestMapping(value="/api") 
public class orderController 
{
	@Autowired
	private orderService orderservice;
	
	@PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = orderservice.placeOrder(purchase);

        return purchaseResponse;
    }

}
