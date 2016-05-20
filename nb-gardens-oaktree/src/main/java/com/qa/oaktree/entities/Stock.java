package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn; 

@Entity
@Table (name = "Stock")
public class Stock {
	
	@Id
	@Column (name = "catalogue_id", nullable = false)
	@NotNull
	int catalogueId; 
	
	@Column (name = "sale_price", nullable = false)
	@NotNull
	double salePrice;
	
	@Column (name = "current_quantity", nullable = false)
	@NotNull
	int currentQuantity;
	
	@Column (name = "reorder_level", nullable = false)
	@NotNull
	int reorderLevel; 
	
	@Column (name = "re_order_quantity", nullable = false)
	@NotNull
	int reorderQuantity;
	
	@Column (name = "stock_status", length = 30, nullable = false)
	@NotNull
	@Size (min = 1, max = 30)
	String stockStatus;
	
	@Column (name = "warehouse_location", length = 10, nullable = false)
	@NotNull
	@Size (min = 1, max = 10)
	String warehouseLocation; 
	
	@OneToOne
	@JoinColumn (name = "Supplier_supplier_id", nullable = false)
	public int getSupplier_supplier_id() {
		return supplierId;
	}
	@NotNull
	int supplierId; 
	
	
	
	 public Stock(int catalogue_id, double sale_price, int current_quantity, int redorder_level, int reorder_quantity, String stock_status, String warehouse_location, int Supplier_supplier_id   ){
		
		 this.catalogueId = catalogue_id;
		 this.salePrice = sale_price;
		 this.currentQuantity = current_quantity;
		 this.reorderLevel = redorder_level; 
		 this.reorderQuantity = reorder_quantity;
		 this.stockStatus = stock_status;
		 this.warehouseLocation = warehouse_location;
		 this.supplierId = Supplier_supplier_id; 
	 }

	public int getCatalogue_id() {
		return catalogueId;
	}

	public void setCatalogue_id(int catalogue_id) {
		this.catalogueId = catalogue_id;
	}

	public double getSale_price() {
		return salePrice;
	}

	public void setSale_price(double sale_price) {
		this.salePrice = sale_price;
	}

	public int getCurrent_quantity() {
		return currentQuantity;
	}

	public void setCurrent_quantity(int current_quantity) {
		this.currentQuantity = current_quantity;
	}

	public int getReorder_level() {
		return reorderLevel;
	}

	public void setReorder_level(int reorder_level) {
		this.reorderLevel = reorder_level;
	}

	public int getReorder_quantity() {
		return reorderQuantity;
	}

	public void setReorder_quantity(int reorder_quantity) {
		this.reorderQuantity = reorder_quantity;
	}

	public String getStock_status() {
		return stockStatus;
	}

	public void setStock_status(String stock_status) {
		this.stockStatus = stock_status;
	}

	public String getWarehouse_location() {
		return warehouseLocation;
	}

	public void setWarehouse_location(String warehouse_location) {
		this.warehouseLocation = warehouse_location;
	}


	public void setSupplier_supplier_id(int supplier_supplier_id) {
		supplierId = supplier_supplier_id;
	}
	

}
