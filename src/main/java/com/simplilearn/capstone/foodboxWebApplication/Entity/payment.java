package com.simplilearn.capstone.foodboxWebApplication.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class payment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "paymentid")
	private long paymentId;
	
	@Column(name = "nameoncard")
	private String nameOnCard;
	
	@Column(name = "cardnumber")
	private long cardNumber;
	
	@Column(name = "expmonth")
	private int expMonth;
	
	@Column(name = "expyear")
	private int expYear;
	
	@Column(name = "cvv")
	private int cvv;

	@OneToOne(optional = false)
	@JoinColumn(name="orderid")
	private orders orderpayment;
	
	public payment()
	{
		
	}
	public payment(String nameOnCard, long cardNumber, int expMonth, int expYear, int cvv) {
		super();
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public orders getOrderpayment() {
		return orderpayment;
	}
	public void setOrderpayment(orders orderpayment) {
		this.orderpayment = orderpayment;
	}
	public long getPaymentId() {
		return paymentId;
	}
	@Override
	public String toString() {
		return "payment [paymentId=" + paymentId + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + ", cvv=" + cvv + ", orderpayment=" + orderpayment
				+ "]";
	}
	
	
	
}
