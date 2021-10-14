package com.simplilearn.capstone.foodboxWebApplication.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplilearn.capstone.foodboxWebApplication.Common.utilities;
import com.simplilearn.capstone.foodboxWebApplication.Dto.Userdetails;
import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Entity.userInfo;
import com.simplilearn.capstone.foodboxWebApplication.Service.userService;

@WebMvcTest(userInfoController.class)
public class userInfoControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private userService userservice;
	 
	ObjectMapper om = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void saveUserInfo() throws Exception
	{
		String uri = "/api/signup";
		
		Userdetails userinfo = utilities.generateUserdetails();
		
		String jsonRequest = om.writeValueAsString(userinfo);
		RequestBuilder request = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(jsonRequest);
		
		userInfo retuserinfo = utilities.generateUsersInfo();
		
		when(userservice.registerUser(any(Userdetails.class))).thenReturn(retuserinfo);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"userId\":0,\"firstname\":\"Sathish\",\"lastname\":\"Kumar\",\"contactNo\":\"9934823876\",\"emailId\":\"sathish@gmail.com\",\"address\":\"2/A,K.V street near Rani Mahal,Bengaluru\"}"))
				.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		logger.info("role-->{}",result.getResponse().getStatus());
		assertEquals(result.getResponse().getStatus(),200);
		
		verify(userservice).registerUser(any(Userdetails.class));
		
		userInfo resuserInfo = om.readValue(resultContent, userInfo.class);
		assertNotNull(resuserInfo);
		logger.info("role-->{}",resuserInfo.getEmailId());
		assertEquals("sathish@gmail.com", resuserInfo.getEmailId());
	}
}
