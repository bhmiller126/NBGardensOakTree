package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 

@Entity
@Table(name = "Address")
public class Address 
{
	@Column(name = "line_1")
	private String line_1;
	
	@Column(name = "line_2")
	private String line_2;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "county")
	private String county;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "home_phone_number")
	private String home_phone_number;
	
	public Address(String line_1, String line_2, String town, String city, String county, String country, String postcode, String home_phone_number)
	{
		this.line_1 = line_1;
		this.line_2 = line_2;
		this.town = town;
		this.city = city;
		this.county = county;
		this.country = country;
		this.postcode = postcode;
		this.home_phone_number = home_phone_number;
	}

	public String getLine_1() 
	{return line_1;}

	public void setLine_1(String line_1) 
	{this.line_1 = line_1;}

	public String getLine_2() 
	{return line_2;}

	public void setLine_2(String line_2) 
	{this.line_2 = line_2;}

	public String getTown() 
	{return town;}

	public void setTown(String town)
	{this.town = town;}

	public String getCity() 
	{return city;}

	public void setCity(String city) 
	{this.city = city;}

	public String getCounty() 
	{return county;}

	public void setCounty(String county) 
	{this.county = county;}

	public String getConutry() 
	{return country;}

	public void setConutry(String country) 
	{this.country = country;}

	public String getPostcode()
	{return postcode;}

	public void setPostcode(String postcode) 
	{this.postcode = postcode;}

	public String getHome_phone_number() 
	{return home_phone_number;}

	public void setHome_phone_number(String home_phone_number)
	{this.home_phone_number = home_phone_number;}	
	
}
