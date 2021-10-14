package com.simplilearn.capstone.foodboxWebApplication.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.simplilearn.capstone.foodboxWebApplication.Common.utilities;
import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Repository.cuisineRepository;
import com.simplilearn.capstone.foodboxWebApplication.ServiceImpl.cuisineServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class cuisineServiceTest 
{
	@MockBean
	private cuisineRepository cuisineRepo;
	
	@InjectMocks
	cuisineServiceImpl cuisineserviceimpl;

	@MockBean
	cuisineService cuisineservice;
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void getAllCuisinesTest()
	{
		List<cuisines> clist = utilities.generateCuisinesList();
		
		when(cuisineRepo.getAllAvailableCuisines("enabled")).thenReturn(clist);
		List<cuisines> cuisinelist = cuisineserviceimpl.getAllCuisines();
		verify(cuisineRepo, times(1)).getAllAvailableCuisines("enabled");
		assertNotNull(cuisinelist);
		
	}
}
