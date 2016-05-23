package com.qa.oaktree.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * Sales Order Return Line entity
 * @author Angus
 *
 */
@Entity
@Table(name="Sales_Order_Return_Line")
public class SalesOrderReturnLine 
{
	@Id
	@ManyToOne
	@JoinColumn(name="Stock_catalogue_id", nullable = false)
	@NotNull
	private int productID;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Sales_Order_sales_id", nullable = false)
	private int salesOrderID;
	
	@Column(name="return_quantity")
	private int returnQuantity;
	
	@Column(name="shelved_quantity")
	private int shelvedQuantity;
	
	
	
	/**
	 * Defualt Constructor that requires the composite key fields (product ID and sales order ID)
	 * @param productID the product ID for the returned product
	 * @param salesOrderID the sales order ID that the return is from
	 */
	public SalesOrderReturnLine(int productID, int salesOrderID) {
		super();
		this.productID = productID;
		this.salesOrderID = salesOrderID;
		this.returnQuantity = 0;
		this.shelvedQuantity = 0;
	}

	/**
	 * The full constructor for a sales order return line that requires all fields
	 * @param productID the product ID of the returned product
	 * @param salesOrderID the order ID for the returns
	 * @param returnQuantity the quantity of product returned
	 * @param shelvedQuantity the quantity of returned items placed back on shelf
	 */
	public SalesOrderReturnLine(int productID, int salesOrderID, int returnQuantity, int shelvedQuantity) {
		super();
		this.productID = productID;
		this.salesOrderID = salesOrderID;
		this.returnQuantity = returnQuantity;
		this.shelvedQuantity = shelvedQuantity;
	}

	/**
	 * returns the product ID of the returned item
	 * @return the product ID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * return the orderID of the return line
	 * @return the sales order id
	 */
	public int getSalesOrderID() {
		return salesOrderID;
	}

	/**
	 * get the quantity of the product returned
	 * @return the quantity returned 
	 */
	public int getReturnQuantity() {
		return returnQuantity;
	}


	/**
	 * update the return quantity field for the return line
	 * @param returnQuantity
	 */
	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}


	/**
	 * get the amount of products that were able to be sold again
	 * @return the quantity put back on the shelf
	 */
	public int getShelvedQuantity() {
		return shelvedQuantity;
	}

	/**
	 * set the quantity that is not damaged and can be put back on the shelf
	 * @param shelvedQuantity the quantity to be but back on the shelf
	 */
	public void setShelvedQuantity(int shelvedQuantity) {
		this.shelvedQuantity = shelvedQuantity;
	}
	
	
	
	
	
}
