package com.acldigital.unaito.service.user.dto;

import java.time.Instant;

public class JwtLoggedInDetails {

	private String sessionId;
	private String jwtType;
	private String jwt;
	private Instant jwtCreatedTime;
	private Instant jwtExpiryTime;
	private boolean isFirstTimeLogin;

	public JwtLoggedInDetails(String sessionId, String jwtType, String jwt, Instant jwtCreatedTime,
			Instant jwtExpiryTime) {
		super();
		this.sessionId = sessionId;
		this.jwtType = jwtType;
		this.jwt = jwt;
		this.jwtCreatedTime = jwtCreatedTime;
		this.jwtExpiryTime = jwtExpiryTime;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getJwtType() {
		return jwtType;
	}

	public String getJwt() {
		return jwt;
	}

	public Instant getJwtCreatedTime() {
		return jwtCreatedTime;
	}

	public Instant getJwtExpiryTime() {
		return jwtExpiryTime;
	}

	public boolean isFirstTimeLogin() {
		return isFirstTimeLogin;
	}

	public void setFirstTimeLogin(boolean isFirstTimeLogin) {
		this.isFirstTimeLogin = isFirstTimeLogin;
	}

	@Override
	public String toString() {
		return "JwtLoggedInDetails [sessionId=" + sessionId + ", jwtType=" + jwtType + ", jwt=" + jwt
				+ ", jwtCreatedTime=" + jwtCreatedTime + ", jwtExpiryTime=" + jwtExpiryTime + ", isFirstTimeLogin="
				+ isFirstTimeLogin + "]";
	}

}
