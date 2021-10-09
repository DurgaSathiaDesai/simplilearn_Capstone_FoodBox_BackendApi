package com.simplilearn.capstone.foodboxWebApplication.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="fooditems")
public class fooditems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "foodid")
	private long foodId;
	
	@Column(name = "foodname")
	private String foodname;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "fddescription")
	private String fddescription;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "foodstatus")
	private String foodstatus;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name="cuisineid")
	private cuisines pcuisine;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name="offerid")
	private foodOffers fdoffers;
	
	public fooditems()
	{
		
	}

	public fooditems(String foodname, BigDecimal price, String fddescription, String image, String foodstatus,
			cuisines pcuisine, foodOffers fdoffers) {
		super();
		this.foodname = foodname;
		this.price = price;
		this.fddescription = fddescription;
		this.image = image;
		this.foodstatus = foodstatus;
		this.pcuisine = pcuisine;
		this.fdoffers = fdoffers;
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

	public String getFddescription() {
		return fddescription;
	}

	public void setFddescription(String fddescription) {
		this.fddescription = fddescription;
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

	public cuisines getPcuisine() {
		return pcuisine;
	}

	public void setPcuisine(cuisines pcuisine) {
		this.pcuisine = pcuisine;
	}

	public foodOffers getFdoffers() {
		return fdoffers;
	}

	public void setFdoffers(foodOffers fdoffers) {
		this.fdoffers = fdoffers;
	}

	public long getFoodId() {
		return foodId;
	}

	@Override
	public String toString() {
		return "fooditems [foodId=" + foodId + ", foodname=" + foodname + ", price=" + price + ", fddescription="
				+ fddescription + ", image=" + image + ", foodstatus=" + foodstatus + ", pcuisine=" + pcuisine
				+ ", fdoffers=" + fdoffers + "]";
	}

}
