package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import java.sql.Date;

/**
 * 
 * @author OakTree SB
 * Address noSQL entity
 */
@Entity
@Table(name = "PaymentTransaction")
public class PaymentTransaction {
	
	@Column(name = "transactionID")
	private int transactionID;
	
	@Column(name = "paymentMethod")
	private PaymentMethod paymentMethod;
	
	@Column(name = "cardCVC2")
	private String cardCVC2;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "amount")
	private double amount;
	
	/**
	 * Null constructor for Payment Transaction
	 * I am unsure about how to set some of the variables atm, SB 
	 */
	//public PaymentTransaction() {
	//	this.transactionID = 0;
	//	this.paymentMethod = 0;
	//	this.date = "";
	//	this.amount = "";
	//	this.cardCVC2 = "";
	//}
	
	/**
	 * constructor for PaymentTransaction entity? I'm not why there are two with different parameters, SB
	 * @param paymentMethod
	 * @param cardCVC2
	 * @param date
	 * @param amount
	 */
	public PaymentTransaction(PaymentMethod paymentMethod, String cardCVC2, Date date, double amount) {
		super();
		this.paymentMethod = paymentMethod;
		this.cardCVC2 = cardCVC2;
		this.date = date;
		this.amount = amount;
	}


	public PaymentTransaction(int transactionID, PaymentMethod paymentMethod, Date date, double amount) {
		super();
		this.transactionID = transactionID;
		this.paymentMethod = paymentMethod;
		this.date = date;
		this.amount = amount;
	}


	/**
	 * transactionID getter method
	 * @return transactionID
	 */
	public int getTransactionID() {
		return transactionID;
	}

	/**
	 * transactionID setter method
	 * @param transactionID
	 */
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	/**
	 * PaymentMethod getter method
	 * @return payment method used
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * PaymentMethod setter method
	 * @param paymentMethod
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	/**
	 * cardCVC2 getter method
	 * @return cardCVC2
	 */
	public String getCardCVC2() {
		return cardCVC2;
	}

	/**
	 * cardCVC2 setter method
	 * @param cardCVC2
	 */
	public void setCardCVC2(String cardCVC2) {
		this.cardCVC2 = cardCVC2;
	}

	/**
	 * date getter method
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * date setter method
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * transaction amount getter method
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * transaction amount setter method
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Override object equals method for PaymentTransaction entity
	 *  @param other PaymentTransaction to be checked against
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentTransaction other = (PaymentTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (cardCVC2 == null) {
			if (other.cardCVC2 != null)
				return false;
		} else if (!cardCVC2.equals(other.cardCVC2))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (transactionID != other.transactionID)
			return false;
		return true;
	}


	/**
	 * Override object's toString method for PaymentTransaction
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentTransaction [transactionID=" + transactionID + ", paymentMethod=" + paymentMethod + ", cardCVC2="
				+ cardCVC2 + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
	
}
