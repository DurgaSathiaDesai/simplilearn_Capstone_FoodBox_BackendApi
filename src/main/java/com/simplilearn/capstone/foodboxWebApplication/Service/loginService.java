package com.simplilearn.capstone.foodboxWebApplication.Service;

import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;

public interface loginService 
{
	loginCredentials loginValidate(loginCredentials Creds);
	
	loginCredentials updateCredentials(loginCredentials Creds);
}
