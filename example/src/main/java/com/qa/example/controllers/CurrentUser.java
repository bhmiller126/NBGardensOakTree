package com.qa.example.controllers;

import javax.enterprise.context.SessionScoped;

/**
 * This bean holds the id of the user currently logged in on the session
 * @author James Thompson
 */
@SessionScoped
public class CurrentUser {
	private long currentUser =-1;

	public long getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(long userID) {
		currentUser = userID;		
	}
}