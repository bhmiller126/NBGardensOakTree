package com.qa.oaktree;

public class purchase_order {
	int purchase_id; 
	int Supplier_supplier_id; 
	
	
	public purchase_order (int purchase_id, int Supplier_supplier_id) {
		this.purchase_id = purchase_id; 
		this.Supplier_supplier_id= Supplier_supplier_id; 
		
		
	}


	public int getPurchase_id() {
		return purchase_id;
	}


	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}


	public int getSupplier_supplier_id() {
		return Supplier_supplier_id;
	}


	public void setSupplier_supplier_id(int supplier_supplier_id) {
		Supplier_supplier_id = supplier_supplier_id;
	}

}
