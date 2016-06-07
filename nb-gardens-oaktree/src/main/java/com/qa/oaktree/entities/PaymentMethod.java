package com.qa.oaktree.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 
 * @author OakTree Payment Method SQl entity
 */
public class PaymentMethod {

	@Id @GeneratedValue (generator = "customer") //PK auto generator for sales orders
	@GenericGenerator(name = "customer", strategy = "foreign", 
	parameters = { @Parameter(value = "customer", name = "property")})
	@Column (name = "user_name")
	private String userName;
		
	@ManyToOne (cascade = CascadeType.ALL)
	private Customer customer;
	
	@Id
	@Column(name = "card_number", length = 16)
	@Size(min = 16, max = 16)
	private String cardNumber;

	@Column(name = "name_on_card", length = 45)
	@Size(min = 1, max = 45)
	private String nameOnCard;

	@Column(name = "card_type", length = 45)
	@Size(min = 1, max = 45)
	private String cardType;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "Address_Line_1", length = 45)
	@Size(min = 1, max = 45)
	private String billingAddressLine1;

	@Column(name = "Address_post_code", length = 8)
	@Size(min = 6, max = 8)
	private String billingAddressPostcode;

	///////////////////////////////////////
	
	/**
	 * 
	 */
	public PaymentMethod() {}

	/**
	 * @param userName
	 * @param customer
	 * @param cardNumber
	 * @param nameOnCard
	 * @param cardType
	 * @param startDate
	 * @param expiryDate
	 * @param billingAddressLine1
	 * @param billingAddressPostcode
	 */
	public PaymentMethod(String userName, Customer customer, String cardNumber, String nameOnCard, String cardType,
			Date startDate, Date expiryDate, String billingAddressLine1, String billingAddressPostcode) {
		super();
		this.userName = userName;
		this.customer = customer;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.cardType = cardType;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.billingAddressLine1 = billingAddressLine1;
		this.billingAddressPostcode = billingAddressPostcode;
	}

	///////////////////////////////////////////////
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return the nameOnCard
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @return the billingAddressLine1
	 */
	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}

	/**
	 * @return the billingAddressPostcode
	 */
	public String getBillingAddressPostcode() {
		return billingAddressPostcode;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @param nameOnCard the nameOnCard to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @param billingAddressLine1 the billingAddressLine1 to set
	 */
	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}

	/**
	 * @param billingAddressPostcode the billingAddressPostcode to set
	 */
	public void setBillingAddressPostcode(String billingAddressPostcode) {
		this.billingAddressPostcode = billingAddressPostcode;
	}
}