
package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 

public class Supplier {
	int supplier_Id; 
	String name; 
	String contact_No; 
	String email; 
	String address_Line_1;
	String address_Postcode;
	
	public Supplier (int supplier_id, String name, String contact_no, String email, String address_line_1, String address_postcode) {
		
		this.supplier_Id = supplier_id; 
		this.name = name; 
		this.contact_No = contact_no; 
		this.email = email; 
		this.address_Line_1 = address_line_1; 
		this.address_Postcode = address_postcode; 
		
	}

	public int getSupplier_id() {
		return supplier_Id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_Id = supplier_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_no() {
		return contact_No;
	}

	public void setContact_no(String contact_no) {
		this.contact_No = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress_line_1() {
		return address_Line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_Line_1 = address_line_1;
	}

	public String getAddress_postcode() {
		return address_Postcode;
	}

	public void setAddress_postcode(String address_postcode) {
		this.address_Postcode = address_postcode;
	}

}
