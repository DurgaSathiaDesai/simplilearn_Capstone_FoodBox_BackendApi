package com.simplilearn.capstone.foodboxWebApplication.Service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.simplilearn.capstone.foodboxWebApplication.Common.utilities;
import com.simplilearn.capstone.foodboxWebApplication.Dto.fooditem;
import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;
import com.simplilearn.capstone.foodboxWebApplication.Repository.cuisineRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.fooditemRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.foodoffersRepository;
import com.simplilearn.capstone.foodboxWebApplication.ServiceImpl.cuisineServiceImpl;
import com.simplilearn.capstone.foodboxWebApplication.ServiceImpl.fooditemServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class fooditemServiceTest 
{
	@MockBean
	private fooditemRepository fooditemRepo;
	
	@MockBean
	private cuisineRepository cuisineRepo;
	
	@MockBean
	private foodoffersRepository foodoffersRepo;
	
	@InjectMocks
	fooditemServiceImpl fooditemserviceimpl;

	@MockBean
	fooditemService fooditemservice;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void getAllFooditems()
	{
		long id = 2;
		
		cuisines tmpcuisine = new cuisines(); 
		tmpcuisine.setCuisineId(2);
		tmpcuisine.setCuisinename("Italian Cuisine");
		tmpcuisine.setAvailstatus("enabled");
		
		foodOffers foffer = new foodOffers(); 
		foffer.setOfferId(2);
		foffer.setOffername("20% OFF"); 
		foffer.setAvailstatus("active");
		 
		List<fooditems> foodlist = utilities.generateFooditemsList();
		when(fooditemRepo.findAll()).thenReturn(foodlist);
		logger.info("cname-->{}",foodlist);
		when(cuisineRepo.getById(id)).thenReturn(tmpcuisine);
		when(foodoffersRepo.getById(id)).thenReturn(foffer);
		List<fooditem> fooditemlist = fooditemserviceimpl.getAllFoodItems();
		verify(fooditemRepo, times(1)).findAll();
		verify(cuisineRepo,times(2)).getById(id);
		verify(foodoffersRepo,times(2)).getById(id);
		assertNotNull(fooditemlist);
	}
}
