package com.simplilearn.capstone.foodboxWebApplication.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.foodboxWebApplication.Dto.Userdetails;
import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Entity.userInfo;
import com.simplilearn.capstone.foodboxWebApplication.Repository.loginRepository;
import com.simplilearn.capstone.foodboxWebApplication.Repository.userInfoRepository;
import com.simplilearn.capstone.foodboxWebApplication.Service.userService;

@Service
public class userServiceImpl implements userService
{

	@Autowired
	private loginRepository loginRepo;
	
	@Autowired
	private userInfoRepository userRepo;
	
	@Override
	public userInfo registerUser(Userdetails userdet) 
	{
		String username = userdet.getUsername();
		String pwd = userdet.getPword();
		String role = "user";
		String accstatus = "active";
		
		loginCredentials logincred = new loginCredentials();
		
		logincred.setUsername(username);
		logincred.setPword(pwd);
		logincred.setRole(role);
		logincred.setAccountstatus(accstatus);
		
		loginCredentials savedlogincred = loginRepo.save(logincred);
		
		userInfo user = new userInfo();
		
		user.setFirstname(userdet.getFirstname());
		user.setLastname(userdet.getLastname());
		user.setAddress(userdet.getAddress());
		user.setEmailId(userdet.getEmailId());
		user.setContactNo(userdet.getContactNo());
		user.setUserCredentials(savedlogincred);
		
		userInfo regUser = userRepo.save(user);
		return regUser;
	}

}
