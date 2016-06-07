package com.qa.oaktree.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author OakTree LP
 * Sales order entity, used to capture the details of an order made by a customer.
 */
@Entity
@Table (name = "sales_order")
public class SalesOrder {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "sales_id")
	private int salesId; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "SalesOrder")
	private Set<SalesOrderEvent> salesEvent = new HashSet<SalesOrderEvent>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "SalesOrder")
	private Set<SalesOrderLine> salesLine = new HashSet<SalesOrderLine>();
	
	@Column (name = "Address_line_1")
	private String addressLine1; 
	
	@Column (name = "Address_postcode")
	private String addressPostcode; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "SalesOrder")
	private Set<PaymentTransaction> transaction = new HashSet<PaymentTransaction>();
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "SalesOrder")
	@JoinColumn(name = "sales_id")
	private SalesOrderReturn salesOrderReturn;

	///////////////////////////////
	
	/**
	 * Default null constructor for sales order
	 */
	public SalesOrder() {}

	/**
	 * @param salesId
	 * @param customer
	 * @param salesEvent
	 * @param salesLine
	 * @param addressLine1
	 * @param addressPostcode
	 * @param transaction
	 * @param salesOrderReturn
	 */
	public SalesOrder(int salesId, Customer customer, Set<SalesOrderEvent> salesEvent, Set<SalesOrderLine> salesLine,
			String addressLine1, String addressPostcode, Set<PaymentTransaction> transaction,
			SalesOrderReturn salesOrderReturn) {
		super();
		this.salesId = salesId;
		this.customer = customer;
		this.salesEvent = salesEvent;
		this.salesLine = salesLine;
		this.addressLine1 = addressLine1;
		this.addressPostcode = addressPostcode;
		this.transaction = transaction;
		this.salesOrderReturn = salesOrderReturn;
	}

	///////////////////////////////

	/**
	 * @return the salesEvent
	 */
	public Set<SalesOrderEvent> getSalesEvent() {
		return salesEvent;
	}


	/**
	 * @return the salesLine
	 */
	public Set<SalesOrderLine> getSalesLine() {
		return salesLine;
	}


	/**
	 * @return the transaction
	 */
	public Set<PaymentTransaction> getTransaction() {
		return transaction;
	}


	/**
	 * @return the salesOrderReturn
	 */
	public SalesOrderReturn getSalesOrderReturn() {
		return salesOrderReturn;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/**
	 * @param salesEvent the salesEvent to set
	 */
	public void setSalesEvent(Set<SalesOrderEvent> salesEvent) {
		this.salesEvent = salesEvent;
	}


	/**
	 * @param salesLine the salesLine to set
	 */
	public void setSalesLine(Set<SalesOrderLine> salesLine) {
		this.salesLine = salesLine;
	}


	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(Set<PaymentTransaction> transaction) {
		this.transaction = transaction;
	}


	/**
	 * @param salesOrderReturn the salesOrderReturn to set
	 */
	public void setSalesOrderReturn(SalesOrderReturn salesOrderReturn) {
		this.salesOrderReturn = salesOrderReturn;
	}
}
