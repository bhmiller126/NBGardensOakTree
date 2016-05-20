package com.qa.oaktree.entities;

import java.sql.Date;

public class PaymentMethod {
	private String cardNumber;
	private String cardType;
	private Date startDate;
	private Date expiryDate;
	private String nameOnCard;
	private Address paymentAddress;
	
	
	public PaymentMethod(String cardNumber, String cardType, Date startDate, Date expiryDate, String nameOnCard,
			Address paymentAddress) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.nameOnCard = nameOnCard;
		this.paymentAddress = paymentAddress;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public String getCardType() {
		return cardType;
	}


	public Date getStartDate() {
		return startDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public String getNameOnCard() {
		return nameOnCard;
	}


	public Address getPaymentAddress() {
		return paymentAddress;
	}
	
	
}
