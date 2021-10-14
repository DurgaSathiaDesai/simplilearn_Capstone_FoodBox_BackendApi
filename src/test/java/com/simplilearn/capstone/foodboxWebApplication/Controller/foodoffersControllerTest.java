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
import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;
import com.simplilearn.capstone.foodboxWebApplication.Service.foodoffersService;

@WebMvcTest(foodoffersController.class)
public class foodoffersControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private foodoffersService foodofferservice;
	 
	ObjectMapper om = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getAllOffersTest() throws Exception
	{
		String uri = "/api/offerslist";
		
		List<foodOffers> offerslist = utilities.generateFoodOffersList();
		
		when(foodofferservice.getAllOffers()).thenReturn(offerslist);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"offerId\":1,\"offername\":\"10% OFF\",\"availstatus\":\"active\"},"
						+ "{\"offerId\":2,\"offername\":\"20% OFF\",\"availstatus\":\"active\"},"
						+ "{\"offerId\":3,\"offername\":\"25% OFF\",\"availstatus\":\"active\"}]"))
				.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		logger.info("role-->{}",result.getResponse().getStatus());
		assertEquals(result.getResponse().getStatus(),200);
		
		verify(foodofferservice).getAllOffers();

		@SuppressWarnings("unchecked")
		List<foodOffers> offerListResult =om.readValue(resultContent, new TypeReference<List<foodOffers>>(){});

		assertNotNull(offerListResult);
		assertEquals(offerslist.size(), offerListResult.size());
	}
}
