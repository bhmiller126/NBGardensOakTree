package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 

@Entity
@Table(name = "Purchase_Order_Line")
public class Purchase_order_line {

	@Column(name = "Purchase_Order_purchase_id")
	int purchaseOrderId;

	@Column(name = "Stock_catalogue_id")
	int stockCatalogueId;

	@Column(name = "purchase_quantity")
	int purchaseQuantity;

	@Column(name = "purchase_unit_price")
	double purchaseUnitPrice;

	public Purchase_order_line(int purchaseOrderId, int stockCatalogueId, int purchaseQuantity,
			double purchaseUnitPrice) {
		this.purchaseOrderId = purchaseOrderId;
		this.stockCatalogueId = stockCatalogueId;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseUnitPrice = purchaseUnitPrice;

	}

	public int getPurchase_Order_Purchase_Id() {
		return purchaseOrderId;
	}

	public void setPurchase_Order_Purchase_Id(int purchase_Order_Purchase_Id) {
		this.purchaseOrderId = purchase_Order_Purchase_Id;
	}

	public int getStock_Catalogue_Id() {
		return stockCatalogueId;
	}

	public void setStock_Catalogue_Id(int stock_Catalogue_Id) {
		this.stockCatalogueId = stock_Catalogue_Id;
	}

	public int getPurchase_Quantity() {
		return purchaseQuantity;
	}

	public void setPurchase_Quantity(int purchase_Quantity) {
		this.purchaseQuantity = purchase_Quantity;
	}

	public double getPurchase_Unit_Price() {
		return purchaseUnitPrice;
	}

	public void setPurchase_Unit_Price(double purchase_Unit_Price) {
		this.purchaseUnitPrice = purchase_Unit_Price;
	}

}
