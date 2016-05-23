package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 

/**
 * 
 * @author StephenB 
 * Address noSQL entity
 */
@Entity
@Table (name = "Employee")
public class Employee 
{
	@Id
	@Column (name = "employee_name", nullable = false, length = 225)
	private String employee_name;

	@Column (name = "employee_username", nullable = false, length = 225)	
	private String employee_username;
	
	@Column (name = "employee_password", nullable = false, length = 225)
	private String employee_password;
	
	@Column (name = "employee_department", nullable = false, length = 225)
	private String employee_department;
	
	@Column (name = "employee_access", nullable = false, length = 225)
	private int employee_access;
	
	@Column (name = "employee_secret_question", nullable = false, length = 225)
	private String employee_secret_question;
	
	@Column (name = "employee_secret_answer", nullable = false, length = 225)
	private String employee_secret_answer;
	
	/**
	 * Null constructor for Employee 
	 */
	public Employee() {
		this.employee_name = "";
		this.employee_username = "";
		this.employee_password = "";
		this.employee_department = "";
		this.employee_access = 0;
		this.employee_secret_question = "";
		this.employee_secret_answer = "";
	}
	
	/**
	 * Full constructor for Employee entity
	 * @param employee_name, employee's name
	 * @param employee_username, employee's username
	 * @param employee_password, employee's password
	 * @param employee_department, employee's department
	 * @param employee_access, employee's access level
	 * @param employee_secret_question, employee's secret question
	 * @param employee_secret_answer, employee's secret answer to their secret question
	 */
	public Employee(String employee_name, String employee_username, String employee_password, String employee_department, int employee_access,
					String employee_secret_question, String employee_secret_answer)
	{
		this.employee_name = employee_name;
		this.employee_username = employee_username;
		this.employee_password = employee_password;
		this.employee_department = employee_department;
		this.employee_access = employee_access;
		this.employee_secret_question = employee_secret_question;
		this.employee_secret_answer = employee_secret_answer;
	}

	/**
	 * getter method for employee's name
	 * @return employee_name
	 */
	public String getEmployee_name() 
	{return employee_name;}
	
	/**
	 * setter method for employee's name
	 *  @param employee_name
	 */
	public void setEmployee_name(String employee_name) 
	{this.employee_name = employee_name;}

	/**
	 * getter method for employee's username
	 * @return employee_username
	 */
	public String getEmployee_username() 
	{return employee_username;}
	
	/**
	 * setter method for employee's username
	 * @param employee_username
	 */
	public void setEmployee_username(String employee_username)
	{this.employee_username = employee_username;}

	/**
	 * getter method for employee's password
	 * @return employee_password
	 */
	public String getEmployee_password() 
	{return employee_password;}
	
	/**
	 * setter method for employee's password
	 * @param employee_password
	 */
	public void setEmployee_password(String employee_password) 
	{this.employee_password = employee_password;}

	/**
	 * getter method for employee's department
	 * @return employee_deparment
	 */
	public String getEmployee_department()
	{return employee_department;}
	
	/**
	 * setter method for employee's department
	 * @param employee_deparment
	 */
	public void setEmployee_department(String employee_department) 
	{this.employee_department = employee_department;}

	/**
	 * getter method for employee's access level 
	 * @return employee_access
	 */
	public int getEmployee_access() 
	{return employee_access;}
	
	/**
	 * setter method for employee's access level 
	 * @param employee_access
	 */
	public void setEmployee_access(int employee_access) 
	{this.employee_access = employee_access;}

	/**
	 * getter method for employee's secret question
	 * @return employee_secret_question
	 */
	public String getEmployee_secret_question() 
	{return employee_secret_question;}
	
	/**
	 * setter method for employee's secret question
	 * @param employee_secret_question
	 */
	public void setEmployee_secret_question(String employee_secret_question) 
	{this.employee_secret_question = employee_secret_question;}

	/**
	 * getter method for employee's secret answer
	 * @return employee_secret_answer
	 */
	public String getEmployee_secret_answer() 
	{return employee_secret_answer;}
	
	/**
	 * setter method for employee's secret answer
	 * @param employee_secret_answer
	 */
	public void setEmployee_secret_answer(String employee_secret_answer) 
	{this.employee_secret_answer = employee_secret_answer;}

	/**
	 * Override object equals method for Employee entity
	 * @param other Employee to be checked against
	 * @return boolean true if Employees' are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employee_access != other.employee_access)
			return false;
		if (employee_department == null) {
			if (other.employee_department != null)
				return false;
		} else if (!employee_department.equals(other.employee_department))
			return false;
		if (employee_name == null) {
			if (other.employee_name != null)
				return false;
		} else if (!employee_name.equals(other.employee_name))
			return false;
		if (employee_password == null) {
			if (other.employee_password != null)
				return false;
		} else if (!employee_password.equals(other.employee_password))
			return false;
		if (employee_secret_answer == null) {
			if (other.employee_secret_answer != null)
				return false;
		} else if (!employee_secret_answer.equals(other.employee_secret_answer))
			return false;
		if (employee_secret_question == null) {
			if (other.employee_secret_question != null)
				return false;
		} else if (!employee_secret_question.equals(other.employee_secret_question))
			return false;
		if (employee_username == null) {
			if (other.employee_username != null)
				return false;
		} else if (!employee_username.equals(other.employee_username))
			return false;
		return true;
	}

	/** 
	 * Override object's toString method for Employee
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employee_name=" + employee_name + ", employee_username=" + employee_username
				+ ", employee_password=" + employee_password + ", employee_department=" + employee_department
				+ ", employee_access=" + employee_access + ", employee_secret_question=" + employee_secret_question
				+ ", employee_secret_answer=" + employee_secret_answer + "]";
	}	
	
}