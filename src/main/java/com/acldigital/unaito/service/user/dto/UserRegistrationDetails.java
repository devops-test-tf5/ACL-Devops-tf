package com.acldigital.unaito.service.user.dto;

public class UserRegistrationDetails {

	private String userName;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private Long contactNumber;

	private String location;

	private String roleName;

	private Integer maxWrongPasswordCount;
	private Integer wrongPasswordCount;
	private UserCryptoDetails userCryptoDetails;

	public UserRegistrationDetails() {

	}

	public UserRegistrationDetails(String userName, String password, String email,
			UserCryptoDetails userCryptoDetails) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userCryptoDetails = userCryptoDetails;
	}

	public UserRegistrationDetails(String userName, String password, String firstName, String lastName, String email,
			Long contactNumber, String location, String roleName, UserCryptoDetails userCryptoDetails,
			Integer maxWrongPasswordCount, Integer wrongPasswordCount) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.location = location;
		this.roleName = roleName;
		this.userCryptoDetails = userCryptoDetails;
		this.maxWrongPasswordCount = maxWrongPasswordCount;
		this.wrongPasswordCount = wrongPasswordCount;
	}

	public UserRegistrationDetails(UserCryptoDetails userCryptoDetails) {
		this.userCryptoDetails = userCryptoDetails;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UserCryptoDetails getUserCryptoDetails() {
		return userCryptoDetails;
	}

	public void setUserCryptoDetails(UserCryptoDetails userCryptoDetails) {
		this.userCryptoDetails = userCryptoDetails;
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
		return "UserRegistrationDetails [userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", contactNumber=" + contactNumber + ", location="
				+ location + ", roleName=" + roleName + ", maxWrongPasswordCount=" + maxWrongPasswordCount
				+ ", wrongPasswordCount=" + wrongPasswordCount + ", userCryptoDetails=" + userCryptoDetails + "]";
	}

}
