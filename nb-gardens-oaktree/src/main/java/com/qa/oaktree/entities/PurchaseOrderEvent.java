package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.sql.Timestamp;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ForeignKey;

@Entity
@Table (name = "Purchase_Order_Event")
public class PurchaseOrderEvent {
	@Id
	@Column (name = "purchase_event_id" )
	private int purchaseEventId; 
	
	@ManyToOne
	@JoinColumn (name = "Purchase_Order_purchase_id",
	             foreignKey = @ForeignKey(name = "Purchase_Order_purchase_id"))
	private PurchaseOrder purchaseOrder; 
	
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
	
	/**
	 * Default null constructor for Purchase Order Event
	 */
	public PurchaseOrderEvent()
	{
		this.purchaseEventId = -1;
		this.purchaseOrder = null;
		
		Date date = new Date();
		this.timeStamp = new java.sql.Timestamp(date.getTime());
		
		this.description = "";
		this.type = "";
	}
	
	/**
	 * 
	 * @param purchaseEventId; INT, auto-incrementing integer set on DB-commit
	 * @param order; PurchaseOrder, the order to which the event relates
	 * @param timeStamp; Timestamp, date of the event, including time
	 * @param description; String, optional description for comments
	 * @param type; String, type of event
	 */
	public PurchaseOrderEvent (int purchaseEventId, PurchaseOrder order, Timestamp timeStamp, String description, String type) {
		this.purchaseEventId = purchaseEventId; 
		this.purchaseOrder = order; 
		this.timeStamp = timeStamp; 
		this.description = description; 
		this.type = type; 
		
	}

	/**
	 * @return the purchaseEventId
	 */
	public int getPurchaseEventId() {
		return purchaseEventId;
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
	 * @param purchaseEventId the purchaseEventId to set
	 */
	public void setPurchaseEventId(int purchaseEventId) {
		this.purchaseEventId = purchaseEventId;
	}

	/**
	 * @param order the order to set
	 */
	public void setPurchaseOrder(PurchaseOrder order) {
		this.purchaseOrder = order;
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

	/**
	 * Override method equals() for PurchaseOrderEvent 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @return false if the event 'other' is different to this event
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrderEvent other = (PurchaseOrderEvent) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (purchaseOrder == null) {
			if (other.purchaseOrder != null)
				return false;
		} else if (!purchaseOrder.equals(other.purchaseOrder))
			return false;
		if (purchaseEventId != other.purchaseEventId)
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/**
	 * Override method toString() for PurchaseOrderEvent
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PurchaseOrderEvent [purchaseEventId=" + purchaseEventId 
				+ ", order=" + purchaseOrder + "(" + purchaseOrder.getPurchaseId() + ")" 
				+ ", timeStamp=" + timeStamp 
				+ ", description=" + description 
				+ ", type=" + type + "]";
	}
}
