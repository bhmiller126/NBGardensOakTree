package com.qa.oaktree.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 

/**
 * 
 * @author OakTree LP
 * Sales Order Return class. Used for the return information of a customers return order, partial or complete.
 */
@Entity
@Table (name = "sales_order_return")
public class SalesOrderReturn {
	@Id @GeneratedValue
	private int sales_id;
	
	private Date date; 
	
	private String reason;	
	
	private SalesOrder salesOrder;
	
	////////////////////////
	
	

	@JoinColumn (name = "Sales_Order_sales_id")
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}
	@NotNull
 



	/**
	 * Default null constructor for sales order return
	 */
	public SalesOrderReturn() {

	}

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

	/** 
	 * Override object.equals method for Sales Order Return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrderReturn other = (SalesOrderReturn) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (salesOrder != other.salesOrder)
			return false;
		return true;
	}

	/** 
	 * Override Object.toString
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalesOrderReturn [salesId=" + salesOrder + ", date=" + date + ", reason=" + reason + "]";
	}

}
