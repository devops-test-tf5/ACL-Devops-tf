package com.acldigital.unaito.service.user.dto;

import java.time.Instant;

import javax.validation.constraints.NotNull;

public class UserDto {

	private Long userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String roleName;
	private Long contactNumber;
	private Integer isActive;
	private String location;

	@NotNull
	private String passwordExpiry;

	@NotNull
	private Instant lastLoggedIn;

	@NotNull
	private String saltKey;

	@NotNull
	private String cryptoAlgoName;

	public UserDto() {

	}

	public UserDto(Long userId, String userName, String firstName, String lastName, String email, String roleName,
			Long contactNumber, Integer isActive, String location) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleName = roleName;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
		this.location = location;
	}

	public UserDto(Long userId, String userName, String password, String firstName, String lastName, String email,
			String roleName, Long contactNumber, Integer isActive, String location) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleName = roleName;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
		this.location = location;
	}

	public UserDto(Long userId, String userName, String password, String firstName, String lastName, String email,
			String roleName, Long contactNumber, Integer isActive, String location, String salt,
			String cryptoAlgoName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleName = roleName;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
		this.location = location;
		this.saltKey = salt;
		this.cryptoAlgoName = cryptoAlgoName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPasswordExpiry() {
		return passwordExpiry;
	}

	public void setPasswordExpiry(String passwordExpiry) {
		this.passwordExpiry = passwordExpiry;
	}

	public Instant getLastLoggedIn() {
		return lastLoggedIn;
	}

	public void setLastLoggedIn(Instant lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	public String getSaltKey() {
		return saltKey;
	}

	public void setSaltKey(String saltKey) {
		this.saltKey = saltKey;
	}

	public String getCryptoAlgoName() {
		return cryptoAlgoName;
	}

	public void setCryptoAlgoName(String cryptoAlgoName) {
		this.cryptoAlgoName = cryptoAlgoName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleName=" + roleName
				+ ", contactNumber=" + contactNumber + ", isActive=" + isActive + ", location=" + location
				+ ", passwordExpiry=" + passwordExpiry + ", lastLoggedIn=" + lastLoggedIn + ", saltKey=" + saltKey
				+ ", cryptoAlgoName=" + cryptoAlgoName + "]";
	}

}
