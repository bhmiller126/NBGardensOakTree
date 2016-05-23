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
	 * This method is the constructor for this class. It will take the later mentioned 
	 * parameters and assign them to the corresponding class variables for the particular instance.
 	 * @param catalogue_id
	 * @param product_name
	 * @param product_description
	 * @param product_category
	 * @param product_status
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
	 * This method is the "getter" for the String representing product status.
	 * @return
	 */
	public String getProduct_status()
	{return product_status;}

	/**
	 * This method is the "setter" for the String representing product status.
	 * @param product_status
	 */
	public void setProduct_status(String product_status)
	{this.product_status = product_status;}

	/**
	 * This method is the "getter" for the integer representing the product's catalogue id.
	 * This variable is the Primary Key.
	 * @return
	 */
	public int getCatalogue_id() 
	{return catalogue_id;}

	/**
	 * This method is the "setter" for the integer representing the product's catalogue id.
	 * @param catalogue_id
	 */
	public void setCatalogue_id(int catalogue_id) 
	{this.catalogue_id = catalogue_id;}

	/**
	 * This method is the "getter" for the String representing the product's name.
	 * @return
	 */
	public String getProduct_name() 
	{return product_name;}

	/**
	 * This method is the "setter" for the String representing the product's name.
	 * @param product_name
	 */
	public void setProduct_name(String product_name) 
	{this.product_name = product_name;}

	/**
	 * This method is the "getter" for the String representing the product's description.
	 * @return
	 */
	public String getProduct_description() 
	{return product_description;}

	/**
	 * This method is the "setter" for the String representing the product's description.
	 * @param product_description
	 */
	public void setProduct_description(String product_description) 
	{this.product_description = product_description;}

	/**
	 * This method is the "getter" for the String representing the product's category.
	 * @return
	 */
	public String getProduct_category()
	{return product_category;}

	/**
	 * This method is the "setter" for the String representing the product's description.
	 * @param product_category
	 */
	public void setProduct_category(String product_category) 
	{this.product_category = product_category;}
	
}
