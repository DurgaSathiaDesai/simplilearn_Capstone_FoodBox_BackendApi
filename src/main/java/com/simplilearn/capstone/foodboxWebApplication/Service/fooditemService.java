package com.simplilearn.capstone.foodboxWebApplication.Service;

import java.util.List;

import com.simplilearn.capstone.foodboxWebApplication.Dto.fooditem;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;

public interface fooditemService 
{
	List<fooditem> getAllFoodItems();
	fooditems enableFooditem(long id,fooditem fditem);
	fooditems disableFooditem(long id,fooditem fditem);
	fooditem getFooditem(long id);
	
	fooditem saveFoodItem(fooditem fditem);
	fooditem updateFoodItem(fooditem fditem);
}
