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
@Table(name = "security_compliance")
public class SecurityComplianceEntity implements Serializable {

	private static final long serialVersionUID = 3686702948872359702L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "security_compliance_id")
	private Long securityComplianceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", referencedColumnName = "application_id")
	private ApplicationOverviewEntity applicationOverviewEntity;

	@Column(name = "vpn")
	private String vpn;

	@Column(name = "encryption")
	private String encryption;

	@Column(name = "proxy_server")
	private String proxyServer;

	@Column(name = "data_privacy")
	private String dataPrivacy;

	public SecurityComplianceEntity() {

	}

	public SecurityComplianceEntity(Long securityComplianceId, ApplicationOverviewEntity applicationOverviewEntity,
			String vpn, String encryption, String proxyServer, String dataPrivacy) {
		super();
		this.securityComplianceId = securityComplianceId;
		this.applicationOverviewEntity = applicationOverviewEntity;
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

	public ApplicationOverviewEntity getApplicationOverviewEntity() {
		return applicationOverviewEntity;
	}

	public void setApplicationOverviewEntity(ApplicationOverviewEntity applicationOverviewEntity) {
		this.applicationOverviewEntity = applicationOverviewEntity;
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
		return "SecurityComplianceEntity [securityComplianceId=" + securityComplianceId + ", applicationOverviewEntity="
				+ applicationOverviewEntity + ", vpn=" + vpn + ", encryption=" + encryption + ", proxyServer="
				+ proxyServer + ", dataPrivacy=" + dataPrivacy + "]";
	}

}
