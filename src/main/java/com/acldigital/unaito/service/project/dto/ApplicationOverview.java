package com.acldigital.unaito.service.project.dto;

import java.util.List;

import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Recommendations;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;

public class ApplicationOverview {

	private Long applicationId;

	private String applicationName;

	private Long projectId;

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

	private List<Recommendations> recommendationList;

	private List<IntegrationLayerDetails> integrationLayerList;

	private List<ApplicationLayerDetails> applicationLayerList;

	private List<StorageDetails> storageList;

	private List<ServerDetails> serverDetailList;

	private List<SecurityCompliance> securityComplianceList;

	public ApplicationOverview() {

	}

	public ApplicationOverview(Long applicationId, String applicationName, Long projectId, String description,
			String businessUnit, String businessCritical, String highAvailability, String responseTime,
			Integer noOfInteractions, String contactFirstName, String contactLastName, String email,
			Integer contactNumber) {
		super();
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.projectId = projectId;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	public List<Recommendations> getRecommendationList() {
		return recommendationList;
	}

	public void setRecommendationList(List<Recommendations> recommendationList) {
		this.recommendationList = recommendationList;
	}

	public List<IntegrationLayerDetails> getIntegrationLayerList() {
		return integrationLayerList;
	}

	public void setIntegrationLayerList(List<IntegrationLayerDetails> integrationLayerList) {
		this.integrationLayerList = integrationLayerList;
	}

	public List<ApplicationLayerDetails> getApplicationLayerList() {
		return applicationLayerList;
	}

	public void setApplicationLayerList(List<ApplicationLayerDetails> applicationLayerList) {
		this.applicationLayerList = applicationLayerList;
	}

	public List<StorageDetails> getStorageList() {
		return storageList;
	}

	public void setStorageList(List<StorageDetails> storageList) {
		this.storageList = storageList;
	}

	public List<ServerDetails> getServerDetailList() {
		return serverDetailList;
	}

	public void setServerDetailList(List<ServerDetails> serverDetailList) {
		this.serverDetailList = serverDetailList;
	}

	public List<SecurityCompliance> getSecurityComplianceList() {
		return securityComplianceList;
	}

	public void setSecurityComplianceList(List<SecurityCompliance> securityComplianceList) {
		this.securityComplianceList = securityComplianceList;
	}

	@Override
	public String toString() {
		return "ApplicationOverview [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", projectId=" + projectId + ", description=" + description + ", businessUnit=" + businessUnit
				+ ", businessCritical=" + businessCritical + ", highAvailability=" + highAvailability
				+ ", responseTime=" + responseTime + ", noOfInteractions=" + noOfInteractions + ", contactFirstName="
				+ contactFirstName + ", contactLastName=" + contactLastName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", recommendationList=" + recommendationList + ", integrationLayerList="
				+ integrationLayerList + ", applicationLayerList=" + applicationLayerList + ", storageList="
				+ storageList + ", serverDetailList=" + serverDetailList + ", securityComplianceList="
				+ securityComplianceList + "]";
	}



}
