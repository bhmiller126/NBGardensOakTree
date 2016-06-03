package com.qa.oaktree.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author OakTree LP
 * Sales order entity
 */
@Entity
@Table (name = "Sales_Order")
public class SalesOrder {

	@Id
	@GeneratedValue
	@Column (name = "sales_id")
	private int salesId; 
	
	@Column (name = "Customer_user_name")
	private Customer customer;
	
	@Column (name = "Address_line_1")
	private String addressLine1; 
	
	@Column (name = "Address_postcode")
	private String addressPostcode; 
	
	
	/**
	 * Default null constructor for sales order
	 */
	public SalesOrder() {
	
	}

	/**
	 * Full constructor for Sales Order
	 * @param salesId Int of the sales id
	 * @param customerUserName String of the Customers user name who is creating the order
	 * @param addressLine1 String line 1 of the delivery address
	 * @param addressPostcode String postcode of the delivery address
	 */
	public SalesOrder(int salesId, Customer customerUserName, String addressLine1, String addressPostcode) {
		super();
		this.salesId = salesId;
		this.customer = customerUserName;
		this.addressLine1 = addressLine1;
		this.addressPostcode = addressPostcode;
	}

	/**
	 * @return the salesId
	 */
	public int getSalesId() {
		return salesId;
	}

	/**
	 * @return the customerUserName
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @return the addressPostcode
	 */
	public String getAddressPostcode() {
		return addressPostcode;
	}

	/**
	 * @param salesId the salesId to set
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	/**
	 * @param customerUserName the customerUserName to set
	 */
	public void setCustomerUserName(Customer customerUserName) {
		this.customer = customerUserName;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @param addressPostcode the addressPostcode to set
	 */
	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}

	/**
	 * Override object.equals method of Sales Order 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrder other = (SalesOrder) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressPostcode == null) {
			if (other.addressPostcode != null)
				return false;
		} else if (!addressPostcode.equals(other.addressPostcode))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (salesId != other.salesId)
			return false;
		return true;
	}

	/**
	 * Override Object.toString method for SalesOrder
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalesOrder [salesId=" + salesId + ", customerUserName=" + customer + ", addressLine1="
				+ addressLine1 + ", addressPostcode=" + addressPostcode + "]";
	}

	
}
