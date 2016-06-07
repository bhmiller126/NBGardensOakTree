package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 
 * @author OakTree SB, cardinality mapping by Laurence
 * Payment Transaction entity to capture customers payment for their orders
 * this may be partial or full payments for the orders as such has a many to one relation
 * ship with orders
 */
@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SalesOrder salesOrder;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod; 
		
	@Column(name = "date")
	private Date date;
	
	@Column(name = "amount")
	private BigDecimal amount;

	//////////////////////////////////
	
	/**
	 * 
	 */
	public PaymentTransaction() {}

	/**
	 * @param transactionID
	 * @param salesOrder
	 * @param paymentMethod
	 * @param date
	 * @param amount
	 */
	public PaymentTransaction(int transactionID, SalesOrder salesOrder, PaymentMethod paymentMethod, Date date,
			BigDecimal amount) {
		super();
		this.transactionID = transactionID;
		this.salesOrder = salesOrder;
		this.paymentMethod = paymentMethod;
		this.date = date;
		this.amount = amount;
	}

	/////////////////////////////////////////
	
	
	/**
	 * @return the transactionID
	 */
	public int getTransactionID() {
		return transactionID;
	}

	/**
	 * @return the salesOrder
	 */
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	/**
	 * @return the paymentMethod
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param transactionID the transactionID to set
	 */
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	/**
	 * @param salesOrder the salesOrder to set
	 */
	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}