package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

/**
 * 
 * @author OakTree Bryony & LP
 * WishList SQL Entity. This attaining the relevant Stock item from one to one
 * cardinality and is associated to one Customer who holds the WishList in an Array
 * List. 
 * 
 */
@Entity
@Table(name = "Wishlist")
public class WishList {

	/**
	 * This section adds customer username and uses it as a foreign key from the
	 * customer table with one to one cardinality Added the getter within here
	 * so the column knows to access getCustomerUserName. The getter will return
	 * the customer username stored in the database copied the format for this
	 * from online, sure if this is std practice
	 * 
	 * name = "Customer_user_name" should match the name of the table specified
	 * in the database so it knows what to access the foreign key from 
	 */
	@ManyToOne
	@JoinColumn(name = "Customer_user_name", nullable = false)
	private Customer customer;

	/**
	 * This adds stock catalogue as a foreign key, similar to customer
	 * username above This is a many to one cardinality The name = has to match
	 * the name of the table created in the database
	 */
	@OneToOne (mappedBy = "stock", cascade = CascadeType.ALL)
	private Stock stock; 

	/**
	 * columnDefinition = "int default '1'" this should make sure that if the
	 * customer does not insert a quanity within the wishlist it will place 1 in
	 * there instead
	 */
	@Column(name = "wish_quantity", columnDefinition = "int default '1'")
	private int wishQuantity;

	/**
	 * Default null constructor for wishlist entity 
	 * quantity has a default setting
	 * of 1
	 * @param wishQuantity
	 */
	public WishList() {
		this.wishQuantity = 1;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @return the wishQuantity
	 */
	public int getWishQuantity() {
		return wishQuantity;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * @param wishQuantity the wishQuantity to set
	 */
	public void setWishQuantity(int wishQuantity) {
		this.wishQuantity = wishQuantity;
	}

	/** 
	 * override Object.equals for wishlist
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
		WishList other = (WishList) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (wishQuantity != other.wishQuantity)
			return false;
		return true;
	}

	/**
	 * Override Object.toString for wishlist 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WishList [customer=" + customer + ", stock=" + stock + ", wishQuantity=" + wishQuantity + "]";
	}
}
