package com.qa.oaktree.entities;
public class Purchase_Order_Return 
{
	private int Purchase_Order_purchase_id;
	private String date;
	private String reason;
	
	public Purchase_Order_Return(int Purchase_Order_purchase_id, String date, String reason)
	{
		this.Purchase_Order_purchase_id = Purchase_Order_purchase_id;
		this.date = date;
		this.reason = reason;
	}

	public int getPurchase_Order_purchase_id()
	{return Purchase_Order_purchase_id;}

	public void setPurchase_Order_purchase_id(int purchase_Order_purchase_id) 
	{Purchase_Order_purchase_id = purchase_Order_purchase_id;}

	public String getDate() 
	{return date;}

	public void setDate(String date) 
	{this.date = date;}

	public String getReason()
	{return reason;}

	public void setReason(String reason) 
	{this.reason = reason;}	

}
