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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplilearn.capstone.foodboxWebApplication.Common.utilities;
import com.simplilearn.capstone.foodboxWebApplication.Dto.Userdetails;
import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Entity.userInfo;
import com.simplilearn.capstone.foodboxWebApplication.Repository.cuisineRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.loginRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.userInfoRepository;
import com.simplilearn.capstone.foodboxWebApplication.ServiceImpl.cuisineServiceImpl;
import com.simplilearn.capstone.foodboxWebApplication.ServiceImpl.userServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class userServiceTest 
{
	@MockBean
	private userInfoRepository userRepo;
	
	@MockBean
	private loginRepository loginRepo;
	
	@InjectMocks
	userServiceImpl userserviceimpl;

	@MockBean
	userService userservice;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ObjectMapper om = new ObjectMapper();
	@Test
	public void registerUserTest()
	{
		om.disable(MapperFeature.USE_ANNOTATIONS);
		
		loginCredentials logincred = utilities.generateLoginCreds();
		when(loginRepo.save(logincred)).thenReturn(logincred);
		userInfo uinfo = utilities.generateUserInfo(logincred);
		//logger.info("{}",logincred);
		//logger.info("{}",uinfo);
		//userInfo usinfo = utilities.generateUserInfo();
		when(userRepo.save(uinfo)).thenReturn(uinfo);
		//logger.info("{}",uinfo);
		Userdetails userdet = utilities.generateUserdetails();
		userInfo usersinfo = userserviceimpl.registerUser(userdet);
		//logger.info("{}",usersinfo);
		//verify(loginRepo,times(1)).save(logincred);
		//verify(userRepo, times(1)).save(uinfo);
		//assertNotNull(usersinfo);
	}
}
