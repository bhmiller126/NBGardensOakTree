package com.qa.oaktree.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 * This bean hold the id of the user currently logged in on the session
 * 
 * @author Barry
 *
 */
@SessionScoped
public class CurrentUser implements Serializable
{
	private String currentUser = "";
	
	public String getCurrentUser()
	{
		return currentUser;
	}
	
	public void setCurrentUser(String username)
	{
		currentUser = username;
	}
}
