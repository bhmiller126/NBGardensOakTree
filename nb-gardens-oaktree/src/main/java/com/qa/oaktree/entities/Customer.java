package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import java.sql.Date;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 

@Entity
@Table (name = "Customer")
public class Customer {
	
	@Id
	@Column (name = "userName", nullable = false, length = 225)
	private String userName;
	
	@Column (name = "title", nullable = false, length = 10)
	@NotNull
	@Size(min = 2, max = 10)
	private String title;
	
	@Column (name = "firstName", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String firstName;
	
	@Column (name = "lastName", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String lastName;
	
	@Column (name = "password", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String password;
	
	@Column (name = "dateOfBirth", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String dateOfBirth;
	
	@Column (name = "email", nullable = true, length = 225)
	@Size(min = 2, max = 225)
	private String email;
	
	@Column (name = "contactNo", nullable = true, length = 225)
	@Size(min = 2, max = 225)
	private String contactNo;
	
	@Column (name = "status", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String status;
	
	@Column (name = "secretQuestion", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String secretQuestion;
	
	@Column (name = "secretAnswer", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String secretAnswer;
	
	@Column (name = "addressLine1", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String addressLine1;

	@Column (name = "addressPostcode", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String addressPostcode;
	
	@Column (name = "gender", nullable = true)
	private boolean gender;
	
	@Column (name = "credit", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private float credit;

	public Customer(String userName, String title, String firstName, String lastName, String password,
			String dateOfBirth, String email, String contactNo, String status, String secretQuestion,
			String secretAnswer, String addressLine1, String addressPostcode, boolean gender, float credit) {
		this.userName = userName;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.contactNo = contactNo;
		this.status = status;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.addressLine1 = addressLine1;
		this.addressPostcode = addressPostcode;
		this.gender = gender;
		this.credit = credit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressPostcode() {
		return addressPostcode;
	}

	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}
}
