package com.simplilearn.capstone.foodboxWebApplication.Dto;

import java.math.BigDecimal;

public class checkoutfoods 
{
	private long foodid;
	private String foodname;
	private BigDecimal price;
	private String offers;
	private int quantity;
	
	public checkoutfoods()
	{
		
	}
	
	public checkoutfoods(long foodid, String foodname, BigDecimal price, String offers, int quantity) {
		super();
		this.foodid = foodid;
		this.foodname = foodname;
		this.price = price;
		this.offers = offers;
		this.quantity = quantity;
	}

	public long getFoodid() {
		return foodid;
	}

	public void setFoodid(long foodid) {
		this.foodid = foodid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "checkoutfoods [foodid=" + foodid + ", foodname=" + foodname + ", price=" + price + ", offers=" + offers
				+ ", quantity=" + quantity + "]";
	}

}
