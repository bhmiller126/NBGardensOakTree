package com.qa.example.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.qa.example.entities.Customer;

/**
 * This hold our test data for testing that the application runs properly
 * 
 * @author James Thompson
 */
@Singleton
public class TestData {
	private List<Customer> customers;

	public TestData() {
		customers = new ArrayList<Customer>();
		customers.add(new Customer(0, "bobers", "password!"));
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
}