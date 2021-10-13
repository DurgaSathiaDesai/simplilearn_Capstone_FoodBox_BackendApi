package com.simplilearn.capstone.foodboxWebApplication.Controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
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

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplilearn.capstone.foodboxWebApplication.Dto.Response;
import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Service.loginService;

@WebMvcTest(loginController.class)
public class loginControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private loginService loginservice;
	 
	ObjectMapper om = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	@Test
	public void loginValidateTest() throws Exception
	{
		String uri = "/api/loginvalidate";
		
		om.disable(MapperFeature.USE_ANNOTATIONS);
		loginCredentials creds = new loginCredentials();
		creds.setUsername("PaulWalker");
		creds.setPword("Paul1234");
		String jsonRequest = om.writeValueAsString(creds);
		
		loginCredentials retCreds = new loginCredentials();
		retCreds.setUsername("PaulWalker");
		retCreds.setPword("Paul1234");
		retCreds.setRole("user");
		retCreds.setAccountstatus("active");
		RequestBuilder request = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(jsonRequest);
		when(loginservice.loginValidate(any(loginCredentials.class))).thenReturn(retCreds);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"loginid\":0,\"username\":\"PaulWalker\",\"pword\":\"Paul1234\",\"role\":\"user\",\"accountstatus\":\"active\"}"))
				.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		logger.info("role-->{}",result.getResponse().getStatus());
		assertEquals(result.getResponse().getStatus(),200);
		
		verify(loginservice).loginValidate(any(loginCredentials.class));
		
		loginCredentials resCreds = om.readValue(resultContent, loginCredentials.class);
		assertNotNull(resCreds);
		assertEquals(0, resCreds.getLoginid());
	}
}
