package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn;  

/**
 * Purchase Order Return Line Entity that maps to Purchase_Order_Return_Line table in MySQL
 * @author Angus
 *
 */
@Entity
@Table(name="Purchase_Order_Return_Line")
public class PurchaseOrderReturnLine {
	@Id
	@ManyToOne
	@JoinColumn(name="Purchase_Order_Return_Purchase_Order_purchase_id", nullable=false)
	@NotNull
	private int purchaseOrderId;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Stock_catalogue_id", nullable=false)
	@NotNull
	private int productID;
	
	@Column(name="return_Quantity")
	@NotNull
	private int returnQuantity; 
	
	
	/**
	 * Default construtor that only needs the product ID and Purchase Order ID
	 * @param purchaseOrderId the purchase order ID
	 * @param productID the product ID being returned
	 */
	public PurchaseOrderReturnLine(int purchaseOrderId, int productID) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.productID = productID;
	}

	/**
	 * Full constructor for purchase order return line
	 * @param purchaseId the Purchase Order ID
	 * @param stockCatalogueId the product ID
	 * @param returnQuantity the quantity returned
	 */
	public PurchaseOrderReturnLine (int purchaseId, int stockCatalogueId, int returnQuantity ) {
		this.purchaseOrderId = purchaseId; 
		this.productID = stockCatalogueId; 
		this.returnQuantity = returnQuantity;
	}

	/**
	 * Get the Purchase Order ID from the return line
	 * @return the Purchase Order ID
	 */
	public int getPurchaseOrderReturnPurchaseOrderPurchaseId() {
		return purchaseOrderId;
	}


	/**
	 * Get the products catalogue ID from the order return line
	 * @return theh product id
	 */
	public int getStockCatalogueId() {
		return productID;
	}

	/**
	 * get the quantity returned
	 * @return the product quantity returned
	 */
	public int getReturnQuantity() {
		return returnQuantity;
	}

	/**
	 * set the quantity returned for the purchase order return line
	 * @param returnQuantity the quantity of the product returned
	 */
	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productID;
		result = prime * result + purchaseOrderId;
		result = prime * result + returnQuantity;
		return result;
	}

	/** Overrides the object equals method to compare field values.
	 * @return True if all field values are equal
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
		PurchaseOrderReturnLine other = (PurchaseOrderReturnLine) obj;
		if (productID != other.productID)
			return false;
		if (purchaseOrderId != other.purchaseOrderId)
			return false;
		if (returnQuantity != other.returnQuantity)
			return false;
		return true;
	}
	
	

}
