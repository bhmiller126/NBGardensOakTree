package com.qa.oaktree.entities;
public class Sales_Order_Returnline 
{
	private int stock_catalogue_id;
	private int Sales_Order_Return_Sales_Order_sales_id;
	private int return_quantity;
	private int shelved_quantity;
	
	public Sales_Order_Returnline(int Stock_catalogue_id, int Sales_Order_Return_Sales_Order_sales_id, int return_quantity, int shelved_quantity)
	{
		this.stock_catalogue_id = Stock_catalogue_id;
		this.Sales_Order_Return_Sales_Order_sales_id = Sales_Order_Return_Sales_Order_sales_id;
		this.return_quantity = return_quantity;
		this.shelved_quantity = shelved_quantity;
	}

	public int getStock_catalogue_id() 
	{return stock_catalogue_id;}

	public void setStock_catalogue_id(int stock_catalogue_id) 
	{this.stock_catalogue_id = stock_catalogue_id;}

	public int getSales_Order_Return_Sales_Order_sales_id() 
	{return Sales_Order_Return_Sales_Order_sales_id;}

	public void setSales_Order_Return_Sales_Order_sales_id(int sales_Order_Return_Sales_Order_sales_id) 
	{Sales_Order_Return_Sales_Order_sales_id = sales_Order_Return_Sales_Order_sales_id;}

	public int getReturn_quantity() 
	{return return_quantity;}

	public void setReturn_quantity(int return_quantity) 
	{this.return_quantity = return_quantity;}

	public int getShelved_quantity() 
	{return shelved_quantity;}

	public void setShelved_quantity(int shelved_quantity) 
	{this.shelved_quantity = shelved_quantity;}	
	
}
