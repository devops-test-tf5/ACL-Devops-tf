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
@Table(name = "storage_details")
public class StorageDetailsEntity implements Serializable {

	private static final long serialVersionUID = 4610086178516101793L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storage_id")
	private Long storageId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", referencedColumnName = "application_id")
	private ApplicationOverviewEntity applicationOverviewEntity;

	@Column(name = "total_storage")
	private String totalStorage;

	@Column(name = "storage_used")
	private String storageUsed;

	@Column(name = "storage_available")
	private String storageAvailable;

	@Column(name = "storage_type")
	private String storageType;

	@Column(name = "storage_device_name")
	private String storageDeviceName;

	@Column(name = "ip_address")
	private String ipAddress;

	public StorageDetailsEntity() {

	}

	public StorageDetailsEntity(Long storageId, ApplicationOverviewEntity applicationOverviewEntity,
			String totalStorage, String storageUsed, String storageAvailable, String storageType,
			String storageDeviceName, String ipAddress) {
		super();
		this.storageId = storageId;
		this.applicationOverviewEntity = applicationOverviewEntity;
		this.totalStorage = totalStorage;
		this.storageUsed = storageUsed;
		this.storageAvailable = storageAvailable;
		this.storageType = storageType;
		this.storageDeviceName = storageDeviceName;
		this.ipAddress = ipAddress;
	}

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public ApplicationOverviewEntity getApplicationOverviewEntity() {
		return applicationOverviewEntity;
	}

	public void setApplicationOverviewEntity(ApplicationOverviewEntity applicationOverviewEntity) {
		this.applicationOverviewEntity = applicationOverviewEntity;
	}

	public String getTotalStorage() {
		return totalStorage;
	}

	public void setTotalStorage(String totalStorage) {
		this.totalStorage = totalStorage;
	}

	public String getStorageUsed() {
		return storageUsed;
	}

	public void setStorageUsed(String storageUsed) {
		this.storageUsed = storageUsed;
	}

	public String getStorageAvailable() {
		return storageAvailable;
	}

	public void setStorageAvailable(String storageAvailable) {
		this.storageAvailable = storageAvailable;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getStorageDeviceName() {
		return storageDeviceName;
	}

	public void setStorageDeviceName(String storageDeviceName) {
		this.storageDeviceName = storageDeviceName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "StorageDetailsEntity [storageId=" + storageId + ", applicationOverviewEntity="
				+ applicationOverviewEntity + ", totalStorage=" + totalStorage + ", storageUsed=" + storageUsed
				+ ", storageAvailable=" + storageAvailable + ", storageType=" + storageType + ", storageDeviceName="
				+ storageDeviceName + ", ipAddress=" + ipAddress + "]";
	}

}
