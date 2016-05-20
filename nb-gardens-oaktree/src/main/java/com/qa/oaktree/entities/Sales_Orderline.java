package com.qa.oaktree.entities;
public class Sales_Orderline
{
	private int Sales_Order_sales_id1;
	private int Stock_catalogue_id;
	private int sales_quantity;
	private float unit_price;
	
	public Sales_Orderline(int Sales_Order_sales_id1, int Stock_catalogue_id, int sales_quantity, float unit_price)
	{
		this.Sales_Order_sales_id1 = Sales_Order_sales_id1;
		this.Stock_catalogue_id = Stock_catalogue_id;
		this.sales_quantity = sales_quantity;
		this.unit_price = unit_price;
	}

	public int getSales_Order_sales_id1() 
	{return Sales_Order_sales_id1;}

	public void setSales_Order_sales_id1(int sales_Order_sales_id1) 
	{Sales_Order_sales_id1 = sales_Order_sales_id1;}

	public int getStock_catalogue_id()
	{return Stock_catalogue_id;}

	public void setStock_catalogue_id(int stock_catalogue_id) 
	{Stock_catalogue_id = stock_catalogue_id;}

	public int getSales_quantity() 
	{return sales_quantity;}

	public void setSales_quantity(int sales_quantity) 
	{this.sales_quantity = sales_quantity;}

	public float getUnit_price() 
	{return unit_price;}

	public void setUnit_price(float unit_price) 
	{this.unit_price = unit_price;}
	
}
