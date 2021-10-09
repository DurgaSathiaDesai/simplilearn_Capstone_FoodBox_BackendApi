package com.simplilearn.capstone.foodboxWebApplication.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="cuisines")
public class cuisines 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cuisineid")
	private long cuisineId;
	
	@Column(name = "cuisinename")
	private String cuisinename;
	
	@Column(name = "availstatus")
	private String availstatus;
	
	 @JsonIgnore
	 @OneToMany(mappedBy="pcuisine") 
	 private List<fooditems> fooditems;
	 
	public cuisines()
	{
		
	}

	public cuisines(long cuisineId, String cuisinename, String availstatus) {
		super();
		this.cuisineId = cuisineId;
		this.cuisinename = cuisinename;
		this.availstatus = availstatus;
	}

	public long getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCuisinename() {
		return cuisinename;
	}

	public void setCuisinename(String cuisinename) {
		this.cuisinename = cuisinename;
	}

	public String getAvailstatus() {
		return availstatus;
	}

	public void setAvailstatus(String availstatus) {
		this.availstatus = availstatus;
	}
	
	

	public List<fooditems> getFooditems() {
		return fooditems;
	}

	public void setFooditems(List<fooditems> fooditems) {
		this.fooditems = fooditems;
	}

	@Override
	public String toString() {
		return "cuisines [cuisineId=" + cuisineId + ", cuisinename=" + cuisinename + ", availstatus=" + availstatus
				+ "]";
	}
	
}
