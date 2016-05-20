package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn;  

public class PurchaseOrderReturnLine {
	private int purchaseOrderId; 
	private int stockCatalogueId; 
	private int returnQuantity; 
	
	public PurchaseOrderReturnLine (int purchaseOrderReturnPurchaseOrderPurchaseId, int stockCatalogueId, int returnQuantity ) {
		this.purchaseOrderId = purchaseOrderReturnPurchaseOrderPurchaseId; 
		this.stockCatalogueId = stockCatalogueId; 
		this.returnQuantity = returnQuantity;
	}

	public int getPurchaseOrderReturnPurchaseOrderPurchaseId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderReturnPurchaseOrderPurchaseId(int purchaseOrderReturnPurchaseOrderPurchaseId) {
		this.purchaseOrderId = purchaseOrderReturnPurchaseOrderPurchaseId;
	}

	public int getStockCatalogueId() {
		return stockCatalogueId;
	}

	public void setStockCatalogueId(int stockCatalogueId) {
		this.stockCatalogueId = stockCatalogueId;
	}

	public int getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

}
