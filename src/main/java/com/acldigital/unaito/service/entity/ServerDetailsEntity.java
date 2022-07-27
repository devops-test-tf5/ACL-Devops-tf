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
@Table(name = "server_details")
public class ServerDetailsEntity implements Serializable {

	private static final long serialVersionUID = 821992639112950129L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "server_id")
	private Long serverDetailsId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", referencedColumnName = "application_id")
	private ApplicationOverviewEntity applicationOverviewEntity;

	@Column(name = "server_name")
	private String serverName;

	@Column(name = "server_type")
	private String serverType;

	@Column(name = "make_or_oem")
	private String makeOrOem;

	@Column(name = "configuration")
	private String configuration;

	@Column(name = "server_category")
	private String serverCategory;

	@Column(name = "server_sub_category")
	private String serverSubCategory;

	@Column(name = "region")
	private String region;

	@Column(name = "cpu_gpu")
	private String cpuGpu;

	@Column(name = "ram")
	private String ram;

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "dedicated_total")
	private String dedicatedTotal;

	@Column(name = "dedicated_available")
	private String dedicatedAvailable;

	@Column(name = "shared_total")
	private String sharedTotal;

	@Column(name = "shared_available")
	private String sharedAvailable;

	@Column(name = "virtualized")
	private String virtualized;

	@Column(name = "virtualization_software")
	private String virtualizationSoftware;

	@Column(name = "load_balancer")
	private String loadBalancer;

	@Column(name = "load_balancer_details")
	private String loadBalancerDetails;

	@Column(name = "os_name")
	private String osName;

	@Column(name = "os_version")
	private String osVersion;

	@Column(name = "server_compatibility")
	private String serverCompatibility;

	@Column(name = "os_compatibility")
	private String osCompatibility;

	@Column(name = "db_name")
	private String dbName;

	@Column(name = "db_version")
	private String dbVersion;

	@Column(name = "model")
	private String model;

	@Column(name = "db_tech_compatibility")
	private String dbTechCompatibility;

	public ServerDetailsEntity() {

	}

	public ServerDetailsEntity(Long serverDetailsId, ApplicationOverviewEntity applicationOverviewEntity,
			String serverName, String serverType, String makeOrOem, String configuration, String serverCategory,
			String serverSubCategory, String region, String cpuGpu, String ram, String ipAddress, String dedicatedTotal,
			String dedicatedAvailable, String sharedTotal, String sharedAvailable, String virtualized,
			String virtualizationSoftware, String loadBalancer, String loadBalancerDetails, String osName,
			String osVersion, String serverCompatibility, String osCompatibility, String dbName, String dbVersion,
			String model, String dbTechCompatibility) {
		super();
		this.serverDetailsId = serverDetailsId;
		this.applicationOverviewEntity = applicationOverviewEntity;
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

	public ApplicationOverviewEntity getApplicationOverviewEntity() {
		return applicationOverviewEntity;
	}

	public void setApplicationOverviewEntity(ApplicationOverviewEntity applicationOverviewEntity) {
		this.applicationOverviewEntity = applicationOverviewEntity;
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
		return "ServerDetailsEntity [serverDetailsId=" + serverDetailsId + ", applicationOverviewEntity="
				+ applicationOverviewEntity + ", serverName=" + serverName + ", serverType=" + serverType
				+ ", makeOrOem=" + makeOrOem + ", configuration=" + configuration + ", serverCategory=" + serverCategory
				+ ", serverSubCategory=" + serverSubCategory + ", region=" + region + ", cpuGpu=" + cpuGpu + ", ram="
				+ ram + ", ipAddress=" + ipAddress + ", dedicatedTotal=" + dedicatedTotal + ", dedicatedAvailable="
				+ dedicatedAvailable + ", sharedTotal=" + sharedTotal + ", sharedAvailable=" + sharedAvailable
				+ ", virtualized=" + virtualized + ", virtualizationSoftware=" + virtualizationSoftware
				+ ", loadBalancer=" + loadBalancer + ", loadBalancerDetails=" + loadBalancerDetails + ", osName="
				+ osName + ", osVersion=" + osVersion + ", serverCompatibility=" + serverCompatibility
				+ ", osCompatibility=" + osCompatibility + ", dbName=" + dbName + ", dbVersion=" + dbVersion
				+ ", model=" + model + ", dbTechCompatibility=" + dbTechCompatibility + "]";
	}

}
