package src.main.java.com.qa.oaktree.entities;

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
