package com.simplilearn.capstone.foodboxWebApplication.Dto;

public class PurchaseResponse 
{
	 private String orderTrackingNumber;

	 public PurchaseResponse()
	 {
		 
	 }
	public PurchaseResponse(String orderTrackingNumber) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
	}
	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}
	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}
	@Override
	public String toString() {
		return "PurchaseResponse [orderTrackingNumber=" + orderTrackingNumber + "]";
	}
	 
}
