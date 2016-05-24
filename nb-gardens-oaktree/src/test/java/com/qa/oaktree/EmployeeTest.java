package com.qa.oaktree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.qa.oaktree.entities.Employee;

public class EmployeeTest {
	@Test public void testEmployee () {
		Employee testing = new Employee (); 
		assertNull(testing.getEmployeeName());  
	}
	@Test public void testEmployeeString() {
		Employee testing = new Employee(); 
		assertNotNull(testing.getEmployeeDepartment()); 
	}
	@Test public void testGetUserName () {
		Employee testing = new Employee();
		assertNull(testing.getEmployeeUsername()); 	
	}
	@Test public void testGetDepartment() {
		Employee testing = new Employee(); 
		assertEquals ("a", testing.getEmployeeDepartment()); 
	}
	@Test public void testSetName() {
		Employee testing = new Employee(); 
		testing.setEmployeeName("aa");
		assertEquals("aa", testing.getEmployeeName()); 
	}
	@Test public void testSetAccess() {
		Employee testing = new Employee(); 
		testing.setEmployeeAccess(0);
		assertEquals(0, testing.getEmployeeAccess()); 
	}
	@Test public void testSetSecretAnswer() {
		Employee testing = new Employee(); 
		testing.setEmployeeSecretAnswer(null);
		assertNull(testing.getEmployeeSecretAnswer());
	}

}
