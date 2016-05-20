package com.qa.oaktree.entities;

import java.sql.Date;

public class PaymentTransaction {
	private int transactionID;
	private PaymentMethod paymentMethod;
	private String cardCVC2;
	private Date date;
	private double amount;
	
	
	public PaymentTransaction(PaymentMethod paymentMethod, String cardCVC2, Date date, double amount) {
		super();
		this.paymentMethod = paymentMethod;
		this.cardCVC2 = cardCVC2;
		this.date = date;
		this.amount = amount;
	}


	public PaymentTransaction(int transactionID, PaymentMethod paymentMethod, Date date, double amount) {
		super();
		this.transactionID = transactionID;
		this.paymentMethod = paymentMethod;
		this.date = date;
		this.amount = amount;
	}


	public int getTransactionID() {
		return transactionID;
	}


	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}


	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getCardCVC2() {
		return cardCVC2;
	}


	public void setCardCVC2(String cardCVC2) {
		this.cardCVC2 = cardCVC2;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
