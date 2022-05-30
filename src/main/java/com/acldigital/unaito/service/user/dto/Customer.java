package com.acldigital.unaito.service.user.dto;

import java.util.List;

public class Customer {

	private Long customerId;

	private Long userId;

	private String customerName;

	private String location;

	private String spocFirstName;

	private String spocLastName;

	private Integer contactNumber;
	
	private List<Projects> projectsList;

	public Customer() {

	}

	

	public Customer(Long customerId, Long userId, String customerName, String location, String spocFirstName,
			String spocLastName, Integer contactNumber, List<Projects> projectsList) {
		super();
		this.customerId = customerId;
		this.userId = userId;
		this.customerName = customerName;
		this.location = location;
		this.spocFirstName = spocFirstName;
		this.spocLastName = spocLastName;
		this.contactNumber = contactNumber;
		this.projectsList = projectsList;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userId=" + userId + ", customerName=" + customerName
				+ ", location=" + location + ", spocFirstName=" + spocFirstName + ", spocLastName=" + spocLastName
				+ ", contactNumber=" + contactNumber + ", projectsList=" + projectsList + "]";
	}

	

}
