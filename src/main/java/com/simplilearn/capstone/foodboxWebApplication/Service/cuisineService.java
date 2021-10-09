package com.simplilearn.capstone.foodboxWebApplication.Service;

import java.util.List;

import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;

public interface cuisineService 
{
	cuisines addCuisine(cuisines cuisine);
	
	cuisines removeCuisine(long id);
	
	List<cuisines> getAllCuisines();
}
