package com.qa.oaktree;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class stock {
	int catalogue_id; 
	double sale_price;
	int current_quantity;
	int reorder_level; 
	int reorder_quantity;
	String stock_status;
	String warehouse_location; 
	int Supplier_supplier_id; 
	
	 public stock(int catalogue_id, double sale_price, int current_quantity, int redorder_level, int reorder_quantity, String stock_status, String warehouse_location, int Supplier_supplier_id   ){
		
		 this.catalogue_id = catalogue_id;
		 this.sale_price = sale_price;
		 this.current_quantity = current_quantity;
		 this.reorder_level = redorder_level; 
		 this.reorder_quantity = reorder_quantity;
		 this.stock_status = stock_status;
		 this.warehouse_location = warehouse_location;
		 this.Supplier_supplier_id = Supplier_supplier_id; 
	 }

	public int getCatalogue_id() {
		return catalogue_id;
	}

	public void setCatalogue_id(int catalogue_id) {
		this.catalogue_id = catalogue_id;
	}

	public double getSale_price() {
		return sale_price;
	}

	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}

	public int getCurrent_quantity() {
		return current_quantity;
	}

	public void setCurrent_quantity(int current_quantity) {
		this.current_quantity = current_quantity;
	}

	public int getReorder_level() {
		return reorder_level;
	}

	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}

	public int getReorder_quantity() {
		return reorder_quantity;
	}

	public void setReorder_quantity(int reorder_quantity) {
		this.reorder_quantity = reorder_quantity;
	}

	public String getStock_status() {
		return stock_status;
	}

	public void setStock_status(String stock_status) {
		this.stock_status = stock_status;
	}

	public String getWarehouse_location() {
		return warehouse_location;
	}

	public void setWarehouse_location(String warehouse_location) {
		this.warehouse_location = warehouse_location;
	}

	public int getSupplier_supplier_id() {
		return Supplier_supplier_id;
	}

	public void setSupplier_supplier_id(int supplier_supplier_id) {
		Supplier_supplier_id = supplier_supplier_id;
	}
	

}
