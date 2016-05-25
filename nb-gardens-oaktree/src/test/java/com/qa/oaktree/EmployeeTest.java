package com.qa.oaktree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.qa.oaktree.entities.Employee;

/**
 * 
 * @author OakTree BM
 * Employee Test
 *
 */
public class EmployeeTest {

	/**
	 * This test checks that the employee object is null This should return that
	 * employee name is null
	 */
	@Test
	public void testEmployee() {
		Employee testing = new Employee();
		assertNull(testing.getEmployeeName());
	}

	/**
	 * This test checks that that employee object is not null This should return
	 * that employee deartment is not null
	 */
	@Test
	public void testEmployeeString() {
		Employee testing = new Employee();
		assertNotNull(testing.getEmployeeDepartment());
	}

	/**
	 * This test will test the getter for employee username This should return
	 * null
	 */
	@Test
	public void testGetUserName() {
		Employee testing = new Employee();
		assertNull(testing.getEmployeeUsername());
	}

	/**
	 * This test will test the getter for employee department This should return
	 * "a" as assert equals tests that the value inputted is the same
	 */
	@Test
	public void testGetDepartment() {
		Employee testing = new Employee();
		assertEquals("a", testing.getEmployeeDepartment());
	}

	/**
	 * This test will test the setter for employee name. This should return "aa"
	 * as firstly set employee name is used, then assert equals again to test
	 * that the values match
	 */
	@Test
	public void testSetName() {
		Employee testing = new Employee();
		testing.setEmployeeName("aa");
		assertEquals("aa", testing.getEmployeeName());
	}

	/**
	 * This test will test the setter for employee access. This should return
	 * "0" as firstly set employee access is used, then assert equals again to
	 * test that the values match
	 */
	@Test
	public void testSetAccess() {
		Employee testing = new Employee();
		testing.setEmployeeAccess(0);
		assertEquals(0, testing.getEmployeeAccess());
	}

	/**
	 * This test will test the setter for employee secret answer. This should
	 * return null as employee secret answer has been set to null. Assert null
	 * is used to check that the object is null
	 */
	@Test
	public void testSetSecretAnswer() {
		Employee testing = new Employee();
		testing.setEmployeeSecretAnswer(null);
		assertNull(testing.getEmployeeSecretAnswer());
	}

	/**
	 * This test will test the getter for employee secret question. This should
	 * return "b" as it is checking that the values match with assert equals.
	 */
	@Test
	public void testGetSecretQuestion() {
		Employee testing = new Employee();
		assertEquals("b", testing.getEmployeeSecretQuestion());
	}
}
