package com.acldigital.unaito.service.project.dto;

import com.acldigital.unaito.service.entity.ProjectsEntity;

public class ApplicationOverview {

	private Long applicationId;

	private String applicationName;

	private ProjectsEntity projectEntity;

	private String description;

	private String businessUnit;

	private String businessCritical;

	private String highAvailability;

	private String responseTime;

	private Integer noOfInteractions;

	private String contactFirstName;

	private String contactLastName;

	private String email;

	private Integer contactNumber;

	public ApplicationOverview() {

	}

	public ApplicationOverview(Long applicationId, String applicationName, ProjectsEntity projectEntity,
			String description, String businessUnit, String businessCritical, String highAvailability,
			String responseTime, Integer noOfInteractions, String contactFirstName, String contactLastName,
			String email, Integer contactNumber) {
		super();
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.projectEntity = projectEntity;
		this.description = description;
		this.businessUnit = businessUnit;
		this.businessCritical = businessCritical;
		this.highAvailability = highAvailability;
		this.responseTime = responseTime;
		this.noOfInteractions = noOfInteractions;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public ProjectsEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectsEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getBusinessCritical() {
		return businessCritical;
	}

	public void setBusinessCritical(String businessCritical) {
		this.businessCritical = businessCritical;
	}

	public String getHighAvailability() {
		return highAvailability;
	}

	public void setHighAvailability(String highAvailability) {
		this.highAvailability = highAvailability;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public Integer getNoOfInteractions() {
		return noOfInteractions;
	}

	public void setNoOfInteractions(Integer noOfInteractions) {
		this.noOfInteractions = noOfInteractions;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "ApplicationOverview [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", projectEntity=" + projectEntity + ", description=" + description + ", businessUnit=" + businessUnit
				+ ", businessCritical=" + businessCritical + ", highAvailability=" + highAvailability
				+ ", responseTime=" + responseTime + ", noOfInteractions=" + noOfInteractions + ", contactFirstName="
				+ contactFirstName + ", contactLastName=" + contactLastName + ", email=" + email + ", contactNumber="
				+ contactNumber + "]";
	}

}
