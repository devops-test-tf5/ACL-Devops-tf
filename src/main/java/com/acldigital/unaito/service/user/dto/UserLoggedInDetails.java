package com.acldigital.unaito.service.user.dto;

import java.time.Instant;

public class UserLoggedInDetails {

	private Long loginId;
	private Long userId;
	private String sessionId;
	private String jwtType;
	private String previousJwt;
	private String jwt;
	private Instant jwtCreatedTime;
	private Instant jwtExpiryTime;
	private char loggedIn;
	private Instant loggedInTime;
	private char loggedOut;
	private Instant loggedOutTime;
	private Integer maxWrongPasswordCount;
	private Integer wrongPasswordCount;
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public void setJwtType(String jwtType) {
		this.jwtType = jwtType;
	}
	public String getPreviousJwt() {
		return previousJwt;
	}
	public void setPreviousJwt(String previousJwt) {
		this.previousJwt = previousJwt;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public Instant getJwtCreatedTime() {
		return jwtCreatedTime;
	}
	public void setJwtCreatedTime(Instant jwtCreatedTime) {
		this.jwtCreatedTime = jwtCreatedTime;
	}
	public Instant getJwtExpiryTime() {
		return jwtExpiryTime;
	}
	public void setJwtExpiryTime(Instant jwtExpiryTime) {
		this.jwtExpiryTime = jwtExpiryTime;
	}
	public char getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(char loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Instant getLoggedInTime() {
		return loggedInTime;
	}
	public void setLoggedInTime(Instant loggedInTime) {
		this.loggedInTime = loggedInTime;
	}
	public char getLoggedOut() {
		return loggedOut;
	}
	public void setLoggedOut(char loggedOut) {
		this.loggedOut = loggedOut;
	}
	public Instant getLoggedOutTime() {
		return loggedOutTime;
	}
	public void setLoggedOutTime(Instant loggedOutTime) {
		this.loggedOutTime = loggedOutTime;
	}
	public Integer getMaxWrongPasswordCount() {
		return maxWrongPasswordCount;
	}
	public void setMaxWrongPasswordCount(Integer maxWrongPasswordCount) {
		this.maxWrongPasswordCount = maxWrongPasswordCount;
	}
	public Integer getWrongPasswordCount() {
		return wrongPasswordCount;
	}
	public void setWrongPasswordCount(Integer wrongPasswordCount) {
		this.wrongPasswordCount = wrongPasswordCount;
	}
	
	public UserLoggedInDetails() {
		
	}
	public UserLoggedInDetails(Long userId, String sessionId, String jwtType, 
			String jwt, Instant jwtCreatedTime, Instant jwtExpiryTime, char loggedIn, Instant loggedInTime) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
		this.jwtType = jwtType;
		this.jwt = jwt;
		this.jwtCreatedTime = jwtCreatedTime;
		this.jwtExpiryTime = jwtExpiryTime;
		this.loggedIn = loggedIn;
		this.loggedInTime = loggedInTime;
	}
	
	
	public UserLoggedInDetails(Long loginId, Long userId, String sessionId, String jwtType, String previousJwt,
			String jwt, Instant jwtCreatedTime, Instant jwtExpiryTime, char loggedIn, Instant loggedInTime,
			char loggedOut, Instant loggedOutTime, Integer maxWrongPasswordCount, Integer wrongPasswordCount) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.sessionId = sessionId;
		this.jwtType = jwtType;
		this.previousJwt = previousJwt;
		this.jwt = jwt;
		this.jwtCreatedTime = jwtCreatedTime;
		this.jwtExpiryTime = jwtExpiryTime;
		this.loggedIn = loggedIn;
		this.loggedInTime = loggedInTime;
		this.loggedOut = loggedOut;
		this.loggedOutTime = loggedOutTime;
		this.maxWrongPasswordCount = maxWrongPasswordCount;
		this.wrongPasswordCount = wrongPasswordCount;
	}
	@Override
	public String toString() {
		return "UserLoggedInDetails [loginId=" + loginId + ", userId=" + userId + ", sessionId=" + sessionId
				+ ", jwtType=" + jwtType + ", previousJwt=" + previousJwt + ", jwt=" + jwt + ", jwtCreatedTime="
				+ jwtCreatedTime + ", jwtExpiryTime=" + jwtExpiryTime + ", loggedIn=" + loggedIn + ", loggedInTime="
				+ loggedInTime + ", loggedOut=" + loggedOut + ", loggedOutTime=" + loggedOutTime
				+ ", maxWrongPasswordCount=" + maxWrongPasswordCount + ", wrongPasswordCount=" + wrongPasswordCount
				+ "]";
	}
	
	
}
