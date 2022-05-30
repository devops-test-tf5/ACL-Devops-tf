package com.acldigital.unaito.service.user.dto;

public class StorageDetails {

	private Long storageId;

	private Long applicationId;

	private String totalStorage;

	private String storageUsed;

	private String storageAvailable;

	private String storageType;

	private String storageDeviceName;

	private String ipAddress;

	public StorageDetails() {

	}

	public StorageDetails(Long storageId, Long applicationId, String totalStorage, String storageUsed,
			String storageAvailable, String storageType, String storageDeviceName, String ipAddress) {
		super();
		this.storageId = storageId;
		this.applicationId = applicationId;
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

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
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
		return "StorageDetails [storageId=" + storageId + ", applicationId=" + applicationId + ", totalStorage="
				+ totalStorage + ", storageUsed=" + storageUsed + ", storageAvailable=" + storageAvailable
				+ ", storageType=" + storageType + ", storageDeviceName=" + storageDeviceName + ", ipAddress="
				+ ipAddress + "]";
	}

}
