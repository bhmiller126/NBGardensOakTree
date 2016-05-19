package com.qa.oaktree;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class stock {
	int catalogue_Id; 
	double sale_Price;
	int current_Quantity;
	int reorder_Level; 
	int reorder_Quantity;
	String stock_Status;
	String warehouse_Location; 
	int supplier_Supplier_Id; 
	
	 public stock(int catalogue_id, double sale_price, int current_quantity, int redorder_level, int reorder_quantity, String stock_status, String warehouse_location, int Supplier_supplier_id   ){
		
		 this.catalogue_Id = catalogue_id;
		 this.sale_Price = sale_price;
		 this.current_Quantity = current_quantity;
		 this.reorder_Level = redorder_level; 
		 this.reorder_Quantity = reorder_quantity;
		 this.stock_Status = stock_status;
		 this.warehouse_Location = warehouse_location;
		 this.supplier_Supplier_Id = Supplier_supplier_id; 
	 }

	public int getCatalogue_id() {
		return catalogue_Id;
	}

	public void setCatalogue_id(int catalogue_id) {
		this.catalogue_Id = catalogue_id;
	}

	public double getSale_price() {
		return sale_Price;
	}

	public void setSale_price(double sale_price) {
		this.sale_Price = sale_price;
	}

	public int getCurrent_quantity() {
		return current_Quantity;
	}

	public void setCurrent_quantity(int current_quantity) {
		this.current_Quantity = current_quantity;
	}

	public int getReorder_level() {
		return reorder_Level;
	}

	public void setReorder_level(int reorder_level) {
		this.reorder_Level = reorder_level;
	}

	public int getReorder_quantity() {
		return reorder_Quantity;
	}

	public void setReorder_quantity(int reorder_quantity) {
		this.reorder_Quantity = reorder_quantity;
	}

	public String getStock_status() {
		return stock_Status;
	}

	public void setStock_status(String stock_status) {
		this.stock_Status = stock_status;
	}

	public String getWarehouse_location() {
		return warehouse_Location;
	}

	public void setWarehouse_location(String warehouse_location) {
		this.warehouse_Location = warehouse_location;
	}

	public int getSupplier_supplier_id() {
		return supplier_Supplier_Id;
	}

	public void setSupplier_supplier_id(int supplier_supplier_id) {
		supplier_Supplier_Id = supplier_supplier_id;
	}
	

}
