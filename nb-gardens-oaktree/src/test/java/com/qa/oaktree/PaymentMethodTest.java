package com.qa.oaktree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.oaktree.entities.PaymentMethod;

/**
 * 
 * @author OakTree BM Payment method test
 *
 */
public class PaymentMethodTest {

	/**
	 * This first test is testing that the object of payment emthod will return
	 * null but using assertnull
	 */
	@Test
	public void testPaymentMethod() {
		PaymentMethod testing = new PaymentMethod();
		assertNull(testing.getUserName());
	}

	/**
	 * This test is testing the getter for card number should return blank as ""
	 * is thwe value it is checking against to see if its the same
	 */
	@Test
	public void testGetCardNumber() {
		PaymentMethod testing = new PaymentMethod();
		assertEquals("", testing.getCardNumber());
	}

	/**
	 * This test is setting the card type to null, then checking to see if the
	 * object is not null should return an error as the card type has been set
	 * to null
	 */
	@Test
	public void testSetCardType() {
		PaymentMethod testing = new PaymentMethod();
		testing.setCardType(null);
		assertNotNull(testing.getCardType());
	}

	/**
	 * This method is testing the to string method should return an error or
	 * nothing as there is currently no data for the onject or test to pull
	 */
	@Test
	public void testToString() {
		PaymentMethod testing = new PaymentMethod();
		testing.toString();
	}

	/**
	 * This test is testing the set expiry method, the expiry date is set to
	 * null should return that it is null as assert null is used
	 */
	@Test
	public void testSetExpiryDate() {
		PaymentMethod testing = new PaymentMethod();
		testing.setExpiryDate(null);
		assertNull(testing.getExpiryDate());
	}

	/**
	 * This tests the set nilling address Should return two nulls, as billing
	 * address line 1 and billing address postcode have both been set to null
	 */
	@Test
	public void testSetBillingAddresss() {
		PaymentMethod testing = new PaymentMethod();
		testing.setBillingAddressLine1(null);
		testing.setBillingAddressPostcode(null);
		assertNull(testing.getBillingAddressLine1(), testing.getBillingAddressPostcode());
	}
}
