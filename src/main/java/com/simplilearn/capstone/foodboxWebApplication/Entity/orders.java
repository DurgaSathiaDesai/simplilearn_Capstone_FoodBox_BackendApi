package com.simplilearn.capstone.foodboxWebApplication.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class orders 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "orderid")
	private long orderId;
	
	@Column(name = "ordertrackingno")
	private String ordertrackingno;
	
	@Column(name = "orderdate")
	private LocalDateTime orderDate;
	
	@Column(name = "custfirstname")
	private String firstname;
	
	@Column(name = "custlastname")
	private String lastname;
	
	@Column(name = "contactno")
	private String contactNo;
	
	@Column(name = "email")
	private String emailId;
	
	@Column(name = "deliveryaddr")
	private String address;
	
	@Column(name = "totalqty")
	private int totalQty;
	
	@Column(name = "totalamount")
	private double amount;
	
	@Column(name = "paymentmode")
	private String paymentMode;
	
	@Column(name = "orderstatus")
	private String orderStatus;
	
	 @OneToMany(mappedBy = "order") 
	 private List<orderedfoods> foodorders = new ArrayList<orderedfoods>();
	 
	 @OneToOne(mappedBy="orderpayment")
		//@JoinColumn(name="stockid")
		private payment orderpay;

	public orders()
	{
		
	}
	
	public orders(LocalDateTime orderDate, String firstname, String lastname, String contactNo, String emailId,
			String address, int totalQty, double amount, String paymentMode, String orderStatus) 
	{
		super();
		this.orderDate = orderDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.address = address;
		this.totalQty = totalQty;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getOrderId() {
		return orderId;
	}

	
	public String getOrderTrackingNo() {
		return ordertrackingno;
	}

	public void setOrderTrackingNo(String orderTrackingNo) {
		this.ordertrackingno = orderTrackingNo;
	}

	public payment getOrderpay() {
		return orderpay;
	}

	public void setOrderpay(payment orderpay) {
		this.orderpay = orderpay;
	}

	public List<orderedfoods> getFoodorders() {
		return foodorders;
	}

	public void setFoodorders(List<orderedfoods> foodorders) {
		this.foodorders = foodorders;
	}

	@Override
	public String toString() {
		return "orders [orderId=" + orderId + ", orderDate=" + orderDate + ", firstname=" + firstname + ", lastname="
				+ lastname + ", contactNo=" + contactNo + ", emailId=" + emailId + ", address=" + address
				+ ", totalQty=" + totalQty + ", amount=" + amount + ", paymentMode=" + paymentMode + ", orderStatus="
				+ orderStatus + "]";
	}
	
}
