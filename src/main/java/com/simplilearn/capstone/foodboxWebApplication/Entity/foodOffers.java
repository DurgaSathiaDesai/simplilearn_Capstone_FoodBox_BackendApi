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
@Table(name="foodoffers")
public class foodOffers 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "offerid")
	private long offerId;
	
	@Column(name = "offername")
	private String offername;
	
	@Column(name = "availstatus")
	private String availstatus;
	
	 @JsonIgnore
	 @OneToMany(mappedBy="fdoffers") 
	 private List<fooditems> fooditems;
	 
	 public foodOffers()
	 {
		 
	 }

	public foodOffers(String offername, String availstatus,
			List<com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems> fooditems) {
		super();
		this.offername = offername;
		this.availstatus = availstatus;
		this.fooditems = fooditems;
	}

	public String getOffername() {
		return offername;
	}

	public void setOffername(String offername) {
		this.offername = offername;
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

	public long getOfferId() {
		return offerId;
	}
	
	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	@Override
	public String toString() {
		return "foodOffers [offerId=" + offerId + ", offername=" + offername + ", availstatus=" + availstatus
				+ ", fooditems=" + fooditems + "]";
	}
	  
}
