package com.acldigital.unaito.service.user.dto;

public class SecurityCompliance {

	private Long securityComplianceId;

	private Long applicationId;

	private String vpn;

	private String encryption;

	private String proxyServer;

	private String dataPrivacy;

	public SecurityCompliance() {

	}

	public SecurityCompliance(Long securityComplianceId, Long applicationId, String vpn, String encryption,
			String proxyServer, String dataPrivacy) {
		super();
		this.securityComplianceId = securityComplianceId;
		this.applicationId = applicationId;
		this.vpn = vpn;
		this.encryption = encryption;
		this.proxyServer = proxyServer;
		this.dataPrivacy = dataPrivacy;
	}

	public Long getSecurityComplianceId() {
		return securityComplianceId;
	}

	public void setSecurityComplianceId(Long securityComplianceId) {
		this.securityComplianceId = securityComplianceId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
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

	public String getProxyServer() {
		return proxyServer;
	}

	public void setProxyServer(String proxyServer) {
		this.proxyServer = proxyServer;
	}

	public String getDataPrivacy() {
		return dataPrivacy;
	}

	public void setDataPrivacy(String dataPrivacy) {
		this.dataPrivacy = dataPrivacy;
	}

	@Override
	public String toString() {
		return "SecurityCompliance [securityComplianceId=" + securityComplianceId + ", applicationId=" + applicationId
				+ ", vpn=" + vpn + ", encryption=" + encryption + ", proxyServer=" + proxyServer + ", dataPrivacy="
				+ dataPrivacy + "]";
	}
	
	
}
