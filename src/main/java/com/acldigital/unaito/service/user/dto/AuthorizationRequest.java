package com.acldigital.unaito.service.user.dto;

public class AuthorizationRequest {

	private String userName;
	private String password;

	public AuthorizationRequest() {

	}

	public AuthorizationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthorizationRequest [userName=" + userName + ", password=" + password + "]";
	}

}
