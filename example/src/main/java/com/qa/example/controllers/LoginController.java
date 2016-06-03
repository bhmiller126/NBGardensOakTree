package com.qa.example.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.example.service.UserService;

/**
 * This is the controller that handles all login and logout requests and ONLY these requests.
 * 
 * @author James Thompson
 */
@Named(value = "login")
@RequestScoped
public class LoginController {
	@Inject
	private UserService userService;
	@Inject
	private CurrentUser currentUser;
	private String error = "";
	private String username = "";
	private String password = "";

	public String login() {
		if (username.isEmpty()) {
			error = "Please Enter your Username";
			password = "";
			return "login";
		}
		if (password.isEmpty()) {
			error = "Please enter your password " + username;
			password = "";
			return "login";
		}
		if (!userService.validateCredentials(username, password)) {
			error = "sorry but your details were not valid";
			password = "";
			return "login";
		}
		currentUser.setCurrentUser(userService.getUserID(username));
		return "home";
	}

	public String logout() {
		currentUser.setCurrentUser(-1);
		return "home";
	}

	public String getError() {
		return error;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}