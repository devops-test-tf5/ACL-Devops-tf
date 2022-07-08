
package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomersEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "location")
	private String location;

	@Column(name = "spoc_first_name")
	private String spocFirstName;

	@Column(name = "spoc_last_name")
	private String spocLastName;

	@Column(name = "email")
	private String emailId;

	@Column(name = "contact_number")
	private Long contactNumber;

	@Column(name = "is_active")
	private int isActive;

	@OneToMany(mappedBy = "projectId", cascade = CascadeType.ALL)
	private List<ProjectsEntity> projectEntities = new ArrayList<>();

	public CustomersEntity() {

	}

	/*
	 * public CustomersEntity(String customerName, Long userId, String location,
	 * String spocFirstName, String spocLastName, String emailId, int isActive,Long
	 * contactNumber) { super(); this.customerName = customerName; this.userId =
	 * userId; this.location = location; this.spocFirstName = spocFirstName;
	 * this.spocLastName = spocLastName; this.emailId = emailId; this.isActive =
	 * isActive; this.contactNumber=contactNumber; }
	 */
	

	public CustomersEntity(Long customerId, String customerName, Long userId, String location, String spocFirstName,
			String spocLastName, String emailId, Long contactNumber, int isActive,
			List<ProjectsEntity> projectEntities) {
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
		this.projectEntities = projectEntities;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public List<ProjectsEntity> getProjectEntities() {
		return projectEntities;
	}

	public void setProjectEntities(List<ProjectsEntity> projectEntities) {
		this.projectEntities = projectEntities;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "CustomersEntity [customerId=" + customerId + ", customerName=" + customerName + ", userId=" + userId
				+ ", location=" + location + ", spocFirstName=" + spocFirstName + ", spocLastName=" + spocLastName
				+ ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", isActive=" + isActive
				+ ", projectEntities=" + projectEntities + "]";
	}

}
