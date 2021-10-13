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

@Entity
@Table(name="orderedfooditems")
public class orderedfoods 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "foodname")
	private String foodname;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "offers")
	private String offers;
	
	@Column(name = "qty")
	private int quantity;
	
	@ManyToOne
    @JoinColumn(name = "orderid")
    private orders order;

	@ManyToOne
    @JoinColumn(name = "foodid")
    private fooditems fditem;

	public orderedfoods()
	{
		
	}

	public orderedfoods(String foodname, BigDecimal price, String offers, int quantity, orders order, fooditems fditem) {
		super();
		this.foodname = foodname;
		this.price = price;
		this.offers = offers;
		this.quantity = quantity;
		this.order = order;
		this.fditem = fditem;
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

	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public orders getOrder() {
		return order;
	}

	public void setOrder(orders order) {
		this.order = order;
	}

	public fooditems getFditem() {
		return fditem;
	}

	public void setFditem(fooditems fditem) {
		this.fditem = fditem;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "orderedfoods [id=" + id + ", foodname=" + foodname + ", price=" + price + ", offers=" + offers
				+ ", quantity=" + quantity + ", order=" + order + ", fditem=" + fditem + "]";
	}
	
}
