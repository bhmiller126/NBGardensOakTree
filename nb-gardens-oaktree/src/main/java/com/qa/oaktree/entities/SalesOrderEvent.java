package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.ManyToOne; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;

@Entity
@Table (name = "Sales_Order_Event")
public class SalesOrderEvent {
	@Id @GeneratedValue
	@Column (name = "sales_event_id" )
	private int salesEventId; 
	
	@ManyToOne (cascade = CascadeType.ALL )
	private SalesOrder salesOrder; 
	
	@Column (name = "time_stamp", nullable = false)
	@NotNull
	private Timestamp timeStamp;
	
	@Column (name = "description", nullable = true, length = 225)
	@Size (min = 1, max =225)
	private String description; 
	
	@Column (name = "type", nullable = false, length = 20)
	@NotNull
	@Size (min = 1, max = 20)
	private String type;

	////////////////////////////////////////
	/**
	 *  Default null constructor, no values added
	 */
	public SalesOrderEvent() {}

	/**
	 * @param salesEventId
	 * @param salesOrder
	 * @param timeStamp
	 * @param description
	 * @param type
	 */
	public SalesOrderEvent(int salesEventId, SalesOrder salesOrder, Timestamp timeStamp, String description,
			String type) {
		super();
		this.salesEventId = salesEventId;
		this.salesOrder = salesOrder;
		this.timeStamp = timeStamp;
		this.description = description;
		this.type = type;
	} 
	////////////////////////////////////////

	/**
	 * @return the salesEventId
	 */
	public int getSalesEventId() {
		return salesEventId;
	}

	/**
	 * @return the salesOrder
	 */
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	/**
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param salesEventId the salesEventId to set
	 */
	public void setSalesEventId(int salesEventId) {
		this.salesEventId = salesEventId;
	}

	/**
	 * @param salesOrder the salesOrder to set
	 */
	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
