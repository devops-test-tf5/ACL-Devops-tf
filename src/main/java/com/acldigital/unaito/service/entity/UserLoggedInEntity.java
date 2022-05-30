package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN_DETAILS")
public class UserLoggedInEntity implements Serializable {

	private static final long serialVersionUID = 3937859731915151458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private Long loginId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "session_id")
	private String sessionId;

	@Column(name = "jwt_type")
	private String jwtType;

	@Column(name = "previous_jwt")
	private String previousJwt;

	@Column(name = "jwt")
	private String jwt;

	@Column(name = "jwt_created_time")
	private Instant jwtCreatedTime;

	@Column(name = "jwt_expiry_time")
	private Instant jwtExpiryTime;

	@Column(name = "is_logged_in")
	private char loggedIn;

	@Column(name = "logged_in_time")
	private Instant loggedInTime;

	@Column(name = "is_logged_out")
	private char loggedOut;

	@Column(name = "logged_out_time")
	private Instant loggedOutTime;

	@Column(name = "max_wrong_password_count")
	private Integer maxWrongPasswordCount;

	@Column(name = "wrong_password_count")
	private Integer wrongPasswordCount;

	public UserLoggedInEntity() {

	}

	public UserLoggedInEntity(Long userId, String sessionId, String jwtType, String previousJwt, String jwt,
			Instant jwtCreatedTime, Instant jwtExpiryTime, char loggedIn, Instant loggedInTime, char loggedOut,
			Instant loggedOutTime, Integer maxWrongPasswordCount, Integer wrongPasswordCount) {
		super();
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

	@Override
	public String toString() {
		return "UserLoggedInEntity [loginId=" + loginId + ", userId=" + userId + ", sessionId=" + sessionId
				+ ", jwtType=" + jwtType + ", previousJwt=" + previousJwt + ", jwt=" + jwt + ", jwtCreatedTime="
				+ jwtCreatedTime + ", jwtExpiryTime=" + jwtExpiryTime + ", loggedIn=" + loggedIn + ", loggedInTime="
				+ loggedInTime + ", loggedOut=" + loggedOut + ", loggedOutTime=" + loggedOutTime
				+ ", maxWrongPasswordCount=" + maxWrongPasswordCount + ", wrongPasswordCount=" + wrongPasswordCount
				+ "]";
	}

}
