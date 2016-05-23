package com.qa.oaktree.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author OakTree LP
 * Purchase Order
 */
@Entity
@Table (name = "Purchase_Order")
public class PurchaseOrder {

	@Column (name = "purchase_id")
	private int purchaseId; 
	
	@Column (name = "Supplier_supplier_id")
	private int supplierId; 

	
	/**
	 * Default null constructor for Purchase Order
	 */
	public PurchaseOrder() {
		super();
		this.purchaseId = 0;
		this.supplierId = 0;
	}

	/**
	 * Full constructor for Purchase Order
	 * @param purchaseId Int id of the purchase order
	 * @param supplierId int id from whom the products are being ordered from 
	 */
	public PurchaseOrder(int purchaseId, int supplierId) {
		super();
		this.purchaseId = purchaseId;
		this.supplierId = supplierId;
	}

	/**
	 * @return the purchaseId
	 */
	public int getPurchaseId() {
		return purchaseId;
	}

	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}

	/**
	 * @param purchaseId the purchaseId to set
	 */
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	/** 
	 * Override Object.equals method for purchase order
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (purchaseId != other.purchaseId)
			return false;
		if (supplierId != other.supplierId)
			return false;
		return true;
	}

	/** 
	 * Overrid Object.toString method for Purchase order
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PurchaseOrder [purchaseId=" + purchaseId + ", supplierId=" + supplierId + "]";
	}
}
