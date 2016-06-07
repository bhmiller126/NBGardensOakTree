package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 
 * @author OakTree BM Stock SQl entity, cardinality annotation by LP
 */

@Entity
@Table(name = "Stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catalogue_id", nullable = false)
	@NotNull
	private int catalogueId;

	@Column(name = "sale_price", nullable = false)
	private BigDecimal salePrice;

	@Column(name = "current_quantity", nullable = false)
	private int currentQuantity;

	@Column(name = "reorder_level", nullable = false)
	private int reorderLevel;

	@Column(name = "re_order_quantity", nullable = false)
	private int reorderQuantity;

	@Column(name = "stock_status", length = 30, nullable = false)
	@NotNull
	@Size(min = 1, max = 30)
	private String stockStatus;

	@Column(name = "warehouse_location", length = 10, nullable = false)
	@NotNull
	@Size(min = 1, max = 10)
	String warehouseLocation;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "Stock")
	@JoinColumn(name = "Supplier_supplier_id", nullable = false)
	@NotNull
	private Supplier supplierId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "SalesOrderLine")
	private Set<SalesOrderLine> salesLine = new HashSet<SalesOrderLine>();	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "WishList")
	private Set<WishList> wishList = new HashSet<WishList>();	
	
	////////////////////////////////////////////

	/**
	 * 
	 */
	public Stock() {}
	
	
	/**
	 * @param catalogueId
	 * @param salePrice
	 * @param currentQuantity
	 * @param reorderLevel
	 * @param reorderQuantity
	 * @param stockStatus
	 * @param warehouseLocation
	 * @param supplierId
	 * @param salesLine
	 * @param wishList
	 */
	public Stock(int catalogueId, BigDecimal salePrice, int currentQuantity, int reorderLevel, int reorderQuantity,
			String stockStatus, String warehouseLocation, Supplier supplierId, Set<SalesOrderLine> salesLine,
			Set<WishList> wishList) {
		super();
		this.catalogueId = catalogueId;
		this.salePrice = salePrice;
		this.currentQuantity = currentQuantity;
		this.reorderLevel = reorderLevel;
		this.reorderQuantity = reorderQuantity;
		this.stockStatus = stockStatus;
		this.warehouseLocation = warehouseLocation;
		this.supplierId = supplierId;
		this.salesLine = salesLine;
		this.wishList = wishList;
	}
	////////////////////////////////////////////


	/**
	 * @return the catalogueId
	 */
	public int getCatalogueId() {
		return catalogueId;
	}


	/**
	 * @return the salePrice
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}


	/**
	 * @return the currentQuantity
	 */
	public int getCurrentQuantity() {
		return currentQuantity;
	}


	/**
	 * @return the reorderLevel
	 */
	public int getReorderLevel() {
		return reorderLevel;
	}


	/**
	 * @return the reorderQuantity
	 */
	public int getReorderQuantity() {
		return reorderQuantity;
	}


	/**
	 * @return the stockStatus
	 */
	public String getStockStatus() {
		return stockStatus;
	}


	/**
	 * @return the warehouseLocation
	 */
	public String getWarehouseLocation() {
		return warehouseLocation;
	}


	/**
	 * @return the supplierId
	 */
	public Supplier getSupplierId() {
		return supplierId;
	}


	/**
	 * @return the salesLine
	 */
	public Set<SalesOrderLine> getSalesLine() {
		return salesLine;
	}


	/**
	 * @return the wishList
	 */
	public Set<WishList> getWishList() {
		return wishList;
	}


	/**
	 * @param catalogueId the catalogueId to set
	 */
	public void setCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}


	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}


	/**
	 * @param currentQuantity the currentQuantity to set
	 */
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}


	/**
	 * @param reorderLevel the reorderLevel to set
	 */
	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}


	/**
	 * @param reorderQuantity the reorderQuantity to set
	 */
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}


	/**
	 * @param stockStatus the stockStatus to set
	 */
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}


	/**
	 * @param warehouseLocation the warehouseLocation to set
	 */
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}


	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(Supplier supplierId) {
		this.supplierId = supplierId;
	}


	/**
	 * @param salesLine the salesLine to set
	 */
	public void setSalesLine(Set<SalesOrderLine> salesLine) {
		this.salesLine = salesLine;
	}


	/**
	 * @param wishList the wishList to set
	 */
	public void setWishList(Set<WishList> wishList) {
		this.wishList = wishList;
	}	
}
