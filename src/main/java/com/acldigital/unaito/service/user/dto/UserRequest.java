package com.acldigital.unaito.service.user.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UserRequest {

	@JsonInclude(Include.NON_NULL)
	@Size(min = 8, max = 50, message = "User name is mandatory.")
	private String userName;

	@JsonInclude(Include.NON_NULL)
	@Size(min = 8, max = 50, message = "Password is mandatory.")
	private String password;

	@JsonInclude(Include.NON_NULL)
	@Size(max = 50, message = "First name is mandatory.")
	private String firstName;

	@JsonInclude(Include.NON_NULL)
	@Size(max = 50, message = "Last name is mandatory.")
	private String lastName;

	@JsonInclude(Include.NON_NULL)
	@Email
	private String email;

	@JsonInclude(Include.NON_NULL)
	@Digits(integer = 13, fraction = 0)
	private Long contactNumber;

	@JsonInclude(Include.NON_NULL)
	@Size(max = 50, message = "Location is mandatory.")
	private String location;

	@JsonInclude(Include.NON_NULL)
	private String roleName;

	public UserRequest() {

	}

	public UserRequest(String userName, String password, String firstName, String lastName, String email,
			Long contactNumber, String location, String roleName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.location = location;
		this.roleName = roleName;
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

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRequestDto [userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", contactNumber=" + contactNumber + ", location="
				+ location + ", roleName=" + roleName + "]";
	}

}
