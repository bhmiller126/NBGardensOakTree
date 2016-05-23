package com.qa.oaktree.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * 
 * @author Laurence Parker
 * Colaboration OakTree 
 */

public class Order_Deleted {

	private int orderID;
	private Customer customer;
	private Supplier supplier;
	private Date orderDate; //TODO double check how we are using dates
	private Address billingAddress;
	private Address deliveryAddress;
	private ArrayList<SalesOrderLine> orderLines = new ArrayList<SalesOrderLine>();
	private double orderTotal;
	private String orderStatus;
	private String returnReason;
	private ArrayList<PurchaseOrderEvent> orderEvent = new ArrayList<PurchaseOrderEvent>();
	private PaymentTransaction paymentTransaction;
	private Order_Deleted returnOf;
	/**
	 * Constructor for create Wishlist or Basket
	 * @param {@link {@link Customer}}customer who owns the order
	 */
	public Order_Deleted (Customer customer) {
		this.orderID = 0;
		this.customer = customer;
		this.supplier = null;
		this.orderDate = null;
		this.billingAddress = null;
		this.deliveryAddress = null;
		this.orderLines = new ArrayList<SalesOrderLine>();
		this.orderTotal = 0.0;
		this.orderStatus = "initialising";
		this.returnReason = null;
		this.orderEvent = new ArrayList<PurchaseOrderEvent>();
		this.paymentTransaction = null;
		this.returnOf = null;
	}

	/**
	 * Constructor for create Sales Order
	 * @param {@link Customer} customer who owns the order
	 * @param {@link Address} billingAddress for finance to bill to 
	 * @param {@link Address} deliveryAddress for warehouse to deliver to
	 * @param {{@link ArrayList} {@link SalesOrderLine}} orderLines to be added to order
	 */
	public Order_Deleted(Customer customer, Address billingAddress, Address deliveryAddress, ArrayList<SalesOrderLine> orderLines) {
		this.orderID = 0;
		this.customer = customer;
		this.supplier = null;
		this.orderDate = null;
		this.billingAddress = billingAddress;
		this.deliveryAddress = deliveryAddress;
		this.orderLines = orderLines;
		this.orderTotal = 0.0;
		this.orderStatus = "initialising";
		this.returnReason = null;
		this.orderEvent = new ArrayList<PurchaseOrderEvent>();
		this.paymentTransaction = null;
		this.returnOf = null;
	}
	
	/**
	 * Constructor for create Purchase Order
	 * @param {@link Supplier} supplier to purchase from
	 */
	public Order_Deleted(Supplier supplier){
		this.orderID = 0;
		this.customer = null;
		this.supplier = supplier;
		this.orderDate = null;
		this.billingAddress = null;
		this.deliveryAddress = null;
		this.orderLines = new ArrayList<SalesOrderLine>();
		this.orderTotal = 0.0;
		this.orderStatus = "initialising";
		this.returnReason = null;
		this.orderEvent = new ArrayList<PurchaseOrderEvent>();
		this.paymentTransaction = null;
		this.returnOf = null;
	}
	
	/**
	 * Constructor for create Return Order
	 * @param {@link Order_Deleted} originalOrder that return is associated to
	 * @param {{@link Date} orderDate of the return Order
	 * @param {@link String} returnReason that is given
	 */
	public Order_Deleted(Order_Deleted originalOrder, Date orderDate, String returnReason) {
		this.orderID = 0;
		this.customer = null;
		this.supplier = supplier;
		this.orderDate = orderDate;
		this.billingAddress = null;
		this.deliveryAddress = null;
		this.orderLines = new ArrayList<SalesOrderLine>();
		this.orderTotal = 0.0;
		this.orderStatus = "return";
		this.returnReason = returnReason;
		this.orderEvent = new ArrayList<PurchaseOrderEvent>();
		this.paymentTransaction = null;
		this.returnOf = originalOrder;
	}
	
	/**
	 * Constructor for read wish-list from database
	 * @param customer
	 * @param orderLines
	 */
	public Order_Deleted(Customer customer, ArrayList<SalesOrderLine> orderLines) {
		this.orderID = 0;
		this.customer = customer;
		this.supplier = null;
		this.orderDate = null;
		this.billingAddress = null;
		this.deliveryAddress = null;
		this.orderLines = orderLines;
		this.orderTotal = 0.0;
		this.orderStatus = "initialising";
		this.returnReason = null;
		this.orderEvent = new ArrayList<PurchaseOrderEvent>();
		this.paymentTransaction = null;
		this.returnOf = null;
	}
	
	public Order_Deleted() {
		//TODO 3 more constructors
		/*
		 * order id, customer orderdate, billing, delivery, oline, ostatus, oevent, payment, returnof,
		 * order id, supplier, odate, oline, ostatus, oevent
		 * return of, odate, oline, return reason
		 */
	}
	public Order_Deleted(int orderID, Customer customer, Supplier supplier, Date orderDate, Address billingAddress,
			Address deliveryAddress, ArrayList<SalesOrderLine> orderLines, double orderTotal, String orderStatus,
			String returnReason, ArrayList<PurchaseOrderEvent> orderEvent, PaymentTransaction paymentTransaction) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.supplier = supplier;
		this.orderDate = orderDate;
		this.billingAddress = billingAddress;
		this.deliveryAddress = deliveryAddress;
		this.orderLines = orderLines;
		this.orderTotal = orderTotal;
		this.orderStatus = orderStatus;
		this.returnReason = returnReason;
		this.orderEvent = orderEvent;
		this.paymentTransaction = paymentTransaction;
	}
	
}
