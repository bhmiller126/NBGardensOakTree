package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

/**
 * 
 * @author OakTree Bryony
 * WishList SQL entity
 */
@Entity
@Table(name = "Wishlist")
public class WishList {

	// TODO check that the cardinallities are correct for annotations
	/**
	 * This section adds customer username and uses it as a foreign key from the
	 * customer table with one to one cardinality Added the getter within here
	 * so the column knows to access getCustomerUserName. The getter will return
	 * the customer username stored in the database copied the format for this
	 * from online, sure if this is std practice
	 * 
	 * name = "Customer_user_name" should match the name of the table specified
	 * in the database so it knows what to access the foreign key from 
	 * @return
	 */
	@OneToMany
	@JoinColumn(name = "Customer_user_name", nullable = false)
	public int getCustomerUserName() {
		return customerUserName;
	}
	@NotNull
	private int customerUserName;

	/**
	 * This adds stock catalogue as a foreign key, similar to customer
	 * username above This is a many to one cardinality The name = has to match
	 * the name of the table created in the database
	 * @return
	 */
	@ManyToOne
	@JoinColumn(name = "Stock_catalogue_id", nullable = false)
	public int getStockCatalogueId() {
		return catalogueId;
	}

	@NotNull
	private int catalogueId;

	/*
	 * columnDefinition = "int default '1'" this should make sure that if the
	 * customer does not insert a quanity within the wishlist it will place 1 in
	 * there instead
	 */

	// TODO look int setting default values

	@Column(name = "wish_quantity", columnDefinition = "int default '1'")
	private int wishQuantity;

	/**
	 * Full constructor for wishlist entity Every entry must have a customer
	 * username, the cataloogue Id and quantity quantity has a default setting
	 * of 1
	 * 
	 * @param customerUserName
	 * @param catalogueId
	 * @param wishQuantity
	 */
	public WishList(int customerUserName, int catalogueId, int wishQuantity) {
		this.customerUserName = customerUserName;
		this.catalogueId = catalogueId;
		this.wishQuantity = wishQuantity;
	}

	/**
	 * Customer username setter method
	 * 
	 * @set customerUserName to the string entered
	 */
	public void setCustomerUserName(int customerUserName) {
		this.customerUserName = customerUserName;
	}

	/**
	 * catalogueId setter method
	 * 
	 * @set catalogueId to the integer entered
	 */
	public void setStockCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}

	/**
	 * Wish quantity getter method
	 * 
	 * @return quantity of the item on wishlist
	 */
	public int getWishQuantity() {
		return wishQuantity;
	}

	/**
	 * Set wish quantity method
	 * 
	 * @set wishQuantity, default of 1 as added to the column specification
	 */
	public void setWishQuantity(int wishQuantity) {
		this.wishQuantity = wishQuantity;
	}



	/** 
	 * Override object equals method for Wishlist entity
	 * @param other wishlist items to be checked against
	 * @return boolean true if items are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishList other = (WishList) obj;
		if (catalogueId != other.catalogueId)
			return false;
		if (customerUserName != other.customerUserName)
			return false;
		if (wishQuantity != other.wishQuantity)
			return false;
		return true;
	}

	/** 
	 * Override object's toString method for Address
	 */
	@Override
	public String toString() {
		return "WishList [customerUserName= " + customerUserName + "," 
	+"catalogueId= " + catalogueId + ","
	+"wishQuantity= " + wishQuantity + "]";
	}

}
