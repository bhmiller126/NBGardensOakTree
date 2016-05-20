package src.main.java.com.qa.oaktree.entities;

public class purchase_order {
	int purchase_Id; 
	int supplier_Supplier_Id; 
	
	
	public purchase_order (int purchase_Id, int supplier_Supplier_Id) {
		this.purchase_Id = purchase_Id; 
		this.supplier_Supplier_Id= supplier_Supplier_Id; 
		
		
	}


	public int getPurchase_id() {
		return purchase_Id;
	}


	public void setPurchase_id(int purchase_id) {
		this.purchase_Id = purchase_id;
	}


	public int getSupplier_supplier_id() {
		return supplier_Supplier_Id;
	}


	public void setSupplier_supplier_id(int supplier_supplier_id) {
		supplier_Supplier_Id = supplier_supplier_id;
	}

}
