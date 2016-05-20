package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 

public class WishList {
	private int customerUserName; 
	private int stockCatalogueId; 
	private int wishQuantity; 
	
	public WishList (int customerUserName, int stockCatalogueId, int wishQuantity) {
		this.customerUserName = customerUserName; 
		this.stockCatalogueId= stockCatalogueId; 
		this.wishQuantity= wishQuantity; 
	}

	public int getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(int customerUserName) {
		this.customerUserName = customerUserName;
	}

	public int getStockCatalogueId() {
		return stockCatalogueId;
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
