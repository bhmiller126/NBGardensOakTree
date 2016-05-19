package main.java.com.qa.nb_gardens_oaktree;

public class Employee 
{
	private String employee_name;
	private String employee_username;
	private String employee_password;
	private String employee_department;
	private int employee_access;
	private String employee_secret_question;
	private String employee_secret_answer;
	
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

	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_username() {
		return employee_username;
	}
	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public String getEmployee_password() {
		return employee_password;
	}
	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	public String getEmployee_department() {
		return employee_department;
	}
	public void setEmployee_department(String employee_department) {
		this.employee_department = employee_department;
	}

	public int getEmployee_access() {
		return employee_access;
	}
	public void setEmployee_access(int employee_access) {
		this.employee_access = employee_access;
	}

	public String getEmployee_secret_question() {
		return employee_secret_question;
	}
	public void setEmployee_secret_question(String employee_secret_question) {
		this.employee_secret_question = employee_secret_question;
	}

	public String getEmployee_secret_answer() {
		return employee_secret_answer;
	}
	public void setEmployee_secret_answer(String employee_secret_answer) {
		this.employee_secret_answer = employee_secret_answer;
	}
}