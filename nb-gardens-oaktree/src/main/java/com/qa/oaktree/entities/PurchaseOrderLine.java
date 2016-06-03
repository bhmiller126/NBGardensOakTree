package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 

/**
 * Purchase Order Line entity
 * @author Angus
 *
 */
@Entity
@Table(name = "Purchase_Order_Line")
public class PurchaseOrderLine {

	@Id
	@ManyToOne
	@JoinColumn(name = "Purchase_Order_purchase_id", nullable = false)
	@NotNull
	private int purchaseOrderId;

	@Id
	@ManyToOne
	@JoinColumn(name = "Stock_catalogue_id", nullable = false)
	@NotNull
	private int productID;

	@Column(name = "purchase_quantity")
	@NotNull
	private int purchaseQuantity;

	@Column(name = "purchase_unit_price")
	@NotNull
	private BigDecimal purchaseUnitPrice;
	
	private BigDecimal lineTotal;

	
	/**
	 * Default Constructor that only requires the fields needed to form the composite key, purchase order id and product id
	 * @param purchaseOrderId the purchase order id
	 * @param productID the product id for the order line
	 */
	public PurchaseOrderLine(int purchaseOrderId, int productID) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.productID = productID;
		this.purchaseQuantity=0;
		this.purchaseUnitPrice = BigDecimal.valueOf(0);
		this.lineTotal = new BigDecimal(0);
	}

	/**
	 * Full constructor that takes every field
	 * @param purchaseOrderId the purchase order id
	 * @param stockCatalogueId the product id
	 * @param purchaseQuantity the quantity ordered
	 * @param purchaseUnitPrice the price per unit
	 */
	public PurchaseOrderLine(int purchaseOrderId, int stockCatalogueId, int purchaseQuantity,
			BigDecimal purchaseUnitPrice) {
		this.purchaseOrderId = purchaseOrderId;
		this.productID = stockCatalogueId;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseUnitPrice = purchaseUnitPrice;
		this.lineTotal = purchaseUnitPrice.multiply(BigDecimal.valueOf(purchaseQuantity));

	}

	/**
	 * @return the purchaseOrderId
	 */
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @return the purchaseQuantity
	 */
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	/**
	 * @return the purchaseUnitPrice
	 */
	public BigDecimal getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}

	/**
	 * @param purchaseOrderId the purchaseOrderId to set
	 */
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @param purchaseQuantity the purchaseQuantity to set
	 */
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	/**
	 * @param purchaseUnitPrice the purchaseUnitPrice to set
	 */
	public void setPurchaseUnitPrice(BigDecimal purchaseUnitPrice) {
		this.purchaseUnitPrice = purchaseUnitPrice;
		setLineTotal();
	}

	/**
	 * @return the lineTotal
	 */
	public BigDecimal getLineTotal() {
		return lineTotal;
	}
	
	private void setLineTotal(){
		this.lineTotal = purchaseUnitPrice.multiply(BigDecimal.valueOf(purchaseQuantity)); 
	}


}
