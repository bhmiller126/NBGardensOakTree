package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column; 
import javax.persistence.Id; 

/**
 * 
 * @author StephenB 
 * Address noSQL entity
 */
@Entity
@Table (name = "Product")
public class Product 
{
	@Id
	@Column (name = "catalogue_id", nullable = false, length = 225)
	private int catalogueId;
	
	@Column (name = "product_name", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String productName;
	
	@Column (name = "product_description", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String productDescription;
	
	@Column (name =  "product_category", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String productCategory;
	
	@Column (name = "product_status", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String productStatus;

	/**
	 * Null constructor for Product 
	 * @param string4 
	 * @param string3 
	 * @param string2 
	 * @param sinttring 
	 * @param i 
	 */
	public Product() {
		this.catalogueId = 0;
		this.productName = "";
		this.productDescription = "";
		this.productCategory = "";
		this.productStatus = "";
	}
	
	/**
	 * Full Constructor for Product entity. 
	 * @param catalogueId 
	 * @param productCategory 
	 * @param productDescription 
	 * @param productName 
	 * @param productStatus 
 	 * @param catalogue_id, product's number in catalogue
	 * @param product_name, product's name
	 * @param product_description, a description of the product
	 * @param product_category, product's category grouping it with like products
	 * @param product_status, product's status as to whether it is discontinued, on order, in stock or back order
	 */
	public Product(int catalogueId, String productCategory, String productDescription, String productName, String productStatus)
	{
		this.catalogueId = catalogueId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
		this.productStatus = productStatus;
	}

	/**
	 * getter method for product's status.
	 * @return product's status
	 */
	public String getProductStatus()
	{return productStatus;}

	/**
	 * setter method for product's status.
	 * @param product_status
	 */
	public void setProductStatus(String product_status)
	{this.productStatus = product_status;}

	/**
	 * getter method for product's catalogue id.
	 * This variable is the Primary Key.
	 * @return catalogue_id
	 */
	public int getCatalogueId() 
	{return catalogueId;}

	/**
	 * setter method for product's catalogue id.
	 * This variable is the Primary Key
	 * @param catalogue_id
	 */
	public void setCatalogueId(int catalogue_id) 
	{this.catalogueId = catalogue_id;}

	/**
	 * getter method for the product's name.
	 * @return product_name
	 */
	public String getProductName() 
	{return productName;}

	/**
	 * setter method for the product's name.
	 * @param product_name
	 */
	public void setProductName(String product_name) 
	{this.productName = product_name;}

	/**
	 * getter method for the product's description.
	 * @return product_description
	 */
	public String getProductDescription() 
	{return productDescription;}

	/**
	 * setter method for the product's description.
	 * @param product_description
	 */
	public void setProductDescription(String product_description) 
	{this.productDescription = product_description;}

	/**
	 * getter method for the product's category.
	 * @return product_category
	 */
	public String getProductCategory()
	{return productCategory;}

	/**
	 * setter method for the product's description.
	 * @param product_category
	 */
	public void setProductCategory(String product_category) 
	{this.productCategory = product_category;}

	/**
	 * Override object equals method for Product entity
	 * @param other Product to be checked against
	 * @return boolean true if products' are the same
	 */
	public boolean equals(Product other)
	{
		if(this.catalogueId == other.getCatalogueId() && this.productName.equals(other.getProductCategory()) && this.productDescription.equals(other.getProductDescription()) && this.productCategory.equals(other.getProductCategory()) && this.productStatus.equals(other.getProductStatus()))
		{return true;}
		else
		{return false;}
	}

	/** 
	 * Override object's toString method for Products
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [catalogue_id=" + catalogueId + ", product_name=" + productName + ", product_description="
				+ productDescription + ", product_category=" + productCategory + ", product_status=" + productStatus
				+ "]";
	}
	
	
}
