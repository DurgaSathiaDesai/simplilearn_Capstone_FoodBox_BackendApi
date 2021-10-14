package com.simplilearn.capstone.foodboxWebApplication.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplilearn.capstone.foodboxWebApplication.Common.utilities;
import com.simplilearn.capstone.foodboxWebApplication.Dto.fooditem;
import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Service.cuisineService;


@WebMvcTest(cuisineController.class)
public class cuisineControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private cuisineService cuisineservice;
	 
	ObjectMapper om = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getAllCuisinesTest() throws Exception
	{
		String uri = "/api/cuisinelist";
		
		List<cuisines> clist = utilities.generateCuisinesList();
		
		when(cuisineservice.getAllCuisines()).thenReturn(clist);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"cuisineId\":1,\"cuisinename\":\"Indian Cuisine\",\"availstatus\":\"enabled\"},"
						+ "{\"cuisineId\":2,\"cuisinename\":\"Italian Cuisine\",\"availstatus\":\"enabled\"},"
						+ "{\"cuisineId\":3,\"cuisinename\":\"Chinese Cuisine\",\"availstatus\":\"enabled\"}]"))
				.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		logger.info("role-->{}",result.getResponse().getStatus());
		assertEquals(result.getResponse().getStatus(),200);
		
		verify(cuisineservice).getAllCuisines();

		
		@SuppressWarnings("unchecked")
		List<cuisines> cListResult =om.readValue(resultContent, new TypeReference<List<cuisines>>(){});

		assertNotNull(cListResult);
		assertEquals(clist.size(), cListResult.size());
	}
}
	
