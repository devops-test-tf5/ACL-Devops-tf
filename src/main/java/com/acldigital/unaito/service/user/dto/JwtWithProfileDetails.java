package com.acldigital.unaito.service.user.dto;

public class JwtWithProfileDetails {

	private String jwt;
	private UserDto userProfileDetails;

	public JwtWithProfileDetails() {

	}

	public JwtWithProfileDetails(String jwt, UserDto userProfileDetails) {
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

	public UserDto getUserProfileDetails() {
		return userProfileDetails;
	}

	public void setUserProfileDetails(UserDto userProfileDetails) {
		this.userProfileDetails = userProfileDetails;
	}

	@Override
	public String toString() {
		return "JwtWithProfileDetails [jwt=" + jwt + ", userProfileDetails=" + userProfileDetails + "]";
	}

}
