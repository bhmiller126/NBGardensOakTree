package com.qa.oaktree.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Sales Order Line Entity
 * @author OakTree Angus, cardinality mapped by Laurence.
 * Entity to map stock items to the customers order and adding quantity and unit cost.
 *
 */
@Entity
@Table(name = "Sales_Order_Line")
public class SalesOrderLine {

	@Id @GeneratedValue (generator = "salesGenerator") //PK auto generator for sales orders
	@GenericGenerator(name = "salesGenerator", strategy = "foreign", 
			parameters = { @Parameter(value = "salesOrder", name = "property")})
	@Column (name = "sales_Id")
	private int salesId;

	@Id @GeneratedValue (generator = "stockGenerator") //PK auto generator for sales orders
	@GenericGenerator(name = "stockGenerator", strategy = "foreign", 
			parameters = { @Parameter(value = "stock", name = "property")})
	@Column (name = "catalogue_Id")
	private int catalogueId;

	@ManyToOne (cascade = CascadeType.ALL)
	private SalesOrder salesOrder;

	@Id
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "SalesOrderLine")
	private Set<Stock> stock = new HashSet<Stock>();

	@Column(name = "sales_quantity")
	@NotNull
	private int quantity;

	@Column(name = "unit_price")
	@NotNull
	private BigDecimal unitCost;

	private BigDecimal lineTotal;

	/**
	 * Default SalesOrderLine constructor that creates a empty orderline for a given stock and order.
	 * OrderID must be updated when order is committed to the database and given an ID
	 * The primary key fields must be passed as they cannot be modified later
	 */
	public SalesOrderLine(Set<Stock> stock) {
		this.stock = stock;
	}

	/**
	 * Full constructor for SalesOrderLine
	 * 
	 * @param salesorder
	 *            The order ID for the orderline
	 * @param stock
	 *            the stock ID on the orderline
	 * @param quantity
	 *            the quantity of the stock ordered
	 * @param unitCost
	 *            the saleprice per item
	 */
	public SalesOrderLine(SalesOrder salesorder, Set<Stock> stock, int quantity, BigDecimal unitCost) {
		super();
		this.salesOrder = salesorder;
		this.stock = stock;
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
	 * returns the stock object on the orderline
	 * 
	 * @return
	 */
	public Set<Stock> getstock() {
		return this.stock;
	}

	/**
	 * return stock quantity field
	 * @return the stock quantity ordered
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * update the quantity field and lineTotal fields for the order line 
	 * @param quantity the new quantity for the stock
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		setLineTotal();
	}

	/**
	 * return the price paid per stock on this order
	 * @return the unit cost for the stock
	 */
	public BigDecimal getUnitCost() {
		return unitCost;
	}

	/**
	 * update the price per stock value and update the order line total to match the new price and quantity
	 * @param unitCost the new unit cost for the stock
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
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
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
