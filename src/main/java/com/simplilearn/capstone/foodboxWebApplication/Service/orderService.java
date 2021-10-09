package com.simplilearn.capstone.foodboxWebApplication.Service;

import com.simplilearn.capstone.foodboxWebApplication.Dto.Purchase;
import com.simplilearn.capstone.foodboxWebApplication.Dto.PurchaseResponse;

public interface orderService 
{
	PurchaseResponse placeOrder(Purchase purchase);
}
