package com.qa.oaktree.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Wishlist")
public class WishList {

	// This section adds customer username and uses it as a foreign key from the
	// customer table
	// Added the getter within here so the column knows to access
	// getCustomerUserName.
	// copied the format for this from online, usure if this is std practice

	// TODO check that the cardinallities are correct for annotations

	@OneToOne
	@JoinColumn(name = "Customer_user_name", nullable = false)

	public int getCustomerUserName() {
		return customerUserName;
	}

	@NotNull
	private int customerUserName;

	// This section adds stock catalogue as a foreign key, similar to customer
	// username above
	// The name = has to match the name of the table created in the database

	@ManyToOne
	@JoinColumn(name = "Stock_catalogue_id", nullable = false)
	public int getStockCatalogueId() {
		return stockCatalogueId;
	}

	@NotNull
	private int stockCatalogueId;

	// The below section will add the wish quanity column and default value of 1
	// this will happen when no quantity is selected by user
	// Not sure if it will work as setting default but will look into it further
	// for other cases
	// TODO look int setting default values

	@Column(name = "wish_quantity", columnDefinition = "int default '1'")
	private int wishQuantity;

	public WishList(int customerUserName, int stockCatalogueId, int wishQuantity) {
		this.customerUserName = customerUserName;
		this.stockCatalogueId = stockCatalogueId;
		this.wishQuantity = wishQuantity;
	}

	public void setCustomerUserName(int customerUserName) {
		this.customerUserName = customerUserName;
	}

	public void setStockCatalogueId(int stockCatalogueId) {
		this.stockCatalogueId = stockCatalogueId;
	}

	public int getWishQuantity() {
		return wishQuantity;
	}

	public void setWishQuantity(int wishQuantity) {
		this.wishQuantity = wishQuantity;
	}

}
