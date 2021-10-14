package com.simplilearn.capstone.foodboxWebApplication.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Repository.loginRepository;
import com.simplilearn.capstone.foodboxWebApplication.ServiceImpl.loginServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class loginServiceTest 
{
	@MockBean
	private loginRepository loginRepo;
	
	@InjectMocks
	loginServiceImpl loginserviceimpl;

	@MockBean
	loginService loginservice;
	
	@Test
	public void validateLogin()
	{
		loginCredentials creds = new loginCredentials();
	
		creds.setUsername("PaulWalker");
		creds.setPword("Paul1234");
		creds.setAccountstatus("active");
		
		when(loginRepo.findByCredentials("PaulWalker", "Paul1234", "active")).thenReturn(creds);
		
		loginCredentials lcreds = loginserviceimpl.loginValidate(creds);
		verify(loginRepo, times(1)).findByCredentials("PaulWalker", "Paul1234", "active");
		assertNotNull(lcreds);
	}
}
