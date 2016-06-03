package com.qa.oaktree.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.oaktree.repositories.CustomerRepository;

/**
 * This stateless bean hold business logic associated with the customer entity
 * 
 * @author Barry
 *
 */
@Stateless
public class UserService
{
	@Inject 
	private CustomerRepository customerRepository;
	
	public boolean validateCredentials(String username, String password)
	{
		if(customerRepository.findByUsernameAndPassword(username, password) == null)
			return false;
		return true;
	}
	
	public String getUserID(String username)
	{
		return customerRepository.findByUsername(username).getUserName();
	}
	
	
	/**
	 * Hash method that takes a string message and returns the string representation of the
	 * resulting hash using the SHA-256 algorithm
	 * @param aString the string to hash
	 * @return the hashed value
	 */
	private String hashString(String aString){
		try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hashedBytes = digest.digest(aString.getBytes("UTF-8"));
	 
	        return convertByteArrayToHexString(hashedBytes);
	    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Converts a byte array into a hex string to make it human readable
	 * @param arrayBytes the byte array from the hashing algorithm
	 * @return a hex string of the byte array
	 */
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < arrayBytes.length; i++) {
	        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return stringBuffer.toString();
	}
}
