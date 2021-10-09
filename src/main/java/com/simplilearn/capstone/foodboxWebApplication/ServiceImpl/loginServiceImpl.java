package com.simplilearn.capstone.foodboxWebApplication.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Repository.loginRepository;
import com.simplilearn.capstone.foodboxWebApplication.Service.loginService;


@Service
public class loginServiceImpl implements loginService
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private loginRepository loginRepo;
	
	@Override
	public loginCredentials loginValidate(loginCredentials creds) {
		String username = creds.getUsername();
		String pword = creds.getPword();
		//logger.info("uname-->{}",username);
		//logger.info("pwd-->{}",pword);
		String accstatus = "active";
		
		loginCredentials cred =loginRepo.findByCredentials(username, pword, accstatus);
		//logger.info("role-->{}",cred.getRole());
		return cred;
	}

	@Override
	public loginCredentials updateCredentials(loginCredentials Creds) 
	{
		loginCredentials cred = loginRepo.getById(Creds.getLoginid());
		cred.setUsername(Creds.getUsername());
		cred.setPword(Creds.getPword());
		return loginRepo.save(cred);
	}
}
