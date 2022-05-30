package com.acldigital.unaito.service.user.dto;

public class ServerDetails {

	private Long serverDetailsId;

	private Long applicationId;

	private String serverName;

	private String serverType;

	private String makeOrOem;

	private String configuration;

	private String serverCategory;

	private String serverSubCategory;

	private String region;

	private String cpuGpu;

	private String ram;

	private String ipAddress;

	private String dedicatedTotal;

	private String dedicatedAvailable;

	private String sharedTotal;

	private String sharedAvailable;

	private String virtualized;

	private String virtualizationSoftware;

	private String loadBalancer;

	private String loadBalancerDetails;

	private String osName;

	private String osVersion;

	private String serverCompatibility;

	private String osCompatibility;

	private String dbName;

	private String dbVersion;

	private String model;

	private String dbTechCompatibility;

	public ServerDetails() {

	}

	public ServerDetails(Long serverDetailsId, Long applicationId, String serverName, String serverType,
			String makeOrOem, String configuration, String serverCategory, String serverSubCategory, String region,
			String cpuGpu, String ram, String ipAddress, String dedicatedTotal, String dedicatedAvailable,
			String sharedTotal, String sharedAvailable, String virtualized, String virtualizationSoftware,
			String loadBalancer, String loadBalancerDetails, String osName, String osVersion,
			String serverCompatibility, String osCompatibility, String dbName, String dbVersion, String model,
			String dbTechCompatibility) {
		super();
		this.serverDetailsId = serverDetailsId;
		this.applicationId = applicationId;
		this.serverName = serverName;
		this.serverType = serverType;
		this.makeOrOem = makeOrOem;
		this.configuration = configuration;
		this.serverCategory = serverCategory;
		this.serverSubCategory = serverSubCategory;
		this.region = region;
		this.cpuGpu = cpuGpu;
		this.ram = ram;
		this.ipAddress = ipAddress;
		this.dedicatedTotal = dedicatedTotal;
		this.dedicatedAvailable = dedicatedAvailable;
		this.sharedTotal = sharedTotal;
		this.sharedAvailable = sharedAvailable;
		this.virtualized = virtualized;
		this.virtualizationSoftware = virtualizationSoftware;
		this.loadBalancer = loadBalancer;
		this.loadBalancerDetails = loadBalancerDetails;
		this.osName = osName;
		this.osVersion = osVersion;
		this.serverCompatibility = serverCompatibility;
		this.osCompatibility = osCompatibility;
		this.dbName = dbName;
		this.dbVersion = dbVersion;
		this.model = model;
		this.dbTechCompatibility = dbTechCompatibility;
	}

	public Long getServerDetailsId() {
		return serverDetailsId;
	}

	public void setServerDetailsId(Long serverDetailsId) {
		this.serverDetailsId = serverDetailsId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getMakeOrOem() {
		return makeOrOem;
	}

	public void setMakeOrOem(String makeOrOem) {
		this.makeOrOem = makeOrOem;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public String getServerCategory() {
		return serverCategory;
	}

	public void setServerCategory(String serverCategory) {
		this.serverCategory = serverCategory;
	}

	public String getServerSubCategory() {
		return serverSubCategory;
	}

	public void setServerSubCategory(String serverSubCategory) {
		this.serverSubCategory = serverSubCategory;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCpuGpu() {
		return cpuGpu;
	}

	public void setCpuGpu(String cpuGpu) {
		this.cpuGpu = cpuGpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDedicatedTotal() {
		return dedicatedTotal;
	}

	public void setDedicatedTotal(String dedicatedTotal) {
		this.dedicatedTotal = dedicatedTotal;
	}

	public String getDedicatedAvailable() {
		return dedicatedAvailable;
	}

	public void setDedicatedAvailable(String dedicatedAvailable) {
		this.dedicatedAvailable = dedicatedAvailable;
	}

	public String getSharedTotal() {
		return sharedTotal;
	}

	public void setSharedTotal(String sharedTotal) {
		this.sharedTotal = sharedTotal;
	}

	public String getSharedAvailable() {
		return sharedAvailable;
	}

	public void setSharedAvailable(String sharedAvailable) {
		this.sharedAvailable = sharedAvailable;
	}

	public String getVirtualized() {
		return virtualized;
	}

	public void setVirtualized(String virtualized) {
		this.virtualized = virtualized;
	}

	public String getVirtualizationSoftware() {
		return virtualizationSoftware;
	}

	public void setVirtualizationSoftware(String virtualizationSoftware) {
		this.virtualizationSoftware = virtualizationSoftware;
	}

	public String getLoadBalancer() {
		return loadBalancer;
	}

	public void setLoadBalancer(String loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

	public String getLoadBalancerDetails() {
		return loadBalancerDetails;
	}

	public void setLoadBalancerDetails(String loadBalancerDetails) {
		this.loadBalancerDetails = loadBalancerDetails;
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

	public String getServerCompatibility() {
		return serverCompatibility;
	}

	public void setServerCompatibility(String serverCompatibility) {
		this.serverCompatibility = serverCompatibility;
	}

	public String getOsCompatibility() {
		return osCompatibility;
	}

	public void setOsCompatibility(String osCompatibility) {
		this.osCompatibility = osCompatibility;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbVersion() {
		return dbVersion;
	}

	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDbTechCompatibility() {
		return dbTechCompatibility;
	}

	public void setDbTechCompatibility(String dbTechCompatibility) {
		this.dbTechCompatibility = dbTechCompatibility;
	}

	@Override
	public String toString() {
		return "ServerDetails [serverDetailsId=" + serverDetailsId + ", applicationId=" + applicationId
				+ ", serverName=" + serverName + ", serverType=" + serverType + ", makeOrOem=" + makeOrOem
				+ ", configuration=" + configuration + ", serverCategory=" + serverCategory + ", serverSubCategory="
				+ serverSubCategory + ", region=" + region + ", cpuGpu=" + cpuGpu + ", ram=" + ram + ", ipAddress="
				+ ipAddress + ", dedicatedTotal=" + dedicatedTotal + ", dedicatedAvailable=" + dedicatedAvailable
				+ ", sharedTotal=" + sharedTotal + ", sharedAvailable=" + sharedAvailable + ", virtualized="
				+ virtualized + ", virtualizationSoftware=" + virtualizationSoftware + ", loadBalancer=" + loadBalancer
				+ ", loadBalancerDetails=" + loadBalancerDetails + ", osName=" + osName + ", osVersion=" + osVersion
				+ ", serverCompatibility=" + serverCompatibility + ", osCompatibility=" + osCompatibility + ", dbName="
				+ dbName + ", dbVersion=" + dbVersion + ", model=" + model + ", dbTechCompatibility="
				+ dbTechCompatibility + "]";
	}

}
