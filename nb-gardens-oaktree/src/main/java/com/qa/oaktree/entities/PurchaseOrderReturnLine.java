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
	private PurchaseOrder purchaseOrder;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Stock_catalogue_id", nullable=false)
	@NotNull
	private Stock stockItem;
	
	@Column(name="return_Quantity")
	@NotNull
	private int returnQuantity; 
	
	
	/**
	 * Default construtor that only needs the product ID and Purchase Order ID
	 * @param purchaseOrder the purchase order ID
	 * @param stockItem the product ID being returned
	 */
	public PurchaseOrderReturnLine(PurchaseOrder purchaseOrder, Stock stockItem) {
		super();
		this.purchaseOrder = purchaseOrder;
		this.stockItem = stockItem;
	}

	/**
	 * Full constructor for purchase order return line
	 * @param purchaseOrder the Purchase Order ID
	 * @param stockItem the product ID
	 * @param returnQuantity the quantity returned
	 */
	public PurchaseOrderReturnLine (PurchaseOrder purchaseOrder, Stock stockItem, int returnQuantity ) {
		this.purchaseOrder = purchaseOrder; 
		this.stockItem = stockItem; 
		this.returnQuantity = returnQuantity;
	}

	/**
	 * Get the Purchase Order ID from the return line
	 * @return the Purchase Order ID
	 */
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}


	/**
	 * Get the products catalogue ID from the order return line
	 * @return theh product id
	 */
	public Stock getStockCatalogueId() {
		return stockItem;
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
		if (stockItem != other.stockItem)
			return false;
		if (purchaseOrder != other.purchaseOrder)
			return false;
		if (returnQuantity != other.returnQuantity)
			return false;
		return true;
	}
	
	

}
