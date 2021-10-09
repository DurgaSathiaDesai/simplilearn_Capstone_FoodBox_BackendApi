package com.simplilearn.capstone.foodboxWebApplication.Repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.capstone.foodboxWebApplication.Dto.checkoutfoods;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;
import com.simplilearn.capstone.foodboxWebApplication.Entity.orderedfoods;
import com.simplilearn.capstone.foodboxWebApplication.Entity.orders;
import com.simplilearn.capstone.foodboxWebApplication.Entity.payment;


@Repository
@Transactional
public class foodorderRepository 
{
	@Autowired
	EntityManager em;
	
	public void saveOrderedFood(checkoutfoods orderedfood,orders ord,fooditems fditem)
	{
		orderedfoods ordfood = new orderedfoods();
		ordfood.setOrder(ord);
		ordfood.setFditem(fditem);
		//ordfood.getPrimaryKey().getFood().setFoodId(orderedfood.getfooditem().getFordoodId());
		
		ordfood.setFoodname(orderedfood.getFoodname());
		
		ordfood.setPrice(orderedfood.getPrice());
		
		ordfood.setQuantity(orderedfood.getQuantity());
		
		ordfood.setOffers(orderedfood.getOffers());
		
		em.persist(ordfood);
	}
	
	public void savePayment(payment pay,orders ord)
	{
		pay.setOrderpayment(ord);
		em.persist(pay);
	}
}
