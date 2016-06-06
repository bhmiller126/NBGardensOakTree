package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author OakTree BM Stock SQl entity, cardinality annotation by LP
 */

@Entity
@Table(name = "Stock")
public class Stock {

	/**
	 * The first variable catalogueId has @Id and @GeneratedValue.
	 * 
	 * @Id dictates that this is the primary key in the database table
	 * @GeneratedValue allows the Id to know that it is an auto incremented
	 *                 number After @Column the name = " " has to match the name
	 *                 of the table in the database so it can be accessed from
	 *                 the application
	 * @NotNull means that column cannot be null, therefore always needs a value
	 *          input
	 * 
	 */

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

	/**
	 * Stock status column, has @Size parameter This states that it must have a
	 * minimum of one character and a maximum of 30
	 */
	@Column(name = "stock_status", length = 30, nullable = false)
	@NotNull
	@Size(min = 1, max = 30)
	String stockStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	private SalesOrderLine salesLine;	

	/**
	 * warehouse location column, has @Size parameter This states that it must
	 * have a minimum of one character and a maximum of 10
	 */

	@Column(name = "warehouse_location", length = 10, nullable = false)
	@NotNull
	@Size(min = 1, max = 10)
	String warehouseLocation;

	/**
	 * *@OneToOne is the cardinality for that variable with another variable in
	 * a separate entity
	 * @return 
	 * 
	 * @JoinColumn lets the application know where to access the variable and
	 *             what to return
	 * @return supplierId from the Supplier entity
	 */
	@OneToOne
	@JoinColumn(name = "Supplier_supplier_id", nullable = false)
	public  int getSupplierId() {
		return supplierId;
	}
	@NotNull
	private int supplierId;

	
	private Set<WishList> wishList;
	
	
	
	/**
	 * Null constructor for stock
	 */
	public Stock() {
		this.catalogueId = 0;
		this.salePrice = new BigDecimal("");
		this.currentQuantity = 0;
		this.reorderLevel = 0;
		this.reorderQuantity = 0;
		this.stockStatus = "";
		this.warehouseLocation = "";
		this.supplierId = 0;
	}

	/**
	 * Full constructor for stock
	 * 
	 * @param catalogueId
	 * @param salePrice,
	 *            price item is sold for
	 * @param currentQuantity,
	 *            amount currently in stock
	 * @param reorderLevel,
	 *            at what level do we reorder more stock
	 * @param reorderQuantity,
	 *            how much do we want to reorder
	 * @param stockStatus,
	 *            in stock, discontinued, on order, back order
	 * @param warehouseLocation
	 * @param supplierId
	 */
	public Stock(int catalogueId, BigDecimal salePrice, int currentQuantity, int reorderLevel, int reorderQuantity,
			String stockStatus, String warehouseLocation, int supplierId) {

		this.catalogueId = catalogueId;
		this.salePrice = salePrice;
		this.currentQuantity = currentQuantity;
		this.reorderLevel = reorderLevel;
		this.reorderQuantity = reorderQuantity;
		this.stockStatus = stockStatus;
		this.warehouseLocation = warehouseLocation;
		this.supplierId = supplierId;
	}

	/***************** getters and setters ******************/
	
	@OneToMany (mappedBy = "stock", cascade = CascadeType.ALL)
	public Set<WishList> getWishlist() {
		return wishList;	
	}
	
	public void setWishList(Set<WishList> wishList) {
		this.wishList = wishList;
	}

	/**
	 * get CatalogueId method
	 * 
	 * @return catalogueId
	 */

	public int getCatalogueId() {
		return catalogueId;
	}

	/**
	 * set CatalogueId method
	 * 
	 * @set catalogueId in case we need to add new stock
	 */
	public void setCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}

	/**
	 * Sale price getter
	 * 
	 * @return salePrice
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	/**
	 * set Saleprice method
	 * 
	 * @param salePrice
	 *            for when we need to change or add new price
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * get current quantity method
	 * 
	 * @return current quantity in stock
	 */
	public int getCurrentQuantity() {
		return currentQuantity;
	}

	/**
	 * set current quantity method
	 * 
	 * @set currentQuantity in case we need to add something back to shelf
	 */
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	/**
	 * get reorder level method
	 * 
	 * @return redorder level
	 */
	public int getReorderLevel() {
		return reorderLevel;
	}

	/**
	 * set reorder level method
	 * 
	 * @set reorder level in case demand of a product changes
	 */

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	/**
	 * get reorder quanitity method
	 * 
	 * @return redorder quantity
	 */
	public int getReorderQuantity() {
		return reorderQuantity;
	}

	/**
	 * set reorder quantity method
	 * 
	 * @set redorder quantity incase need to do a manual purchase order
	 */
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	/**
	 * get stock status method
	 * 
	 * @return status of the stock e.g. in stock
	 */
	public String getStockStatus() {
		return stockStatus;
	}

	/**
	 * set stock status method
	 * 
	 * @set status of the stock, normally after confirming and order or
	 *      recieving confirmation of despatch
	 */
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	/**
	 * get warehouse location method
	 * 
	 * @return location of stock item
	 */
	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	/**
	 * set warehouse location method
	 * 
	 * @set warehouse location e.g. G4
	 */
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	/**
	 * set stock status method
	 * 
	 * @set supplier Id if prefferred supplier changes
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	/**
	 * Override object equals methof for Stock entity 
	 * @param other stock items to be checked against
	 * @return boolean true if stock items are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (catalogueId != other.catalogueId)
			return false;
		if (currentQuantity != other.currentQuantity)
			return false;
		if (reorderLevel != other.reorderLevel)
			return false;
		if (reorderQuantity != other.reorderQuantity)
			return false;
		if (salePrice == null) {
			if (other.salePrice != null)
				return false;
		} else if (!salePrice.equals(other.salePrice))
			return false;
		if (stockStatus == null) {
			if (other.stockStatus != null)
				return false;
		} else if (!stockStatus.equals(other.stockStatus))
			return false;
		if (supplierId != other.supplierId)
			return false;
		if (warehouseLocation == null) {
			if (other.warehouseLocation != null)
				return false;
		} else if (!warehouseLocation.equals(other.warehouseLocation))
			return false;
		return true;
	}

	/**
	 * Override Objects toString method for stock 
	 *
	 */
	@Override
	public String toString() {
		return "Stock [catalogueId= " + catalogueId + ","
				+ "salePrice= " + salePrice + "," 
				+ "currentQuantity= " + currentQuantity + ","
				+ "reorderLevel= " + reorderLevel + "," 
				+ "reorderQuantity= " + reorderQuantity + "," 
				+ "stockStatus= " + stockStatus + "," 
				+ "warehouseLocation= " + warehouseLocation + ","
				+ "supplierId= " + supplierId + "]";
	}

}
