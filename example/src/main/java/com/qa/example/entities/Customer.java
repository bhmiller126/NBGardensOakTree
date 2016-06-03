package com.qa.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qa.example.util.CustomerStatus;

/**
 * This is the customer entity
 * 
 * @author James Thompson
 */
@Entity
@Table(name="customer")
public class Customer {
	@Column(name="id", unique=true, nullable=false)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="username", nullable=false, unique=true, length=100)
	@NotNull
	@Size(min=3, max=100)
	private String username;
	@Column(name="password", nullable=false, length=225)
	@NotNull
	@Size(min=8, max=225)
	private String password;
	@Column(name="status", nullable=false)
	@NotNull
	private CustomerStatus customerStatus;
	
	public Customer() { }

	public Customer(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		customerStatus = CustomerStatus.ACTIVE;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}