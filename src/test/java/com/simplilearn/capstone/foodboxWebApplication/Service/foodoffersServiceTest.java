package com.simplilearn.capstone.foodboxWebApplication.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.simplilearn.capstone.foodboxWebApplication.Common.utilities;
import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;
import com.simplilearn.capstone.foodboxWebApplication.Repository.foodoffersRepository;
import com.simplilearn.capstone.foodboxWebApplication.ServiceImpl.foodoffersServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class foodoffersServiceTest 
{
	@MockBean
	private foodoffersRepository foodoffersRepo;
	
	@InjectMocks
	foodoffersServiceImpl foodoffersserviceimpl;

	@MockBean
	foodoffersService foodoffersservice;
	
	@Test
	public void getAllFoodOffersTest()
	{
		List<foodOffers> offerlist = utilities.generateFoodOffersList();
		
		when(foodoffersRepo.findAll()).thenReturn(offerlist);
		List<foodOffers> offerslist = foodoffersserviceimpl.getAllOffers();
		verify(foodoffersRepo, times(1)).findAll();
		assertNotNull(offerslist);
	}
}
