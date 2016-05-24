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

	/**
	 * Full constructor for payment method
	 * @param String cardNumber
	 * @param String cardType
	 * @param Date startDate
	 * @param Date expiryDate
	 * @param String nameOnCard
	 * @param String billingAddressLine1 from address
	 * @param String billingAddressPostcode from address
	 * @param String userName from customer
	 */
	
	
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


/**
 * get card number method
 * @return card number of payment method
 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * get card type method
	 * @return card type of payment method
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * get start date method
	 * @return start date of payment method
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * get expiry date method
	 * @return expiry date of payment method
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * get name on card method
	 * @return name on card of payment method
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * set username method
	 * @set the username in customer
	 */
	public void setUserName(Customer userName) {
		this.userName = userName;
	}

	/**
	 * get billing address line 1 method
	 * @return the billingAddressLine1
	 */
	public com.qa.oaktree.entities.Address getBillingAddressLine1() {
		return billingAddressLine1;
	}

	/**
	 * set billing addres line 1 method
	 * @set billingAddressLine1 of address
	 */
	public void setBillingAddressLine1(com.qa.oaktree.entities.Address billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}

	/**
	 * gte billing address postcode 
	 * @return the billingAddressPostcode of address
	 */
	public com.qa.oaktree.entities.Address getBillingAddressPostcode() {
		return billingAddressPostcode;
	}

	/**
	 * set billing address method
	 * @set billingAddressPostcode of address
	 */
	public void setBillingAddressPostcode(com.qa.oaktree.entities.Address billingAddressPostcode) {
		this.billingAddressPostcode = billingAddressPostcode;
	}

	/**
	 * set card number method
	 * @set cardNumber of payment method
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * set name on card method
	 * @set name on card of payment method
	 */
	
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * set cardtype method
	 * @set cardType of payment method
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * set start date method
	 * @set startDate of payment method
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * set expiry date method
	 * @set expiryDate of payment method
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/** 
	 * Override method for equlas to see if any of the data entered matches a record already in database
	 * false if payment method other is different to this.PaymentMethod
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMethod other = (PaymentMethod) obj;
		if (billingAddressLine1 == null) {
			if (other.billingAddressLine1 != null)
				return false;
		} else if (!billingAddressLine1.equals(other.billingAddressLine1))
			return false;
		if (billingAddressPostcode == null) {
			if (other.billingAddressPostcode != null)
				return false;
		} else if (!billingAddressPostcode.equals(other.billingAddressPostcode))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (nameOnCard == null) {
			if (other.nameOnCard != null)
				return false;
		} else if (!nameOnCard.equals(other.nameOnCard))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/** 
	 * Override to string method, 
	 */
	@Override
	public String toString() {
		return "PaymentMethod [userName= " + userName + "," 
				+ "cardNumber=" + cardNumber + "," 
				+ "nameOnCard= " + nameOnCard + "," 
				+ "cardType= " + cardType + "," 
				+ "startDate= " + startDate + "," 
				+ "expiryDate= " + expiryDate + ","
				+ "billingAddressLine1= " + billingAddressLine1 + "," 
				+ "billingAddressPostcode= " + billingAddressPostcode
				+ "]";
	}

}
