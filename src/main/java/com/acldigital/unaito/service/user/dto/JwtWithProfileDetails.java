package com.acldigital.unaito.service.user.dto;

public class JwtWithProfileDetails {

	private String jwt;
	private User userProfileDetails;

	public JwtWithProfileDetails() {

	}

	public JwtWithProfileDetails(String jwt, User userProfileDetails) {
		super();
		this.jwt = jwt;
		this.userProfileDetails = userProfileDetails;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public User getUserProfileDetails() {
		return userProfileDetails;
	}

	public void setUserProfileDetails(User userProfileDetails) {
		this.userProfileDetails = userProfileDetails;
	}

	@Override
	public String toString() {
		return "JwtWithProfileDetails [jwt=" + jwt + ", userProfileDetails=" + userProfileDetails + "]";
	}

}
