package com.qa.oaktree.entities;

public class Purchase_order_line {
	int purchase_Order_Purchase_Id; 
	int stock_Catalogue_Id; 
	int purchase_Quantity; 
	double purchase_Unit_Price; 
	
	public Purchase_order_line (int purchase_Order_Purchase_Id, int stock_Catalogue_Id, int purchase_Quantity, double purchase_Unit_Price){
		this.purchase_Order_Purchase_Id = purchase_Order_Purchase_Id; 
		this.stock_Catalogue_Id = stock_Catalogue_Id; 
		this.purchase_Quantity = purchase_Quantity; 
		this.purchase_Unit_Price = purchase_Unit_Price; 
		
	}

	public int getPurchase_Order_Purchase_Id() {
		return purchase_Order_Purchase_Id;
	}

	public void setPurchase_Order_Purchase_Id(int purchase_Order_Purchase_Id) {
		this.purchase_Order_Purchase_Id = purchase_Order_Purchase_Id;
	}

	public int getStock_Catalogue_Id() {
		return stock_Catalogue_Id;
	}

	public void setStock_Catalogue_Id(int stock_Catalogue_Id) {
		this.stock_Catalogue_Id = stock_Catalogue_Id;
	}

	public int getPurchase_Quantity() {
		return purchase_Quantity;
	}

	public void setPurchase_Quantity(int purchase_Quantity) {
		this.purchase_Quantity = purchase_Quantity;
	}

	public double getPurchase_Unit_Price() {
		return purchase_Unit_Price;
	}

	public void setPurchase_Unit_Price(double purchase_Unit_Price) {
		this.purchase_Unit_Price = purchase_Unit_Price;
	}

}
