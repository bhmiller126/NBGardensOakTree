package com.qa.oaktree.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
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
	private SalesOrder salesOrder;

	@Id
	@ManyToOne
	@JoinColumn(name = "Stock_catalogue_id", nullable = false)
	@NotNull
	private Product product;

	@Column(name = "sales_quantity")
	@NotNull
	private int quantity;

	@Column(name = "unit_price")
	@NotNull
	private double unitCost;

	private double lineTotal;

	/**
	 * Defualt SalesOrderLine constructor that creates a empty orderline for a given product and order.
	 * The primary key fields must be passed as they cannot be modified later
	 */
	public SalesOrderLine(SalesOrder salesOrder, Product product) {
		super();
		this.salesOrder = salesOrder;
		this.product = product;
		this.quantity = 0;
		this.unitCost = 0;
		this.lineTotal = 0;
	}

	/**
	 * Full constructor for SalesOrderLine
	 * 
	 * @param salesorder
	 *            The order within which the orderline is situated
	 * @param product
	 *            the product on the orderline
	 * @param quantity
	 *            the quantity of the product ordered
	 * @param unitCost
	 *            the saleprice per item
	 */
	public SalesOrderLine(SalesOrder salesorder, Product product, int quantity, double unitCost) {
		super();
		this.salesOrder = salesorder;
		this.product = product;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.lineTotal = quantity * unitCost;
	}

	/**
	 * returns the sales order which contains this sales order line
	 * 
	 * @return the sales order that contains this sales orderline
	 */
	public SalesOrder getSalesOrder() {
		return this.salesOrder;
	}

	/**
	 * returns the product object on the orderlilne
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
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
