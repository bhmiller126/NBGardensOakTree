package com.qa.oaktree.entities;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

	@ManyToOne (cascade = CascadeType.ALL)
	private Stock stock;

	@Column(name = "sales_quantity")
	@NotNull
	private int quantity;

	@Column(name = "unit_price")
	@NotNull
	private BigDecimal unitCost;

	/////////////////////////////

	/**
	 * null constructor 
	 */
	public SalesOrderLine() {}

	/**
	 * @param salesId
	 * @param catalogueId
	 * @param salesOrder
	 * @param stock
	 * @param quantity
	 * @param unitCost
	 */
	public SalesOrderLine(int salesId, int catalogueId, SalesOrder salesOrder, Stock stock, int quantity,
			BigDecimal unitCost) {
		super();
		this.salesId = salesId;
		this.catalogueId = catalogueId;
		this.salesOrder = salesOrder;
		this.stock = stock;
		this.quantity = quantity;
		this.unitCost = unitCost;
	}

	/////////////////////////////

	/**
	 * @return the salesId
	 */
	public int getSalesId() {
		return salesId;
	}

	/**
	 * @return the catalogueId
	 */
	public int getCatalogueId() {
		return catalogueId;
	}

	/**
	 * @return the salesOrder
	 */
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the unitCost
	 */
	public BigDecimal getUnitCost() {
		return unitCost;
	}

	/**
	 * @param salesId the salesId to set
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	/**
	 * @param catalogueId the catalogueId to set
	 */
	public void setCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}

	/**
	 * @param salesOrder the salesOrder to set
	 */
	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}
}