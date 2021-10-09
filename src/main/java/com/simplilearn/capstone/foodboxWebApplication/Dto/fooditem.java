package com.simplilearn.capstone.foodboxWebApplication.Dto;

import java.math.BigDecimal;

public class fooditem 
{
	private long foodId;
	private String foodname;
	private String cuisinename;
	private BigDecimal price;
	private String fddescription;
	private String offers;
	private String image;
	private String foodstatus;
	
	public fooditem()
	{
		
	}
	
	public fooditem(long foodId, String foodname, String cuisinename, BigDecimal price, String fddescription,
			String offers, String image, String foodstatus) {
		super();
		this.foodId = foodId;
		this.foodname = foodname;
		this.cuisinename = cuisinename;
		this.price = price;
		this.fddescription = fddescription;
		this.offers = offers;
		this.image = image;
		this.foodstatus = foodstatus;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getCuisinename() {
		return cuisinename;
	}

	public void setCuisinename(String cuisinename) {
		this.cuisinename = cuisinename;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getFddescription() {
		return fddescription;
	}

	public void setFddescription(String fddescription) {
		this.fddescription = fddescription;
	}

	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFoodstatus() {
		return foodstatus;
	}

	public void setFoodstatus(String foodstatus) {
		this.foodstatus = foodstatus;
	}

	@Override
	public String toString() {
		return "fooditem [foodId=" + foodId + ", foodname=" + foodname + ", cuisinename=" + cuisinename + ", price="
				+ price + ", fddescription=" + fddescription + ", offers=" + offers + ", image=" + image
				+ ", foodstatus=" + foodstatus + "]";
	}
	
}
