package com.qa.oaktree.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author OakTree Payment Method SQl entity
 */
public class PaymentMethod {

	/**
	 * One to many dictates the cardinality It joins to customer column to
	 * access username
	 * 
	 * @return customer username in the get username method
	 */
	@OneToMany
	@JoinColumn(name = "Customer", nullable = false)
	public String getUserName() {
		return getUserName();
	}

	@NotNull
	private com.qa.oaktree.entities.Customer userName;
	/**
	 * card number is the primary key of this entity as it is unique identifier with forgein key customer username
	 * has a minimum and maximum value of 16 as all card numbers must have 16 digits
	 */
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
	private com.qa.oaktree.entities.Address billingAddressLine1;

	@Column(name = "Address_post_code", length = 8)
	@Size(min = 6, max = 8)
	private com.qa.oaktree.entities.Address billingAddressPostcode;
	
/**
 * Null constuctor for payment method 
 */
	public PaymentMethod() {
		this.userName = null; 
		this.cardNumber = "0"; 
		this.nameOnCard = ""; 
		this.cardType = ""; 
		this.startDate = new Date(0); 
		this.expiryDate = new Date (0); 
		this.billingAddressLine1 = null; 
		this.billingAddressPostcode = null; 
		
	}
	
	
	
	public PaymentMethod(String cardNumber, String cardType, Date startDate, Date expiryDate, String nameOnCard,
			Address billingAddressLine1, Address billingAddressPostcode, Customer userName) {
		super();
		this.userName = userName;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.cardType = cardType;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.billingAddressLine1 = billingAddressLine1;
		this.billingAddressPostcode = billingAddressPostcode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public Address getPaymentAddress() {
		return billingAddressLine1;
	}

	public void setUserName(Customer userName) {
		this.userName = userName;
	}

}
