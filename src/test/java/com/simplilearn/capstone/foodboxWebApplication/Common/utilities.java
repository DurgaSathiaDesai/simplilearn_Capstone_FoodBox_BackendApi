package com.simplilearn.capstone.foodboxWebApplication.Common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.capstone.foodboxWebApplication.Dto.Userdetails;
import com.simplilearn.capstone.foodboxWebApplication.Dto.fooditem;
import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;
import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;
import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;
import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;
import com.simplilearn.capstone.foodboxWebApplication.Entity.userInfo;

public class utilities 
{
	public static List<foodOffers> generateFoodOffersList()
	{
		List<foodOffers> offerslist = new ArrayList<foodOffers>();
		
		foodOffers offer = new foodOffers();
		offer.setOfferId(1);
		offer.setOffername("10% OFF");
		offer.setAvailstatus("active");
		
		offerslist.add(offer);
		
		foodOffers foffer = new foodOffers();
		foffer.setOfferId(2);
		foffer.setOffername("20% OFF");
		foffer.setAvailstatus("active");
		
		offerslist.add(foffer);
		
		foodOffers fdoffer = new foodOffers();
		fdoffer.setOfferId(3);
		fdoffer.setOffername("25% OFF");
		fdoffer.setAvailstatus("active");
		
		offerslist.add(fdoffer);
		
		return offerslist;
	}
	
	public static userInfo generateUserInfo(loginCredentials logincred)
	{
		//loginCredentials logincred = generateLoginCreds();
		
		userInfo retuserinfo = new userInfo();
		retuserinfo.setFirstname("Sathish");
		retuserinfo.setLastname("Kumar");
		retuserinfo.setContactNo("9934823876");
		retuserinfo.setEmailId("sathish@gmail.com");
		retuserinfo.setAddress("2/A,K.V street near Rani Mahal,Bengaluru");
		retuserinfo.setUserCredentials(logincred);
		
		return retuserinfo;
	}
	
	public static userInfo generateUsersInfo()
	{
		loginCredentials logincred = generateLoginCreds();
		
		userInfo retuserinfo = new userInfo();
		retuserinfo.setFirstname("Sathish");
		retuserinfo.setLastname("Kumar");
		retuserinfo.setContactNo("9934823876");
		retuserinfo.setEmailId("sathish@gmail.com");
		retuserinfo.setAddress("2/A,K.V street near Rani Mahal,Bengaluru");
		retuserinfo.setUserCredentials(logincred);
		
		return retuserinfo;
	}
	
	public static loginCredentials generateLoginCreds()
	{
		loginCredentials logincred = new loginCredentials();
		
		logincred.setUsername("SathishKumar");
		logincred.setPword("sathish1234");
		logincred.setRole("user");
		logincred.setAccountstatus("active");
		
		return logincred;
	}
	
	public static Userdetails generateUserdetails()
	{
		Userdetails userinfo = new Userdetails();
		
		userinfo.setFirstname("Sathish");
		userinfo.setLastname("Kumar");
		userinfo.setContactNo("9934823876");
		userinfo.setEmailId("sathish@gmail.com");
		userinfo.setAddress("2/A,K.V street near Rani Mahal,Bengaluru");
		userinfo.setUsername("SathishKumar");
		userinfo.setPword("sathish1234");
		
		return userinfo;
	}
	
	public static List<cuisines> generateCuisinesList()
	{
		List<cuisines> clist = new ArrayList<cuisines>();
		cuisines newcuisine = new cuisines();
		newcuisine.setCuisineId(1);
		newcuisine.setCuisinename("Indian Cuisine");
		newcuisine.setAvailstatus("enabled");
		
		clist.add(newcuisine);
		
		cuisines tmpcuisine = new cuisines();
		tmpcuisine.setCuisineId(2);
		tmpcuisine.setCuisinename("Italian Cuisine");
		tmpcuisine.setAvailstatus("enabled");
		
		clist.add(tmpcuisine);
		
		cuisines tempcuisine = new cuisines();
		tempcuisine.setCuisineId(3);
		tempcuisine.setCuisinename("Chinese Cuisine");
		tempcuisine.setAvailstatus("enabled");
		
		clist.add(tempcuisine);
		
		return clist;
	}
	
	public static List<fooditem> generateFooditemList()
	{
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
		
		return foodlist;
	}
	
	public static List<fooditems> generateFooditemsList()
	{
		List<fooditems> foodlist = new ArrayList<fooditems>();
	
		foodOffers foffer = new foodOffers();
		foffer.setOfferId(2);
		foffer.setOffername("20% OFF");
		foffer.setAvailstatus("active");
		
		cuisines tmpcuisine = new cuisines();
		tmpcuisine.setCuisineId(2);
		tmpcuisine.setCuisinename("Italian Cuisine");
		tmpcuisine.setAvailstatus("enabled");
		
		fooditems newfitem = new fooditems();
		newfitem.setFoodname("Summer Risotto");
		newfitem.setFddescription("creamy summer risotto with grilled corn, tomatoes, and basil.");
		newfitem.setPrice(BigDecimal.valueOf(240.00));
		newfitem.setImage("risotto.jpg");
		newfitem.setFoodstatus("available");
		newfitem.setFdoffers(foffer);
		newfitem.setPcuisine(tmpcuisine);
		
		foodlist.add(newfitem);
		
		fooditems newfditem = new fooditems();
		
		cuisines tempcuisine = new cuisines();
		tempcuisine.setCuisineId(2);
		tempcuisine.setCuisinename("Italian Cuisine");
		tempcuisine.setAvailstatus("enabled");
		
		newfditem.setFoodname("Italian Pizza");
		newfditem.setFddescription("Thin and crispy rustic Italian pizza");
		newfditem.setPrice(BigDecimal.valueOf(350.00));
		newfditem.setImage("Italianpizza.jpg");
		newfditem.setFoodstatus("available");
		newfditem.setFdoffers(foffer);
		newfditem.setPcuisine(tempcuisine);
		
		foodlist.add(newfditem);
		return foodlist;
	}
}
