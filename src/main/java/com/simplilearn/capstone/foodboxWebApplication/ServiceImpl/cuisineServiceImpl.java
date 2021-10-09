package com.simplilearn.capstone.foodboxWebApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;
import com.simplilearn.capstone.foodboxWebApplication.Repository.cuisineRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.fooditemRepository;
import com.simplilearn.capstone.foodboxWebApplication.Service.cuisineService;

@Service
public class cuisineServiceImpl implements cuisineService
{
	@Autowired
	private cuisineRepository cuisineRepo;
	
	@Autowired
	private fooditemRepository fooditemRepo;

	@Override
	public cuisines addCuisine(cuisines cuisine) 
	{
		String name = cuisine.getCuisinename();
		cuisines tempcuisine = cuisineRepo.checkCuisineByName(name);
		if(tempcuisine == null)
		{
			cuisines newcuisine = new cuisines();
			newcuisine.setCuisinename(cuisine.getCuisinename());
			newcuisine.setAvailstatus("enabled");
			return cuisineRepo.save(newcuisine);
		}
		else
		{
			if(tempcuisine.getAvailstatus().equals("disabled"))
			{
				tempcuisine.setAvailstatus("enabled");
				cuisines tmpcuisine = cuisineRepo.save(tempcuisine);
				if(tmpcuisine != null)
				{
					List<fooditems> fooditemlist = tmpcuisine.getFooditems();
					
					for(fooditems fooditem : fooditemlist)
					{
						fooditem.setFoodstatus("available");
						fooditemRepo.save(fooditem);
					}
				}
				
				return tmpcuisine;
				
			}
			else
			{
				return null;
			}
		}
	}

	@Override
	public cuisines removeCuisine(long id) 
	{
		cuisines cuisine = cuisineRepo.getById(id);
		cuisine.setAvailstatus("disabled");
		cuisines tempcuisine = cuisineRepo.save(cuisine);
		if(tempcuisine != null)
		{
			List<fooditems> fooditemlist = tempcuisine.getFooditems();
			
			for(fooditems fooditem : fooditemlist)
			{
				fooditem.setFoodstatus("NA");
				fooditemRepo.save(fooditem);
			}
		}
		return tempcuisine;
	}

	@Override
	public List<cuisines> getAllCuisines() 
	{
		String status = "enabled";
		return cuisineRepo.getAllAvailableCuisines(status);
	}

}
