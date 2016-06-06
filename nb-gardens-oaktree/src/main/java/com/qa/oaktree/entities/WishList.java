package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.JoinColumn;

/**
 * 
 * @author OakTree Bryony & LP & Barry
 * WishList SQL Entity. This attaining the relevant Stock item from one to one
 * cardinality and is associated to one Customer who holds the WishList in an Array
 * List. 
 * 
 */
@NamedQueries({
	@NamedQuery(
			name = "displayWishlist",
			query = "SELECT * from Wishlist WHERE user_name = :username")
})

@Entity
@Table(name = "wishlist")
public class WishList {

	@Id
	@Column(name = "Customer_user_name", nullable = false, updatable = false)
	@GeneratedValue(generator="foreign-gen")
    @GenericGenerator(name="foreign-gen", strategy="foreign", 
    		parameters = @Parameter(name="property", value="customer"))
	private String customerUserName;
	
	@ManyToOne
	@JoinColumn(name = "stock", nullable = false, updatable = false)
	private Stock Stock_catalog_id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Customer customer;
	
	@Column (name = "wish_quantity")
	private int wishQuantity;

	public WishList() {
	}
	
	/**
	 * @param customerUserName
	 * @param stock_catalog_id
	 * @param customer
	 * @param wishQuantity
	 */
	public WishList(String customerUserName, Stock stock_catalog_id, Customer customer, int wishQuantity) {
		super();
		this.customerUserName = customerUserName;
		Stock_catalog_id = stock_catalog_id;
		this.customer = customer;
		this.wishQuantity = wishQuantity;
	}

	/**************** getters and setters ******************/
	/**
	 * @return the customerUserName
	 */
	public String getCustomerUserName() {
		return customerUserName;
	}

	/**
	 * @return the stock_catalog_id
	 */
	public Stock getStock_catalog_id() {
		return Stock_catalog_id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the wishQuantity
	 */
	public int getWishQuantity() {
		return wishQuantity;
	}

	/**
	 * @param customerUserName the customerUserName to set
	 */
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	/**
	 * @param stock_catalog_id the stock_catalog_id to set
	 */
	public void setStock_catalog_id(Stock stock_catalog_id) {
		Stock_catalog_id = stock_catalog_id;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param wishQuantity the wishQuantity to set
	 */
	public void setWishQuantity(int wishQuantity) {
		this.wishQuantity = wishQuantity;
	}
}
