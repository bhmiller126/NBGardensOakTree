package com.qa.oaktree.controllers;

import javax.enterprise.context.SessionScoped;

/**
 * This bean hold the id of the user currently logged in on the session
 * 
 * @author Barry
 *
 */
@SessionScoped
public class CurrentUser
{
	private long currentUser =-1;
	
	public long getCurrentUser()
	{
		return currentUser;
	}
	
	public void setCurrentUser(long userID)
	{
		currentUser = userID;
	}
}
