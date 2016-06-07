package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne; 

/**
 * @author Daniel, cardinality mapped by Laurence 
 * Entity used to capture supplier information
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
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "Stock")
	@JoinColumn(name = "catalogue_id")
	private Stock stock;
	
	/**
	 * Default null constructor for Supplier
	 */
	public Supplier() {}
	
	/**
	 * 	 * Full constructor for Supplier
	 * @param supplierID; Int autoincrementing integer
	 * @param name; String Supplier's company name
	 * @param contactPhoneNumber; String Supplier's contact phone number
	 * @param contactEmail; String Supplier's contact email address
	 * @param addressLine1; String First line of supplier's address 
	 * @param addressPostcode; String Postal code of supplier's address
	 * @param stock; Stock used to map to stock for preffered supplier.
	 */
	public Supplier(int supplierID, String name, String contactPhoneNumber, String contactEmail, String addressLine1,
			String addressPostcode, Stock stock) {
		super();
		this.supplierID = supplierID;
		this.name = name;
		this.contactPhoneNumber = contactPhoneNumber;
		this.contactEmail = contactEmail;
		this.addressLine1 = addressLine1;
		this.addressPostcode = addressPostcode;
		this.stock = stock;
	}
	//////////////////////////////////////

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
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
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
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
