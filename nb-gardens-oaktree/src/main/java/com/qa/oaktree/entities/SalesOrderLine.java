package com.qa.oaktree.entities;

import java.math.BigDecimal;

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
	private BigDecimal unitCost;

	private BigDecimal lineTotal;

	/**
	 * Default SalesOrderLine constructor that creates a empty orderline for a given product and order.
	 * OrderID must be updated when order is committed to the database and given an ID
	 * The primary key fields must be passed as they cannot be modified later
	 */
	public SalesOrderLine(Product product) {
		this.product = product;
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
	public SalesOrderLine(SalesOrder salesorder, Product product, int quantity, BigDecimal unitCost) {
		super();
		this.salesOrder = salesorder;
		this.product = product;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.lineTotal = unitCost.multiply(BigDecimal.valueOf(quantity));  //quantity * unitCost;
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
	 * updates the sales order ID of the order line if it has not already been set
	 * @param salesOrderID
	 * @return true if the requested change was successful 
	 */
	public void setSalesOrder(SalesOrder salesOrderID){
		
			this.salesOrder = salesOrderID;
			
		
	}

	/**
	 * returns the product object on the orderline
	 * 
	 * @return
	 */
	public Product getProduct() {
		return this.product;
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
	public BigDecimal getUnitCost() {
		return unitCost;
	}

	/**
	 * update the price per product value and update the order line total to match the new price and quantity
	 * @param unitCost the new unit cost for the product
	 */
	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
		setLineTotal();
	}

	/**
	 * return the calculated line total for the order line
	 * @return the orderline total value
	 */
	public BigDecimal getLineTotal() {
		return lineTotal;
	}

	/**
	 * private method that is only called when the quantity or unit price is changed within the order line
	 */
	private void setLineTotal() {
		this.lineTotal = unitCost.multiply(BigDecimal.valueOf(quantity));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineTotal == null) ? 0 : lineTotal.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((salesOrder == null) ? 0 : salesOrder.hashCode());
		result = prime * result + ((unitCost == null) ? 0 : unitCost.hashCode());
		return result;
	}


	/** Overridden equals method that returns true only if all the fields of this entity are equal in value.
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
		SalesOrderLine other = (SalesOrderLine) obj;
		if (lineTotal == null) {
			if (other.lineTotal != null)
				return false;
		} else if (!lineTotal.equals(other.lineTotal))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		if (salesOrder == null) {
			if (other.salesOrder != null)
				return false;
		} else if (!salesOrder.equals(other.salesOrder))
			return false;
		if (unitCost == null) {
			if (other.unitCost != null)
				return false;
		} else if (!unitCost.equals(other.unitCost))
			return false;
		return true;
	}

	

	
	


	
	
	

}
