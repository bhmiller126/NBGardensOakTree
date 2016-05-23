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
import javax.persistence.JoinColumn; 

/**
 * 
 * @author OakTree 
 * Address noSQL entity
 */
@Entity
@Table (name = "Product")
public class Product 
{
	@Id
	@Column (name = "catalogue_id", nullable = false, length = 225)
	private int catalogue_id;
	
	@Column (name = "product_name", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String product_name;
	
	@Column (name = "product_description", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String product_description;
	
	@Column (name =  "product_category", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String product_category;
	
	@Column (name = "product_status", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String product_status;

	/**
	 * Full Constructor for Product entity. 
 	 * @param catalogue_id, product's number in catalogue
	 * @param product_name, product's name
	 * @param product_description, a description of the product
	 * @param product_category, product's category grouping it with like products
	 * @param product_status, product's status as to whether it is discontinued, on order, in stock or back order
	 */
	public Product(int catalogue_id, String product_name, String product_description, String product_category, String product_status)
	{
		this.catalogue_id = catalogue_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_category = product_category;
		this.product_status = product_status;
	}

	/**
	 * getter method for product's status.
	 * @return product's status
	 */
	public String getProduct_status()
	{return product_status;}

	/**
	 * setter method for product's status.
	 * @param product_status
	 */
	public void setProduct_status(String product_status)
	{this.product_status = product_status;}

	/**
	 * getter method for product's catalogue id.
	 * This variable is the Primary Key.
	 * @return catalogue_id
	 */
	public int getCatalogue_id() 
	{return catalogue_id;}

	/**
	 * setter method for product's catalogue id.
	 * This variable is the Primary Key
	 * @param catalogue_id
	 */
	public void setCatalogue_id(int catalogue_id) 
	{this.catalogue_id = catalogue_id;}

	/**
	 * getter method for the product's name.
	 * @return product_name
	 */
	public String getProduct_name() 
	{return product_name;}

	/**
	 * setter method for the product's name.
	 * @param product_name
	 */
	public void setProduct_name(String product_name) 
	{this.product_name = product_name;}

	/**
	 * getter method for the product's description.
	 * @return product_description
	 */
	public String getProduct_description() 
	{return product_description;}

	/**
	 * setter method for the product's description.
	 * @param product_description
	 */
	public void setProduct_description(String product_description) 
	{this.product_description = product_description;}

	/**
	 * getter method for the product's category.
	 * @return product_category
	 */
	public String getProduct_category()
	{return product_category;}

	/**
	 * setter method for the product's description.
	 * @param product_category
	 */
	public void setProduct_category(String product_category) 
	{this.product_category = product_category;}
	
	public boolean equals(Product other)
	{
		if(this.catalogue_id == other.getCatalogue_id() && this.product_name.equals(other.getProduct_name()) && this.product_description.equals(other.getProduct_description()) && this.product_category.equals(other.getProduct_category()) && this.product_status.equals(other.getProduct_status()))
		{return true;}
		else
		{return false;}
	}
}
