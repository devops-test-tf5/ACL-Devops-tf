package com.acldigital.unaito.service.customer;

public class CustomerDto {

	private Long customerId;

	private String customerName;
	
	private Long userId;

	private String location;

	private String spocFirstName;

	private String spocLastName;

	private String emailId;

	private Long contactNumber;

	private int isActive;
	

	/*
	 * public CustomerDto(String customerName, String location, String
	 * spocFirstName, String spocLastName, String email, Long contactNumber, Long
	 * userId) { super(); this.customerName = customerName; this.location =
	 * location; this.spocFirstName = spocFirstName; this.spocLastName =
	 * spocLastName; this.email = email; this.contactNumber = contactNumber;
	 * this.userId = userId; }
	 */

	

	public CustomerDto() {

	}

	public CustomerDto(Long customerId, String customerName, Long userId, String location, String spocFirstName,
			String spocLastName, String emailId, Long contactNumber, int isActive) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.userId = userId;
		this.location = location;
		this.spocFirstName = spocFirstName;
		this.spocLastName = spocLastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpocFirstName() {
		return spocFirstName;
	}

	public void setSpocFirstName(String spocFirstName) {
		this.spocFirstName = spocFirstName;
	}

	public String getSpocLastName() {
		return spocLastName;
	}

	public void setSpocLastName(String spocLastName) {
		this.spocLastName = spocLastName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", customerName=" + customerName + ", userId=" + userId
				+ ", location=" + location + ", spocFirstName=" + spocFirstName + ", spocLastName=" + spocLastName
				+ ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", isActive=" + isActive + "]";
	}

	

}
