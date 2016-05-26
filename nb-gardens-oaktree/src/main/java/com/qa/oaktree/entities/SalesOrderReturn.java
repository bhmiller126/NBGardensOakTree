package com.qa.oaktree.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 

/**
 * 
 * @author OakTree LP
 * Sales Order Return class
 */
@Entity
@Table (name = "Sales_Order_Return")
public class SalesOrderReturn {
	@Id
	@OneToOne
	@JoinColumn (name = "Sales_Order_sales_id")
	public int getSalesOrderId() {
		return salesId;
	}
	@NotNull
	private int salesId; 

	@Column (name = "date")
	private Date date; 
	
	@Column (name = "reason")
	private String reason;

	/**
	 * Default null constructor for sales order return
	 */
	public SalesOrderReturn() {
		this.salesId = -1;
		this.date = new Date();
		this.reason = "";
	}

	/**
	 * Full constructor for sales order return
	 * @param salesId the original sales order ID
	 * @param date for the new 
	 * @param reason
	 */
	public SalesOrderReturn (int salesId, Date date, String reason) {
		this.salesId = salesId; 
		this.date = date; 
		this.reason = reason; 
	}

	/**
	 * @return the salesId
	 */
	public int getSalesId() {
		return salesId;
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
	 * @param salesId the salesId to set
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
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
		if (salesId != other.salesId)
			return false;
		return true;
	}

	/** 
	 * Override Object.toString
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalesOrderReturn [salesId=" + salesId + ", date=" + date + ", reason=" + reason + "]";
	}

}
