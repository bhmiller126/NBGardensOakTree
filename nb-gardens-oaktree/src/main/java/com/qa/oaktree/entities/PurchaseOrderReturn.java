package com.qa.oaktree.entities;
public class PurchaseOrderReturn 
{
	private PurchaseOrder purchaseOrder;
	private String date;
	private String reason;
	
	public PurchaseOrderReturn(PurchaseOrder purchaseOrder, String date, String reason)
	{
		this.purchaseOrder = purchaseOrder;
		this.date = date;
		this.reason = reason;
	}

	public PurchaseOrder getPurchaseOrder()
	{return purchaseOrder;}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) 
	{this.purchaseOrder = purchaseOrder;}

	public String getDate() 
	{return date;}

	public void setDate(String date) 
	{this.date = date;}

	public String getReason()
	{return reason;}

	public void setReason(String reason) 
	{this.reason = reason;}	

}
