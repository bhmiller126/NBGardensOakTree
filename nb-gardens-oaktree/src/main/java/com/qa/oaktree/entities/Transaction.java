package com.qa.oaktree.entities;
public class Transaction 
{
	private int transaction_id;
	private String payment_details_customer_user_name;
	private String payment_details_card_number;
	private int sales_order_sales_id;
	private String payment_details_name_on_card;
	private String date;
	private float amount;
	private String payment_details_customer_user_name1;
	private String payment_details_card_number1;
	
	public Transaction(int transaction_id, String payment_details_customer_user_name, String payment_details_card_number, int sales_order_sales_id, String payment_details_name_on_card, String date, float amount, String payment_details_customer_user_name1, String payment_details_card_number1)
	{
		this.transaction_id = transaction_id;
		this.payment_details_customer_user_name = payment_details_customer_user_name;
		this.payment_details_card_number = payment_details_card_number;
		this.sales_order_sales_id = sales_order_sales_id;
		this.payment_details_name_on_card = payment_details_name_on_card;
		this.date = date;
		this.amount = amount;
		this.payment_details_customer_user_name1 = payment_details_customer_user_name1;
		this.payment_details_card_number1 = payment_details_card_number1;
	}

	public int getTransaction_id() 
	{return transaction_id;}

	public void setTransaction_id(int transaction_id) 
	{this.transaction_id = transaction_id;}

	public String getPayment_details_customer_user_name() 
	{return payment_details_customer_user_name;}

	public void setPayment_details_customer_user_name(String payment_details_customer_user_name) 
	{this.payment_details_customer_user_name = payment_details_customer_user_name;}

	public String getPayment_details_card_number() 
	{return payment_details_card_number;}

	public void setPayment_details_card_number(String payment_details_card_number) 
	{this.payment_details_card_number = payment_details_card_number;}

	public int getSales_order_sales_id() 
	{return sales_order_sales_id;}

	public void setSales_order_sales_id(int sales_order_sales_id) 
	{this.sales_order_sales_id = sales_order_sales_id;}

	public String getPayment_details_name_on_card() 
	{return payment_details_name_on_card;}

	public void setPayment_details_name_on_card(String payment_details_name_on_card) 
	{this.payment_details_name_on_card = payment_details_name_on_card;}

	public String getDate() 
	{return date;}

	public void setDate(String date) 
	{this.date = date;}

	public float getAmount() 
	{return amount;}

	public void setAmount(float amount) 
	{this.amount = amount;}

	public String getPayment_details_customer_user_name1() 
	{return payment_details_customer_user_name1;}

	public void setPayment_details_customer_user_name1(String payment_details_customer_user_name1) 
	{this.payment_details_customer_user_name1 = payment_details_customer_user_name1;}

	public String getPayment_details_card_number1() 
	{return payment_details_card_number1;}

	public void setPayment_details_card_number1(String payment_details_card_number1) 
	{this.payment_details_card_number1 = payment_details_card_number1;}	
	
}

