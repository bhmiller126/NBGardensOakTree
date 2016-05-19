package com.qa.oaktree;

public class supplier {
	int supplier_id; 
	String name; 
	String contact_no; 
	String email; 
	String address_line_1;
	String address_postcode;
	
	public supplier (int supplier_id, String name, String contact_no, String email, String address_line_1, String address_postcode) {
		
		this.supplier_id = supplier_id; 
		this.name = name; 
		this.contact_no = contact_no; 
		this.email = email; 
		this.address_line_1 = address_line_1; 
		this.address_postcode = address_postcode; 
		
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	public String getAddress_postcode() {
		return address_postcode;
	}

	public void setAddress_postcode(String address_postcode) {
		this.address_postcode = address_postcode;
	}

}
