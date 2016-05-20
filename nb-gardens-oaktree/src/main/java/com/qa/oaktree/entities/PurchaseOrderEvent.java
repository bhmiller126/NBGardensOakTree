package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn;  

import javax.print.attribute.DateTimeSyntax;

public class PurchaseOrderEvent {

	private int purchaseEventId; 
	private int purchaseOrderPurchaseId; 
	private DateTimeSyntax timeStamp; 
	private String description; 
	private String type; 
	
	public PurchaseOrderEvent (int purchaseEventId, int purchaseOrderPurchaseId, DateTimeSyntax timeStamp, String description, String type){
		this.purchaseEventId = purchaseEventId; 
		this.purchaseOrderPurchaseId = purchaseOrderPurchaseId; 
		this.timeStamp = timeStamp; 
		this.description = description; 
		this.type = type; 
		
		
	}

	public int getPurchaseEventId() {
		return purchaseEventId;
	}

	public void setPurchaseEventId(int purchaseEventId) {
		this.purchaseEventId = purchaseEventId;
	}

	public int getPurchaseOrderPurchaseId() {
		return purchaseOrderPurchaseId;
	}

	public void setPurchaseOrderPurchaseId(int purchaseOrderPurchaseId) {
		this.purchaseOrderPurchaseId = purchaseOrderPurchaseId;
	}

	public DateTimeSyntax getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(DateTimeSyntax timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
