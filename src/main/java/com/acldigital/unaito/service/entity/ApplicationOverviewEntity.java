
package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "application_details")
public class ApplicationOverviewEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private Long applicationId;

	@Column(name = "application_name")
	private String applicationName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private ProjectsEntity projectEntity;

	@Column(name = "description")
	private String description;

	@Column(name = "business_unit")
	private String businessUnit;

	@Column(name = "business_critical")
	private String businessCritical;

	@Column(name = "high_availability")
	private String highAvailability;

	@Column(name = "response_time")
	private String responseTime;

	@Column(name = "no_of_interactions")
	private Integer noOfInteractions;

	@Column(name = "contact_first_name")
	private String contactFirstName;

	@Column(name = "contact_last_name")
	private String contactLastName;

	@Column(name = "email")
	private String email;

	@Column(name = "contact_number")
	private Integer contactNumber;

	@OneToMany(mappedBy = "recommendationId", cascade = CascadeType.ALL)
	private List<RecommendationsEntity> recommendationEntities = new ArrayList<>();

	@OneToMany(mappedBy = "integrationLayerId", cascade = CascadeType.ALL)
	private List<IntegrationLayerEntity> integrationLayerEntities = new ArrayList<>();

	@OneToMany(mappedBy = "applicationLayerId", cascade = CascadeType.ALL)
	private List<ApplicationLayerEntity> applicationLayerEntities = new ArrayList<>();

	@OneToMany(mappedBy = "storageId", cascade = CascadeType.ALL)
	private List<StorageDetailsEntity> storageEntities = new ArrayList<>();

	@OneToMany(mappedBy = "serverDetailsId", cascade = CascadeType.ALL)
	private List<ServerDetailsEntity> serverDetailEntities = new ArrayList<>();

	@OneToMany(mappedBy = "securityComplianceId", cascade = CascadeType.ALL)
	private List<SecurityComplianceEntity> securityComplianceEntities = new ArrayList<>();

	public ApplicationOverviewEntity() {

	}

	public ApplicationOverviewEntity(Long applicationId, String applicationName, ProjectsEntity projectEntity,
			String description, String businessUnit, String businessCritical, String highAvailability,
			String responseTime, Integer noOfInteractions, String contactFirstName, String contactLastName,
			String email, Integer contactNumber, List<RecommendationsEntity> recommendationEntities,
			List<IntegrationLayerEntity> integrationLayerEntities,
			List<ApplicationLayerEntity> applicationLayerEntities, List<StorageDetailsEntity> storageEntities,
			List<ServerDetailsEntity> serverDetailEntities, List<SecurityComplianceEntity> securityComplianceEntities) {
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
		this.recommendationEntities = recommendationEntities;
		this.integrationLayerEntities = integrationLayerEntities;
		this.applicationLayerEntities = applicationLayerEntities;
		this.storageEntities = storageEntities;
		this.serverDetailEntities = serverDetailEntities;
		this.securityComplianceEntities = securityComplianceEntities;
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

	public List<RecommendationsEntity> getRecommendationEntities() {
		return recommendationEntities;
	}

	public void setRecommendationEntities(List<RecommendationsEntity> recommendationEntities) {
		this.recommendationEntities = recommendationEntities;
	}

	public List<IntegrationLayerEntity> getIntegrationLayerEntities() {
		return integrationLayerEntities;
	}

	public void setIntegrationLayerEntities(List<IntegrationLayerEntity> integrationLayerEntities) {
		this.integrationLayerEntities = integrationLayerEntities;
	}

	public List<ApplicationLayerEntity> getApplicationLayerEntities() {
		return applicationLayerEntities;
	}

	public void setApplicationLayerEntities(List<ApplicationLayerEntity> applicationLayerEntities) {
		this.applicationLayerEntities = applicationLayerEntities;
	}

	public List<StorageDetailsEntity> getStorageEntities() {
		return storageEntities;
	}

	public void setStorageEntities(List<StorageDetailsEntity> storageEntities) {
		this.storageEntities = storageEntities;
	}

	public List<ServerDetailsEntity> getServerDetailEntities() {
		return serverDetailEntities;
	}

	public void setServerDetailEntities(List<ServerDetailsEntity> serverDetailEntities) {
		this.serverDetailEntities = serverDetailEntities;
	}

	public List<SecurityComplianceEntity> getSecurityComplianceEntities() {
		return securityComplianceEntities;
	}

	public void setSecurityComplianceEntities(List<SecurityComplianceEntity> securityComplianceEntities) {
		this.securityComplianceEntities = securityComplianceEntities;
	}

}
