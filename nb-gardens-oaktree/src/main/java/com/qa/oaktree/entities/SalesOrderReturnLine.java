package com.qa.oaktree.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/**
 * Sales Order Return Line entity, used to capture the order lines for full or partial order returns
 * @author OakTree, Angus, cardinality mapped by Laurence 
 *
 */
@Entity
@Table(name="Sales_Order_Return_Line")
public class SalesOrderReturnLine {
	
	@Id @GeneratedValue(generator = "salesGenerator") //PK auto generator for sales orders
	@GenericGenerator(name = "salesGenerator", strategy = "foreign", 
			parameters = { @Parameter(value = "salesOrderReturn", name = "property")})
	private int sales_id;

	@Id @GeneratedValue (generator = "stockGenerator") //PK auto generator for sales orders
	@GenericGenerator(name = "stockGenerator", strategy = "foreign", 
			parameters = { @Parameter(value = "stock", name = "property")})
	@Column (name = "catalogue_Id")
	private int catalogueId;

	@ManyToOne (cascade = CascadeType.ALL)
	private Stock stockItem;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private SalesOrderReturn salesOrderReturn;
	
	@Column(name="return_quantity")
	private int returnQuantity;
	
	@Column(name="shelved_quantity")
	private int shelvedQuantity;

	///////////////////////////////
	
	/**
	 * 
	 */
	public SalesOrderReturnLine() {}

	/**
	 * @param sales_id
	 * @param catalogueId
	 * @param stockItem
	 * @param salesOrderReturn
	 * @param returnQuantity
	 * @param shelvedQuantity
	 */
	public SalesOrderReturnLine(int sales_id, int catalogueId, Stock stockItem, SalesOrderReturn salesOrderReturn,
			int returnQuantity, int shelvedQuantity) {
		super();
		this.sales_id = sales_id;
		this.catalogueId = catalogueId;
		this.stockItem = stockItem;
		this.salesOrderReturn = salesOrderReturn;
		this.returnQuantity = returnQuantity;
		this.shelvedQuantity = shelvedQuantity;
	}

	///////////////////////////////

	/**
	 * @return the sales_id
	 */
	public int getSales_id() {
		return sales_id;
	}

	/**
	 * @return the catalogueId
	 */
	public int getCatalogueId() {
		return catalogueId;
	}

	/**
	 * @return the stockItem
	 */
	public Stock getStockItem() {
		return stockItem;
	}

	/**
	 * @return the salesOrderReturn
	 */
	public SalesOrderReturn getSalesOrderReturn() {
		return salesOrderReturn;
	}

	/**
	 * @return the returnQuantity
	 */
	public int getReturnQuantity() {
		return returnQuantity;
	}

	/**
	 * @return the shelvedQuantity
	 */
	public int getShelvedQuantity() {
		return shelvedQuantity;
	}

	/**
	 * @param sales_id the sales_id to set
	 */
	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}

	/**
	 * @param catalogueId the catalogueId to set
	 */
	public void setCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}

	/**
	 * @param stockItem the stockItem to set
	 */
	public void setStockItem(Stock stockItem) {
		this.stockItem = stockItem;
	}

	/**
	 * @param salesOrderReturn the salesOrderReturn to set
	 */
	public void setSalesOrderReturn(SalesOrderReturn salesOrderReturn) {
		this.salesOrderReturn = salesOrderReturn;
	}

	/**
	 * @param returnQuantity the returnQuantity to set
	 */
	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	/**
	 * @param shelvedQuantity the shelvedQuantity to set
	 */
	public void setShelvedQuantity(int shelvedQuantity) {
		this.shelvedQuantity = shelvedQuantity;
	}
}