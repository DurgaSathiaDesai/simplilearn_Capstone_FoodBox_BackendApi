package com.simplilearn.capstone.foodboxWebApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;
import com.simplilearn.capstone.foodboxWebApplication.Repository.foodoffersRepository;
import com.simplilearn.capstone.foodboxWebApplication.Service.foodoffersService;

@Service
public class foodoffersServiceImpl implements foodoffersService
{

	@Autowired
	private foodoffersRepository foodoffersRepo;
	
	@Override
	public List<foodOffers> getAllOffers() 
	{
		return foodoffersRepo.findAll();
	}

}
