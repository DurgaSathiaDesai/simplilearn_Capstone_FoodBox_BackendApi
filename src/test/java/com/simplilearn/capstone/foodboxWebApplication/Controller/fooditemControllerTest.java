package com.simplilearn.capstone.foodboxWebApplication.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.simplilearn.capstone.foodboxWebApplication.Dto.fooditem;
import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Service.fooditemService;

@WebMvcTest(fooditemController.class)
public class fooditemControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private fooditemService fooditemservice;
	 
	ObjectMapper om = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getAllFoodsTest() throws Exception
	{
		String uri = "/api/foodlist";
		
		List<fooditem> foodlist = new ArrayList<fooditem>();
		fooditem newfitem = new fooditem();
		newfitem.setFoodId(1003);
		newfitem.setFoodname("Summer Risotto");
		newfitem.setCuisinename("Italian Cuisine");
		newfitem.setFddescription("creamy summer risotto with grilled corn, tomatoes, and basil.");
		newfitem.setPrice(BigDecimal.valueOf(240.00));
		newfitem.setImage("risotto.jpg");
		newfitem.setOffers("20% OFF");
		newfitem.setFoodstatus("available");
		
		foodlist.add(newfitem);
		
		fooditem newfditem = new fooditem();
		newfditem.setFoodId(1005);
		newfditem.setFoodname("Italian Pizza");
		newfditem.setCuisinename("Italian Cuisine");
		newfditem.setFddescription("Thin and crispy rustic Italian pizza");
		newfditem.setPrice(BigDecimal.valueOf(350.00));
		newfditem.setImage("Italianpizza.jpg");
		newfditem.setOffers("20% OFF");
		newfditem.setFoodstatus("available");
		
		foodlist.add(newfditem);
		
		when(fooditemservice.getAllFoodItems()).thenReturn(foodlist);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"foodId\":1003,\"foodname\":\"Summer Risotto\",\"cuisinename\":\"Italian Cuisine\",\"price\":240.00,"
						+ "\"fddescription\":\"creamy summer risotto with grilled corn, tomatoes, and basil.\","
						+ "\"offers\":\"20% OFF\",\"image\":\"risotto.jpg\",\"foodstatus\":\"available\"},"
						+ "{\"foodId\":1005,\"foodname\":\"Italian Pizza\",\"cuisinename\":\"Italian Cuisine\",\"price\":350.00,"
						+ "\"fddescription\":\"Thin and crispy rustic Italian pizza\","
						+ "\"offers\":\"20% OFF\",\"image\":\"Italianpizza.jpg\",\"foodstatus\":\"available\"}]"))
				.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		logger.info("role-->{}",result.getResponse().getStatus());
		assertEquals(result.getResponse().getStatus(),200);
		
		verify(fooditemservice).getAllFoodItems();

		
		@SuppressWarnings("unchecked")
		List<fooditem> foodListResult =om.readValue(resultContent, new TypeReference<List<fooditem>>(){});

		assertNotNull(foodListResult);
		assertEquals(foodlist.size(), foodListResult.size());
	}
}
