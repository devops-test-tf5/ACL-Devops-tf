package com.acldigital.unaito.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recommendations")
public class RecommendationsEntity implements Serializable {

	private static final long serialVersionUID = 4819036859843462179L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recommendation_id")
	private Long recommendationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", referencedColumnName = "application_id")
	private ApplicationOverviewEntity applicationEntity;

	@Column(name = "cloud_instance")
	private String cloudInstance;

	@Column(name = "os_name")
	private String osName;

	@Column(name = "os_version")
	private String osVersion;

	@Column(name = "web_server_name")
	private String webServerName;

	@Column(name = "web_server_version")
	private String webServerVersion;

	@Column(name = "migration_approach_type")
	private String migrationApproachType;

	@Column(name = "storage_type")
	private String storageType;

	@Column(name = "target_capacity")
	private String targetCapacity;

	@Column(name = "comments")
	private String comments;

	@Column(name = "cloud_proxy_service")
	private String cloudProxyService;

	@Column(name = "compliance_action")
	private String complianceAction;

	public RecommendationsEntity() {

	}

	public RecommendationsEntity(Long recommendationId, ApplicationOverviewEntity applicationEntity,
			String cloudInstance, String osName, String osVersion, String webServerName, String webServerVersion,
			String migrationApproachType, String storageType, String targetCapacity, String comments,
			String cloudProxyService, String complianceAction) {
		super();
		this.recommendationId = recommendationId;
		this.applicationEntity = applicationEntity;
		this.cloudInstance = cloudInstance;
		this.osName = osName;
		this.osVersion = osVersion;
		this.webServerName = webServerName;
		this.webServerVersion = webServerVersion;
		this.migrationApproachType = migrationApproachType;
		this.storageType = storageType;
		this.targetCapacity = targetCapacity;
		this.comments = comments;
		this.cloudProxyService = cloudProxyService;
		this.complianceAction = complianceAction;
	}

	public Long getRecommendationId() {
		return recommendationId;
	}

	public void setRecommendationId(Long recommendationId) {
		this.recommendationId = recommendationId;
	}

	public ApplicationOverviewEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationOverviewEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	public String getCloudInstance() {
		return cloudInstance;
	}

	public void setCloudInstance(String cloudInstance) {
		this.cloudInstance = cloudInstance;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getWebServerName() {
		return webServerName;
	}

	public void setWebServerName(String webServerName) {
		this.webServerName = webServerName;
	}

	public String getWebServerVersion() {
		return webServerVersion;
	}

	public void setWebServerVersion(String webServerVersion) {
		this.webServerVersion = webServerVersion;
	}

	public String getMigrationApproachType() {
		return migrationApproachType;
	}

	public void setMigrationApproachType(String migrationApproachType) {
		this.migrationApproachType = migrationApproachType;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getTargetCapacity() {
		return targetCapacity;
	}

	public void setTargetCapacity(String targetCapacity) {
		this.targetCapacity = targetCapacity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCloudProxyService() {
		return cloudProxyService;
	}

	public void setCloudProxyService(String cloudProxyService) {
		this.cloudProxyService = cloudProxyService;
	}

	public String getComplianceAction() {
		return complianceAction;
	}

	public void setComplianceAction(String complianceAction) {
		this.complianceAction = complianceAction;
	}

	@Override
	public String toString() {
		return "RecommendationsEntity [recommendationId=" + recommendationId + ", applicationEntity="
				+ applicationEntity + ", cloudInstance=" + cloudInstance + ", osName=" + osName + ", osVersion="
				+ osVersion + ", webServerName=" + webServerName + ", webServerVersion=" + webServerVersion
				+ ", migrationApproachType=" + migrationApproachType + ", storageType=" + storageType
				+ ", targetCapacity=" + targetCapacity + ", comments=" + comments + ", cloudProxyService="
				+ cloudProxyService + ", complianceAction=" + complianceAction + "]";
	}

}
