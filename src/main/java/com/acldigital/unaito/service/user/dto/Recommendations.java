package com.acldigital.unaito.service.user.dto;

public class Recommendations {

	private Long recommendationId;

	private Long applicationId;

	private String cloudInstance;

	private String osName;

	private String osVersion;

	private String serverName;

	private String serverVersion;

	private String migrationApproachType;

	private String storageType;

	private String targetCapacity;

	private String comments;

	private String cloudProxyService;

	private String complianceAction;

	public Recommendations() {

	}

	public Recommendations(Long recommendationId, Long applicationId, String cloudInstance, String osName,
			String osVersion, String serverName, String serverVersion, String migrationApproachType, String storageType,
			String targetCapacity, String comments, String cloudProxyService, String complianceAction) {
		super();
		this.recommendationId = recommendationId;
		this.applicationId = applicationId;
		this.cloudInstance = cloudInstance;
		this.osName = osName;
		this.osVersion = osVersion;
		this.serverName = serverName;
		this.serverVersion = serverVersion;
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

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
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

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
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
		return "Recommendations [recommendationId=" + recommendationId + ", applicationId=" + applicationId
				+ ", cloudInstance=" + cloudInstance + ", osName=" + osName + ", osVersion=" + osVersion
				+ ", serverName=" + serverName + ", serverVersion=" + serverVersion + ", migrationApproachType="
				+ migrationApproachType + ", storageType=" + storageType + ", targetCapacity=" + targetCapacity
				+ ", comments=" + comments + ", cloudProxyService=" + cloudProxyService + ", complianceAction="
				+ complianceAction + "]";
	}

	
}
