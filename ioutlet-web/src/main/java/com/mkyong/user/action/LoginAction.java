package com.mkyong.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// business logic
	public String execute() {
		if ("admin".equals(username))
			return SUCCESS;
		else
			return INPUT;

	}

	// simple validation
	public void validate() {
		if ("".equals(getUsername())) {
			addFieldError("username", getText("username.required"));
		}
		if ("".equals(getPassword())) {
			addFieldError("password", getText("password.required"));
		}

		if ("admin".equals(getUsername())) {
			addActionMessage("You are valid user!");
		} else {
			addActionError("I don't know you, dont try to hack me!");
		}

	}

}