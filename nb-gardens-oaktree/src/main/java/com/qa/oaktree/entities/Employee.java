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
 * Employee noSQL entity
 */
@Entity
@Table (name = "Employee")
public class Employee 
{
	@Id
	@Column (name = "employee_name", nullable = false, length = 225)
	private String employeeName;

	@Column (name = "employee_username", nullable = false, length = 225)	
	private String employeeUsername;
	
	@Column (name = "employee_password", nullable = false, length = 225)
	private String employeePassword;
	
	@Column (name = "employee_department", nullable = false, length = 225)
	private String employeeDepartment;
	
	@Column (name = "employee_access", nullable = false, length = 225)
	private int employeeAccess;
	
	@Column (name = "employee_secret_question", nullable = false, length = 225)
	private String employeeSecretQuestion;
	
	@Column (name = "employee_secret_answer", nullable = false, length = 225)
	private String employeeSecretAnswer;
	
	/**
	 * Null constructor for Employee 
	 */
	public Employee() {
		this.employeeName = "";
		this.employeeUsername = "";
		this.employeePassword = "";
		this.employeeDepartment = "";
		this.employeeAccess = 0;
		this.employeeSecretQuestion = "";
		this.employeeSecretAnswer = "";
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
	public Employee(String employeeName, String employeeUsername, String employeePassword, String employeeDepartment, int employeeAccess,
					String employeeSecretQuestion, String employeeSecretAnswer)
	{
		this.employeeName = employeeName;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeDepartment = employeeDepartment;
		this.employeeAccess = employeeAccess;
		this.employeeSecretQuestion = employeeSecretQuestion;
		this.employeeSecretAnswer = employeeSecretAnswer;
	}

	/**
	 * getter method for employee's name
	 * @return employee_name
	 */
	public String getEmployeeName() 
	{return employeeName;}
	
	/**
	 * setter method for employee's name
	 *  @param employee_name
	 */
	public void setEmployeeName(String employee_name) 
	{this.employeeName = employee_name;}

	/**
	 * getter method for employee's username
	 * @return employee_username
	 */
	public String getEmployeeUsername() 
	{return employeeUsername;}
	
	/**
	 * setter method for employee's username
	 * @param employee_username
	 */
	public void setEmployeeUsername(String employee_username)
	{this.employeeUsername = employee_username;}

	/**
	 * getter method for employee's password
	 * @return employee_password
	 */
	public String getEmployeePassword() 
	{return employeePassword;}
	
	/**
	 * setter method for employee's password
	 * @param employee_password
	 */
	public void setEmployeePassword(String employee_password) 
	{this.employeePassword = employee_password;}

	/**
	 * getter method for employee's department
	 * @return employee_deparment
	 */
	public String getEmployeeDepartment()
	{return employeeDepartment;}
	
	/**
	 * setter method for employee's department
	 * @param employee_deparment
	 */
	public void setEmployeeDepartment(String employee_department) 
	{this.employeeDepartment = employee_department;}

	/**
	 * getter method for employee's access level 
	 * @return employee_access
	 */
	public int getEmployeeAccess() 
	{return employeeAccess;}
	
	/**
	 * setter method for employee's access level 
	 * @param employee_access
	 */
	public void setEmployeeAccess(int employee_access) 
	{this.employeeAccess = employee_access;}

	/**
	 * getter method for employee's secret question
	 * @return employee_secret_question
	 */
	public String getEmployeeSecretQuestion() 
	{return employeeSecretQuestion;}
	
	/**
	 * setter method for employee's secret question
	 * @param employee_secret_question
	 */
	public void setEmployeeSecretQuestion(String employee_secret_question) 
	{this.employeeSecretQuestion = employee_secret_question;}

	/**
	 * getter method for employee's secret answer
	 * @return employee_secret_answer
	 */
	public String getEmployeeSecretAnswer() 
	{return employeeSecretAnswer;}
	
	/**
	 * setter method for employee's secret answer
	 * @param employee_secret_answer
	 */
	public void setEmployeeSecretAnswer(String employee_secret_answer) 
	{this.employeeSecretAnswer = employee_secret_answer;}

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
		if (employeeAccess != other.employeeAccess)
			return false;
		if (employeeDepartment == null) {
			if (other.employeeDepartment != null)
				return false;
		} else if (!employeeDepartment.equals(other.employeeDepartment))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeSecretAnswer == null) {
			if (other.employeeSecretAnswer != null)
				return false;
		} else if (!employeeSecretAnswer.equals(other.employeeSecretAnswer))
			return false;
		if (employeeSecretQuestion == null) {
			if (other.employeeSecretQuestion != null)
				return false;
		} else if (!employeeSecretQuestion.equals(other.employeeSecretQuestion))
			return false;
		if (employeeUsername == null) {
			if (other.employeeUsername != null)
				return false;
		} else if (!employeeUsername.equals(other.employeeUsername))
			return false;
		return true;
	}

	/** 
	 * Override object's toString method for Employee
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employee_name=" + employeeName + ", employee_username=" + employeeUsername
				+ ", employee_password=" + employeePassword + ", employee_department=" + employeeDepartment
				+ ", employee_access=" + employeeAccess + ", employee_secret_question=" + employeeSecretQuestion
				+ ", employee_secret_answer=" + employeeSecretAnswer + "]";
	}	
	
}