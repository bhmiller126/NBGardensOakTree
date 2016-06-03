package com.qa.oaktree.repositories.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.oaktree.entities.Customer;
import com.qa.oaktree.repositories.CustomerRepository;
import com.qa.oaktree.util.TestData;

/**
 * This is the default implementation of the customer repository interface.
 * You DO NOT directly inject this, you ONLY inject the INTERFACE
 * 
 * @author Daniel
 *
 */

@Default
@Stateless
public class CustomerRepositoryOffline implements CustomerRepository
{
	@Inject private TestData testData;
	
	public Customer findByUsernameAndPassword(String username, String password) 
	{
		for(Customer customer : testData.getCustomers())
		{
			if(customer.getUserName().equalsIgnoreCase(username) && customer.getPassword().equals(password))
			{return customer;}
		}
		return null;
	}

	public Customer findByUsername(String username) 
	{
		for(Customer customer : testData.getCustomers())
		{
			if(customer.getUserName().equalsIgnoreCase(username))
			{return customer;}
		}
		return null;
	}
}