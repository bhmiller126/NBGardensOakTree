package com.qa.oaktree.entities;

public class Customer 
{
	private String user_name;
	private String title;
	private String first_name;
	private String last_name;
	private String password;
	private String date_of_birth;  
	private String email;
	private String contact_no;
	private String status;
	private String secret_question;
	private String secret_answer;
	private String address_line_1;
	private String address_postcode;
	private boolean gender;
	private float credit;
	
	public Customer(String user_name, String title, String first_name, String last_name, String password, String date_of_birth, String email, String contact_no, String status, String secret_question, String secret_answer, String address_line_1, String address_postcode, boolean gender, float credit)
	{
		this.user_name = user_name;
		this.title = title;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.contact_no = contact_no;
		this.status = status;
		this.secret_question = secret_question;
		this.secret_answer = secret_answer;
		this.address_line_1 = address_line_1;
		this.address_postcode = address_postcode;
		this.gender = gender;
		this.credit = credit;
	}

	public String getUser_name() 
	{return user_name;}

	public void setUser_name(String user_name) 
	{this.user_name = user_name;}

	public String getTitle() 
	{return title;}

	public void setTitle(String title) 
	{this.title = title;}

	public String getFirst_name() 
	{return first_name;}

	public void setFirst_name(String first_name) 
	{this.first_name = first_name;}

	public String getLast_name() 
	{return last_name;}

	public void setLast_name(String last_name) 
	{this.last_name = last_name;}

	public String getPassword() 
	{return password;}

	public void setPassword(String password) 
	{this.password = password;}

	public String getDate_of_birth() 
	{return date_of_birth;}

	public void setDate_of_birth(String date_of_birth) 
	{this.date_of_birth = date_of_birth;}

	public String getEmail() 
	{return email;}

	public void setEmail(String email) 
	{this.email = email;}

	public String getContact_no() 
	{return contact_no;}

	public void setContact_no(String contact_no) 
	{this.contact_no = contact_no;}

	public String getStatus() 
	{return status;}

	public void setStatus(String status) 
	{this.status = status;}

	public String getSecret_question() 
	{return secret_question;}

	public void setSecret_question(String secret_question) 
	{this.secret_question = secret_question;}

	public String getSecret_answer() 
	{return secret_answer;}

	public void setSecret_answer(String secret_answer) 
	{this.secret_answer = secret_answer;}

	public String getAddress_line_1() 
	{return address_line_1;}

	public void setAddress_line_1(String address_line_1) 
	{this.address_line_1 = address_line_1;}

	public String getAddress_postcode() 
	{return address_postcode;}

	public void setAddress_postcode(String address_postcode) 
	{this.address_postcode = address_postcode;}

	public boolean isGender() 
	{return gender;}

	public void setGender(boolean gender) 
	{this.gender = gender;}

	public float getCredit() 
	{return credit;}

	public void setCredit(float credit) 
	{this.credit = credit;}
	
}
