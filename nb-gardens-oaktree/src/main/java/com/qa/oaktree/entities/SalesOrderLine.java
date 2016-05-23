package com.qa.oaktree.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Sales Order Line Entity
 * 
 * @author Angus
 *
 */
@Entity
@Table(name = "Sales_Order_Line")
public class SalesOrderLine {

	@Id
	@ManyToOne
	@JoinColumn(name = "Sales_Order_sales_id", nullable = false)
	@NotNull
	private int salesOrderID;

	@Id
	@ManyToOne
	@JoinColumn(name = "Stock_catalogue_id", nullable = false)
	@NotNull
	private int productID;

	@Column(name = "sales_quantity")
	@NotNull
	private int quantity;

	@Column(name = "unit_price")
	@NotNull
	private double unitCost;

	private double lineTotal;

	/**
	 * Default SalesOrderLine constructor that creates a empty orderline for a given product and order.
	 * OrderID must be updated when order is committed to the database and given an ID
	 * The primary key fields must be passed as they cannot be modified later
	 */
	public SalesOrderLine(int product) {
		super();
		this.salesOrderID = -1;
		this.productID = product;
		this.quantity = 0;
		this.unitCost = 0;
		this.lineTotal = 0;
	}

	/**
	 * Full constructor for SalesOrderLine
	 * 
	 * @param salesorder
	 *            The order ID for the orderline
	 * @param product
	 *            the product ID on the orderline
	 * @param quantity
	 *            the quantity of the product ordered
	 * @param unitCost
	 *            the saleprice per item
	 */
	public SalesOrderLine(int salesorder, int product, int quantity, double unitCost) {
		super();
		this.salesOrderID = salesorder;
		this.productID = product;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.lineTotal = quantity * unitCost;
	}

	/**
	 * returns the sales order which contains this sales order line
	 * 
	 * @return the sales order that contains this sales orderline
	 */
	public int getSalesOrder() {
		return this.salesOrderID;
	}
	

	/**
	 * updates the sales order ID of the order line if it has not already been set
	 * @param salesOrderID
	 * @return true if the requested change was successfull 
	 */
	public boolean setSalesOrder(int salesOrderID){
		if (salesOrderID==-1){
			this.salesOrderID = salesOrderID;
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * returns the product object on the orderlilne
	 * 
	 * @return
	 */
	public int getProduct() {
		return productID;
	}

	/**
	 * return Product quantity field
	 * @return the product quantity ordered
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * update the quantity field and lineTotal fields for the order line 
	 * @param quantity the new quantity for the product
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		setLineTotal();
	}

	/**
	 * return the price paid per product on this order
	 * @return the unit cost for the product
	 */
	public double getUnitCost() {
		return unitCost;
	}

	/**
	 * update the price per product value and update the order line total to match the new price and quantity
	 * @param unitCost the new unit cost for the product
	 */
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
		setLineTotal();
	}

	/**
	 * return the calculated line total for the order line
	 * @return the orderline total value
	 */
	public double getLineTotal() {
		return lineTotal;
	}

	/**
	 * private method that is only called when the quantity or unit price is changed within the order line
	 */
	private void setLineTotal() {
		this.lineTotal = quantity*unitCost;
	}

}
