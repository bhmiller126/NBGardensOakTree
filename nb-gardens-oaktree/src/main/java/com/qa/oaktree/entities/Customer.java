package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Id;
import javax.persistence.OneToOne; 

/**
 * Customer entity
 * @author OakTree LP
 *
 */
@NamedQueries({
	@NamedQuery(
	name = "findByUsernameAndPassword",
	query = "SELECT * FROM Customer WHERE user_name= :username AND password = :password"
	),
	@NamedQuery(
	name = "findByUsername",
	query = "SELECT * FROM Customer WHERE user_name = :username"
	)
})

@Entity
@Table (name = "Customer")
public class Customer {
	
	@Id
	@Column (name = "user_name", nullable = false, length = 225)
	private String userName;
	
	@Column (name = "title", nullable = false, length = 10)
	@NotNull
	@Size(min = 2, max = 10)
	private String title;
	
	@Column (name = "first_name", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 50)
	private String firstName;
	
	@Column (name = "last_name", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 50)
	private String lastName;
	
	@Column (name = "password", nullable = false, length = 225)
	@NotNull
	@Size(min = 6, max = 45)
	private String password;
	
	@Column (name = "date_of_birth", nullable = false, length = 225)
	@NotNull
	@Past
	private Date dateOfBirth;
	
	@Column (name = "gender", nullable = true)
	private boolean gender;

	@Column (name = "credit", nullable = false, length = 225)
	private BigDecimal credit;
	
	@Column (name = "email", nullable = true, length = 225)
	@Size(min = 8, max = 100)
	private String email;
	
	@Column (name = "contact_no", nullable = true, length = 225)
	@Size(min = 11, max = 11)
	private String contactNum;
	
	@Column (name = "status", nullable = false, length = 225)
	@Size(min = 4, max = 20)
	private String status;
	
	@Column (name = "secret_question", nullable = false, length = 225)
	@NotNull
	@Size(min = 5, max = 225)
	private String secretQuestion;
	
	@Column (name = "secret_answer", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 50)
	private String secretAnswer;
	
	@Column (name = "Address_line_1", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 45)
	private String addressLine1;

	@Column (name = "Address_Postcode", nullable = false, length = 225)
	@NotNull
	@Size(min = 5, max = 8)
	private String addressPostcode;
		
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
    private WishList wishList;	
	
	/**
	 * Default Null constructor for Customer 
	 */
	public Customer () {
		Calendar cal = Calendar.getInstance();
		this.userName = "";
		this.title = "";
		this.firstName = "";
		this.lastName = "";
		this.password = "";
		this.dateOfBirth = (Date) cal.getTime();
		this.gender = false;
		this.credit = new BigDecimal("");
		this.email = "";
		this.contactNum = "";
		this.status = "";
		this.secretQuestion = "";
		this.secretAnswer = "";
		this.addressLine1 = "";
		this.addressPostcode = "";
	}
	
	/**
	 * Full Constructor for Customer 
	 * @param userName String customers user name
	 * @param title String customers title
	 * @param firstName String customers first name
	 * @param lastName String customers last name
	 * @param password String customers password
	 * @param dateOfBirth String customers date of birth
	 * @param gender Boolean customers gender 1 = male 0 = female
	 * @param credit Float customers current credit level
	 * @param email String customers contact email address
	 * @param contactNum String customers contact number
	 * @param status String customers current status with NB Gardens
	 * @param secretQuestion String customers question to be asked when they have forgotten their password
	 * @param secretAnswer String customers answer to their security question 
	 * @param addressLine1 String customers first line of their address
	 * @param addressPostcode String customers postcode of their address
	 */
	public Customer(String userName, String title, String firstName, String lastName, String password,
			Date dateOfBirth, boolean gender, BigDecimal credit, String email, String contactNum, String status,
			String secretQuestion, String secretAnswer, String addressLine1, String addressPostcode) {
		this.userName = userName;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.credit = credit;
		this.email = email;
		this.contactNum = contactNum;
		this.status = status;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.addressLine1 = addressLine1;
		this.addressPostcode = addressPostcode;
	}

	/***************** getters and setters *****************/

	/**
	 * @return the wishList
	 */
	public WishList getWishList() {
		return wishList;
	}

	/**
	 * @param wishList the wishList to set
	 */
	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public boolean isGender() {
		return gender;
	}

	/**
	 * @return the credit
	 */
	public BigDecimal getCredit() {
		return credit;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the contactNum
	 */
	public String getContactNum() {
		return contactNum;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the secretQuestion
	 */
	public String getSecretQuestion() {
		return secretQuestion;
	}

	/**
	 * @return the secretAnswer
	 */
	public String getSecretAnswer() {
		return secretAnswer;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @return the addressPostcode
	 */
	public String getAddressPostcode() {
		return addressPostcode;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param contactNum the contactNum to set
	 */
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param secretQuestion the secretQuestion to set
	 */
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	/**
	 * @param secretAnswer the secretAnswer to set
	 */
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @param addressPostcode the addressPostcode to set
	 */
	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}

	/***************** equals and to string *****************/
	/** 
	 * Override equals method
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @return false if the customer other is different to this . customer 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressPostcode == null) {
			if (other.addressPostcode != null)
				return false;
		} else if (!addressPostcode.equals(other.addressPostcode))
			return false;
		if (contactNum == null) {
			if (other.contactNum != null)
				return false;
		} else if (!contactNum.equals(other.contactNum))
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (secretAnswer == null) {
			if (other.secretAnswer != null)
				return false;
		} else if (!secretAnswer.equals(other.secretAnswer))
			return false;
		if (secretQuestion == null) {
			if (other.secretQuestion != null)
				return false;
		} else if (!secretQuestion.equals(other.secretQuestion))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * Override object's toString method 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [userName=" + userName + 
				", title=" + title + 
				", firstName=" + firstName + 
				", lastName=" + lastName + 
				", password=" + password + 
				", dateOfBirth=" + dateOfBirth + 
				", gender=" + gender + 
				", credit=" + credit + 
				", email=" + email + 
				", contactNum=" + contactNum + 
				", status=" + status + 
				", secretQuestion=" + secretQuestion + 
				", secretAnswer=" + secretAnswer + 
				", addressLine1=" + addressLine1 + 
				", addressPostcode=" + addressPostcode + "]";
	}
}
