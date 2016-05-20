package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn;  

import java.util.Date;

public class PaymentDetails 
{
	private String Customer_user_name;
	private String card_number;
	private String name_on_card;
	private String card_type;
	private Date exp_date;
	private Date start_date;
	private String Address_line_1;
	private String Address_post_code;
	
	public PaymentDetails(String Customer_user_name, String card_number, String name_on_card, String card_type, Date exp_date, Date start_date, 
			String Address_line_1, String Address_post_code)
	{
		this.Customer_user_name = Customer_user_name;
		this.card_number = card_number;
		this.name_on_card = name_on_card;
		this.card_type = card_type;
		this.exp_date = exp_date;
		this.start_date = start_date;
		this.Address_line_1 = Address_line_1;
		this.Address_post_code = Address_post_code;
	}
	
	public String getCustomer_user_name() {
		return Customer_user_name;
	}
	public void setCustomer_user_name(String customer_user_name) {
		Customer_user_name = customer_user_name;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getName_on_card() {
		return name_on_card;
	}
	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getAddress_line_1() {
		return Address_line_1;
	}
	public void setAddress_line_1(String address_line_1) {
		Address_line_1 = address_line_1;
	}
	public String getAddress_post_code() {
		return Address_post_code;
	}
	public void setAddress_post_code(String address_post_code) {
		Address_post_code = address_post_code;
	}
	
	
}
