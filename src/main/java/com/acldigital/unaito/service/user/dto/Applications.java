package com.acldigital.unaito.service.user.dto;

import java.util.List;

public class Applications {

	private Long applicationId;

	private Long projectId;

	private String applicationName;

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

	private List<Recommendations> recommendationsList;

	private List<IntegrationLayerDetails> integrationLayerDetailsList;

	private List<ApplicationLayerDetails> applicationLayerDetailsList;

	private List<StorageDetails> storageDetailsList;

	private List<ServerDetails> serverDetailsList;

	private List<SecurityCompliance> securityComplianceList;

	public Applications() {

	}

	public Applications(Long applicationId, Long projectId, String applicationName, String description,
			String businessUnit, String businessCritical, String highAvailability, String responseTime,
			Integer noOfInteractions, String contactFirstName, String contactLastName, String email,
			Integer contactNumber, List<Recommendations> recommendationsList,
			List<IntegrationLayerDetails> integrationLayerDetailsList,
			List<ApplicationLayerDetails> applicationLayerDetailsList, List<StorageDetails> storageDetailsList,
			List<ServerDetails> serverDetailsList, List<SecurityCompliance> securityComplianceList) {
		super();
		this.applicationId = applicationId;
		this.projectId = projectId;
		this.applicationName = applicationName;
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
		this.recommendationsList = recommendationsList;
		this.integrationLayerDetailsList = integrationLayerDetailsList;
		this.applicationLayerDetailsList = applicationLayerDetailsList;
		this.storageDetailsList = storageDetailsList;
		this.serverDetailsList = serverDetailsList;
		this.securityComplianceList = securityComplianceList;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
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

	public List<Recommendations> getRecommendationsList() {
		return recommendationsList;
	}

	public void setRecommendationsList(List<Recommendations> recommendationsList) {
		this.recommendationsList = recommendationsList;
	}

	public List<IntegrationLayerDetails> getIntegrationLayerDetailsList() {
		return integrationLayerDetailsList;
	}

	public void setIntegrationLayerDetailsList(List<IntegrationLayerDetails> integrationLayerDetailsList) {
		this.integrationLayerDetailsList = integrationLayerDetailsList;
	}

	public List<ApplicationLayerDetails> getApplicationLayerDetailsList() {
		return applicationLayerDetailsList;
	}

	public void setApplicationLayerDetailsList(List<ApplicationLayerDetails> applicationLayerDetailsList) {
		this.applicationLayerDetailsList = applicationLayerDetailsList;
	}

	public List<StorageDetails> getStorageDetailsList() {
		return storageDetailsList;
	}

	public void setStorageDetailsList(List<StorageDetails> storageDetailsList) {
		this.storageDetailsList = storageDetailsList;
	}

	public List<ServerDetails> getServerDetailsList() {
		return serverDetailsList;
	}

	public void setServerDetailsList(List<ServerDetails> serverDetailsList) {
		this.serverDetailsList = serverDetailsList;
	}

	public List<SecurityCompliance> getSecurityComplianceList() {
		return securityComplianceList;
	}

	public void setSecurityComplianceList(List<SecurityCompliance> securityComplianceList) {
		this.securityComplianceList = securityComplianceList;
	}

	@Override
	public String toString() {
		return "Applications [applicationId=" + applicationId + ", projectId=" + projectId + ", applicationName="
				+ applicationName + ", description=" + description + ", businessUnit=" + businessUnit
				+ ", businessCritical=" + businessCritical + ", highAvailability=" + highAvailability
				+ ", responseTime=" + responseTime + ", noOfInteractions=" + noOfInteractions + ", contactFirstName="
				+ contactFirstName + ", contactLastName=" + contactLastName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", recommendationsList=" + recommendationsList + ", integrationLayerDetailsList="
				+ integrationLayerDetailsList + ", applicationLayerDetailsList=" + applicationLayerDetailsList
				+ ", storageDetailsList=" + storageDetailsList + ", serverDetailsList=" + serverDetailsList
				+ ", securityComplianceList=" + securityComplianceList + "]";
	}

}
