package com.simplilearn.capstone.foodboxWebApplication.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.foodboxWebApplication.Dto.fooditem;
import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;
import com.simplilearn.capstone.foodboxWebApplication.Repository.cuisineRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.fooditemRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.foodoffersRepository;
import com.simplilearn.capstone.foodboxWebApplication.Service.fooditemService;

@Service
public class fooditemServiceImpl implements fooditemService
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private fooditemRepository fooditemRepo;
	
	@Autowired
	private cuisineRepository cuisineRepo;
	
	@Autowired
	private foodoffersRepository foodoffersRepo;

	@Override
	public List<fooditem> getAllFoodItems() 
	{
		//String status = "available";
		//List<fooditems> fooditemslist = fooditemRepo.getAllAvailableFooditems(status);
		
		List<fooditems> fooditemslist = fooditemRepo.findAll();
		List<fooditem> fooditemlist = new ArrayList<fooditem>();
		for(fooditems fitem : fooditemslist)
		{
			fooditem fditem = new fooditem();
			fditem.setFoodId(fitem.getFoodId());
			fditem.setFoodname(fitem.getFoodname());
			//logger.info("cname-->{}",fitem.getPcuisine().getCuisineId());
			cuisines cuisine = cuisineRepo.getById(fitem.getPcuisine().getCuisineId());
			//logger.info("uname-->{}",cuisine.getCuisinename());
			fditem.setCuisinename(cuisine.getCuisinename());
			fditem.setFddescription(fitem.getFddescription());
			fditem.setPrice(fitem.getPrice());
			foodOffers offer = foodoffersRepo.getById(fitem.getFdoffers().getOfferId());
			fditem.setOffers(offer.getOffername());
			fditem.setImage(fitem.getImage());
			fditem.setFoodstatus(fitem.getFoodstatus());
			fooditemlist.add(fditem);
		}
		
		
		return fooditemlist;
	}

	@Override
	public fooditems enableFooditem(long id, fooditem fditem) 
	{
		fooditems fitem = fooditemRepo.getById(id);
		fitem.setFoodstatus(fditem.getFoodstatus());
		return fooditemRepo.save(fitem);
	}
	

	@Override
	public fooditems disableFooditem(long id, fooditem fditem) 
	{
		fooditems fitem = fooditemRepo.getById(id);
		fitem.setFoodstatus(fditem.getFoodstatus());
		return fooditemRepo.save(fitem);
	}

	@Override
	public fooditem getFooditem(long id) 
	{
		fooditems fitem = fooditemRepo.getById(id);
		fooditem fditem = new fooditem();
		fditem.setFoodId(fitem.getFoodId());
		fditem.setFoodname(fitem.getFoodname());
		logger.info("cname-->{}",fitem.getPcuisine().getCuisineId());
		cuisines cuisine = cuisineRepo.getById(fitem.getPcuisine().getCuisineId());
		logger.info("uname-->{}",cuisine.getCuisinename());
		fditem.setCuisinename(cuisine.getCuisinename());
		fditem.setFddescription(fitem.getFddescription());
		fditem.setPrice(fitem.getPrice());
		logger.info("offname-->{}",fitem.getFdoffers().getOfferId());
		foodOffers offer = foodoffersRepo.getById(fitem.getFdoffers().getOfferId());
		logger.info("uname-->{}",offer.getOffername());
		fditem.setOffers(offer.getOffername());
		fditem.setImage(fitem.getImage());
		fditem.setFoodstatus(fitem.getFoodstatus());
		
		return fditem;
	}

	@Override
	public fooditem saveFoodItem(fooditem fditem) 
	{
		fooditems tempFitem = new fooditems();
		
		tempFitem.setFoodname(fditem.getFoodname());
		tempFitem.setFddescription(fditem.getFddescription());
		cuisines cuisine = cuisineRepo.checkCuisineByName(fditem.getCuisinename());
		tempFitem.setPcuisine(cuisine);
		tempFitem.setPrice(fditem.getPrice());
		foodOffers fdoffer = foodoffersRepo.checkOffersByName(fditem.getOffers());
		tempFitem.setFdoffers(fdoffer);
		tempFitem.setImage(fditem.getImage());
		tempFitem.setFoodstatus(fditem.getFoodstatus());
		
		fooditems savedFooditem = fooditemRepo.save(tempFitem);
		
		fooditem newFooditem = fditem;
		newFooditem.setFoodId(savedFooditem.getFoodId());
		return newFooditem;
	}

	@Override
	public fooditem updateFoodItem(fooditem fditem) 
	{
		fooditems tempFitem = fooditemRepo.getById(fditem.getFoodId());
		
		tempFitem.setFoodname(fditem.getFoodname());
		tempFitem.setFddescription(fditem.getFddescription());
		cuisines cuisine = cuisineRepo.checkCuisineByName(fditem.getCuisinename());
		tempFitem.setPcuisine(cuisine);
		tempFitem.setPrice(fditem.getPrice());
		foodOffers fdoffer = foodoffersRepo.checkOffersByName(fditem.getOffers());
		tempFitem.setFdoffers(fdoffer);
		tempFitem.setImage(fditem.getImage());
		fooditems savedFooditem = fooditemRepo.save(tempFitem);
		
		fooditem newFooditem = fditem;
		newFooditem.setFoodstatus(savedFooditem.getFoodstatus());
		return newFooditem;
	}

}
