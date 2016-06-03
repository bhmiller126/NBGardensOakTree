package com.qa.oaktree.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import com.qa.oaktree.entities.Customer;

/**
 * This holds the test data fro testing that the application runs properluy
 * @author Daniel
 *
 */

@Singleton
public class LoginTestData 
{
	private List<Customer> customers;
	
	public LoginTestData()
	{
		customers = new ArrayList<Customer>();
		customers.add(new Customer("jbloggs","Mr","Joe","Bloggs","password!",new Date(29221),true,new BigDecimal("10000"),"jbloggs@jbloggs.com","01234 567890","Active","Question!","Answer!","1 any street","aa1 1aa"));
	}
	
	public List<Customer> getCustomers()
	{
		return customers;
	}

}
