package com.simplilearn.capstone.foodboxWebApplication.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.foodboxWebApplication.Dto.Purchase;
import com.simplilearn.capstone.foodboxWebApplication.Dto.PurchaseResponse;
import com.simplilearn.capstone.foodboxWebApplication.Dto.checkoutfoods;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;
import com.simplilearn.capstone.foodboxWebApplication.Entity.orders;
import com.simplilearn.capstone.foodboxWebApplication.Entity.payment;
import com.simplilearn.capstone.foodboxWebApplication.Repository.fooditemRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.foodorderRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.ordersRepository;
import com.simplilearn.capstone.foodboxWebApplication.Service.orderService;


@Service
public class orderServiceImpl implements orderService
{
	@Autowired
	private ordersRepository orderRepo;
	
	@Autowired
	private foodorderRepository foodorderRepo;
	
	@Autowired
	private fooditemRepository foodItemRepo;

	@Override
	public PurchaseResponse placeOrder(Purchase purchase) 
	{
		LocalDateTime today = java.time.LocalDateTime.now();
		orders ords = purchase.getOrder();
		
		//orders order = new orders();
		String orderTrackingNumber = generateOrderTrackingNumber();
		ords.setOrderTrackingNo(orderTrackingNumber);
		
		ords.setOrderDate(today);
		
		ords.setOrderStatus("placed");
		 
		orders ord = orderRepo.save(ords);
		 
		List<checkoutfoods> foodorders = purchase.getCheckoutfood();
		for(checkoutfoods orderfood : foodorders)
		{
			long id = orderfood.getFoodid();
			fooditems fitem = foodItemRepo.getById(id);
			foodorderRepo.saveOrderedFood(orderfood, ord,fitem);
		}
		payment pay = purchase.getOrderpayments();
		
		if(!(Objects.isNull(pay)))
		{
			foodorderRepo.savePayment(pay, ord);
		}
		
		return new PurchaseResponse(orderTrackingNumber);
	}
	
	private String generateOrderTrackingNumber()
	{

        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
	
	
	
		
	

