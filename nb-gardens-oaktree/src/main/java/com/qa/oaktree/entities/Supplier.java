package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column; 
import javax.persistence.Id; 

/**
 * @author Daniel
 *
 */

@Entity
@Table (name = "Supplier")
public class Supplier {
	
	@Id
	@Column (name = "supplier_id", nullable = false)
	private int supplierID;
	
	@Column (name = "name", nullable = false, length = 45)
	@NotNull
	@Size (min = 2, max = 45)
	private String name;
	
	@Column (name = "contact_no", nullable = false, length = 13)
	@NotNull
	@Size ( min = 10, max = 13)
	private String contactPhoneNumber;
	
	@Column (name = "email", nullable = true, length = 100)
	@Size (min = 10, max = 100)
	private String contactEmail;
	
	@Column (name = "Address_line_1", nullable = false, length = 45)
	@NotNull
	@Size (min = 2, max = 45)
	private String addressLine1;
	
	@Column (name = "Address_postcode", nullable = false, length = 8)
	@NotNull
	@Size (min = 4, max = 8)
	private String addressPostcode;
	
	/**
	 * Default null constructor for Supplier
	 */
	public Supplier()
	{
		this.supplierID = -1;
		this.name = "";
		this.contactPhoneNumber = "";
		this.contactEmail = "";
		this.addressLine1 = "";
		this.addressPostcode = "";
	}
	
	/**
	 * Full constructor for Supplier
	 * @param supplierID; Int autoincrementing integer
	 * @param name; String Supplier's company name
	 * @param contactPhoneNumber; String Supplier's contact phone number
	 * @param contactEmail; String Supplier's contact email address
	 * @param addressLine1; String First line of supplier's address 
	 * @param addressPostcode; String Postal code of supplier's address
	 */
	public Supplier (int supplierID, String name, String contactPhoneNumber, String contactEmail, String addressLine1, String addressPostcode) 
	{
		this.supplierID = supplierID; 
		this.name = name; 
		this.contactPhoneNumber = contactPhoneNumber; 
		this.contactEmail = contactEmail; 
		this.addressLine1 = addressLine1; 
		this.addressPostcode = addressPostcode; 
		
	}

	/**
	 * @return the supplierID
	 */
	public int getSupplierID() {
		return supplierID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the contactPhoneNumber
	 */
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
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
	 * @param supplierID the supplierID to set
	 */
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param contactPhoneNumber the contactPhoneNumber to set
	 */
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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
	 * Override equals() method for Supplier
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @return false if the supplier 'other' is different to this supplier 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
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
		if (contactEmail == null) {
			if (other.contactEmail != null)
				return false;
		} else if (!contactEmail.equals(other.contactEmail))
			return false;
		if (contactPhoneNumber == null) {
			if (other.contactPhoneNumber != null)
				return false;
		} else if (!contactPhoneNumber.equals(other.contactPhoneNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (supplierID != other.supplierID)
			return false;
		return true;
	}

	/**
	 * Override object's toString() method for Supplier
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID 
				+ ", name=" + name 
				+ ", contactPhoneNumber=" + contactPhoneNumber
				+ ", contactEmail=" + contactEmail 
				+ ", addressLine1=" + addressLine1 
				+ ", addressPostcode=" + addressPostcode + "]";
	}
}
