package com.qa.oaktree.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter; 

/**
 * 
 * @author OakTree LP
 * Sales Order Return class. Used for the return information of a customers return order, partial or complete.
 */
@Entity
@Table (name = "sales_order_return")
public class SalesOrderReturn {
	@Id @GeneratedValue(generator = "salesGenerator") //PK auto generator for sales orders
	@GenericGenerator(name = "salesGenerator", strategy = "foreign", 
			parameters = { @Parameter(value = "salesOrder", name = "property")})
	private int sales_id;
	
	private Date date; 
	
	private String reason;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sales_id")
	private SalesOrder salesOrder;
	
	////////////////////////////////////////////

	/**
	 * Default null constructor for sales order return
	 */
	public SalesOrderReturn() {}

	/**
	 * Full constructor for sales order return
	 * @param salesOrder the original sales order ID
	 * @param date for the new 
	 * @param reason
	 */
	public SalesOrderReturn (SalesOrder salesOrder, Date date, String reason) {
		this.salesOrder = salesOrder; 
		this.date = date; 
		this.reason = reason; 
	}

	////////////////////////////////////////////

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param salesOrder the salesId to set
	 */
	public void setSalesId(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
}
