package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 

/**
 * 
 * @author OakTree LP
 * Address noSQL entity
 */
@Entity
@Table(name = "Address")
public class Address 
{
	@Column(name = "line_1")
	private String line1;
	
	@Column(name = "line_2")
	private String line2;
	
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
	private String homePhoneNumber;
	
	/**
	 * Null constructer for Address 
	 */
	public Address() {
		this.line1 = "";
		this.line2 = "";
		this.town = "";
		this.city = "";
		this.county = "";
		this.country = "";
		this.postcode = "";
		this.homePhoneNumber = "";
	}
	/**
	 * Full constructor for Address entity
	 * @param line1, address line 1, house name or postcode
	 * @param line2, address line 2, nullable
	 * @param town, address town
	 * @param city, address city 
	 * @param county, address county 
	 * @param country, country of address
	 * @param postcode, address postcode 
	 * @param home_phone_number, contact number for address, nullable
	 */
	public Address(String line1, String line2, String town, String city, String county, String country, String postcode, String homePhoneNumber) {
		this.line1 = line1;
		this.line2 = line2;
		this.town = town;
		this.city = city;
		this.county = county;
		this.country = country;
		this.postcode = postcode;
		this.homePhoneNumber = homePhoneNumber;
	}

	/**
	 * Address line 1 getter method
	 * @return line 1 of Address
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * Address line 2 getter method
	 * @return line 2 of Address 
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * Address town getter
	 * @return town of Address
	 */
	public String getTown() {
		return town;
	}

	/**
	 * Address city getter
	 * @return city of Address
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Address county getter method
	 * @return county of Address
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * Address country getter method
	 * @return country of Address
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Address postcode getter method
	 * @return postcode of Address
	 */
	public String getPostcode() {
		return postcode;
	}
	
	/**
	 * Address phone number getter method
	 * @return phone numer of Address
	 */
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	
	/**
	 * Address line 1 setter 
	 * @param line_1 String to set as address line 1
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * Address line 2 setter 
	 * @param line_2 String to set as address line 2
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * Address town setter 
	 * @param town String to set as address town 
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * Address city setter 
	 * @param city String to set as address city 
	 */
	public void setCity(String city) 
	{this.city = city;}

	/**
	 * Address county setter 
	 * @param county String to set as address county
	 */	public void setCounty(String county) 
	{this.county = county;}

	/**
	 * Address country setter 
	 * @param country String to set as address country
	 */
	 public void setCountry(String country) 
	{this.country = country;}


	/**
	 * Address postcode setter 
	 * @param postcode String to set as address postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * Address homePhoneNumber setter 
	 * @param homePhoneNumber String to set as address homePhoneNumber
	 */
	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}
	
	/**
	 * Override object equals method for Address entity
	 * @param other Address to be checked against
	 * @return boolean true if address' are the same
	 */
	public boolean equals(Address other) {
		if (this.line1.equals(other.getLine1()) &&
				this.line2.equals(other.getLine2()) &&
				this.town.equals(other.getTown()) &&
				this.city.equals(other.getCity()) &&
				this.county.equals(other.getCounty()) &&
				this.postcode.equals(other.getPostcode()) &&
				this.country.equals(other.getCountry()) &&
				this.homePhoneNumber.equals(other.getHomePhoneNumber())) {
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * Override object's toString method for Address
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [line1=" + line1 + 
				", line2=" + line2 + 
				", town=" + town + 
				", city=" + city + 
				", county=" + county + 
				", country=" + country + 
				", postcode=" + postcode + 
				", homePhoneNumber=" + homePhoneNumber + "]";
	}
}
