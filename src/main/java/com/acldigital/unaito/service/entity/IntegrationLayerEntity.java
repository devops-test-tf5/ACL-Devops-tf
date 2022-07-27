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
@Table(name = "integration_layer_details")
public class IntegrationLayerEntity implements Serializable {

	private static final long serialVersionUID = 8159515671006643335L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "integration_layer_id")
	private Long integrationLayerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", referencedColumnName = "application_id")
	private ApplicationOverviewEntity applicationOverviewEntity;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "project_id", referencedColumnName = "project_id") private
	 * ProjectsEntity projectsEntity;
	 */
	@Column(name = "target_application")
	private String targetApplication;

	@Column(name = "bandwidth")
	private String bandwidth;

	@Column(name = "vpn")
	private String vpn;

	@Column(name = "encryption")
	private String encryption;

	public IntegrationLayerEntity() {

	}

	public IntegrationLayerEntity(Long integrationLayerId, ApplicationOverviewEntity applicationOverviewEntity,
			//ProjectsEntity projectsEntity, 
			String targetApplication, String bandwidth, String vpn, String encryption) {
		super();
		this.integrationLayerId = integrationLayerId;
		this.applicationOverviewEntity = applicationOverviewEntity;
		//this.projectsEntity = projectsEntity;
		this.targetApplication = targetApplication;
		this.bandwidth = bandwidth;
		this.vpn = vpn;
		this.encryption = encryption;
	}

	public IntegrationLayerEntity(ApplicationOverviewEntity applicationOverviewEntity) {
		this.applicationOverviewEntity = applicationOverviewEntity;

	}

	public Long getIntegrationLayerId() {
		return integrationLayerId;
	}

	public void setIntegrationLayerId(Long integrationLayerId) {
		this.integrationLayerId = integrationLayerId;
	}

	public ApplicationOverviewEntity getApplicationOverviewEntity() {
		return applicationOverviewEntity;
	}

	public void setApplicationOverviewEntity(ApplicationOverviewEntity applicationOverviewEntity) {
		this.applicationOverviewEntity = applicationOverviewEntity;
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

	/*
	 * public ProjectsEntity getProjectsEntity() { return projectsEntity; }
	 * 
	 * public void setProjectsEntity(ProjectsEntity projectsEntity) {
	 * this.projectsEntity = projectsEntity; }
	 */

	@Override
	public String toString() {
		return "IntegrationLayerEntity [integrationLayerId=" + integrationLayerId + ", applicationOverviewEntity="
				+ applicationOverviewEntity + ", "
					//	+ "projectsEntity=" + projectsEntity + ","
								+ " targetApplication="
				+ targetApplication + ", bandwidth=" + bandwidth + ", vpn=" + vpn + ", encryption=" + encryption + "]";
	}

}
