package com.acldigital.unaito.service.user.dto;

public class IntegrationLayerDetails {

	private Long integrationLayerId;

	private Long applicationId;

	private String targetApplication;

	private String bandwidth;

	private String vpn;

	private String encryption;

	public IntegrationLayerDetails() {

	}

	public IntegrationLayerDetails(Long integrationLayerId, Long applicationId, String targetApplication,
			String bandwidth, String vpn, String encryption) {
		super();
		this.integrationLayerId = integrationLayerId;
		this.applicationId = applicationId;
		this.targetApplication = targetApplication;
		this.bandwidth = bandwidth;
		this.vpn = vpn;
		this.encryption = encryption;
	}

	public Long getIntegrationLayerId() {
		return integrationLayerId;
	}

	public void setIntegrationLayerId(Long integrationLayerId) {
		this.integrationLayerId = integrationLayerId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getTargetApplication() {
		return targetApplication;
	}

	public void setTargetApplication(String targetApplication) {
		this.targetApplication = targetApplication;
	}

	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	public String getVpn() {
		return vpn;
	}

	public void setVpn(String vpn) {
		this.vpn = vpn;
	}

	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	@Override
	public String toString() {
		return "IntegrationLayerDetails [integrationLayerId=" + integrationLayerId + ", applicationId=" + applicationId
				+ ", targetApplication=" + targetApplication + ", bandwidth=" + bandwidth + ", vpn=" + vpn
				+ ", encryption=" + encryption + "]";
	}

}
