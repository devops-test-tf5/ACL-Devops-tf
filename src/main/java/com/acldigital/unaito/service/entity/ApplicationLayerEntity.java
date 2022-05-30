
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
@Table(name = "application_layer_details")
public class ApplicationLayerEntity implements Serializable {

	private static final long serialVersionUID = 5137966439837381962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_layer_id")
	private Long applicationLayerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", referencedColumnName = "application_id")
	private ApplicationOverviewEntity applicationOverviewEntity;

	@Column(name = "current_application_technology")
	private String currentApplicationTechnology;

	@Column(name = "technology_used")
	private String technologyUsed;

	@Column(name = "architecture")
	private String architecture;

	@Column(name = "functionalities")
	private String functionalities;

	@Column(name = "re_architectures")
	private String reArchitectures;

	@Column(name = "new_functionality")
	private String newFunctionality;

	@Column(name = "future_functionality")
	private String futureFunctionality;

	public ApplicationLayerEntity() {

	}

	public ApplicationLayerEntity(Long applicationLayerId, ApplicationOverviewEntity applicationOverviewEntity,
			String currentApplicationTechnology, String technologyUsed, String architecture, String functionalities,
			String reArchitectures, String newFunctionality, String futureFunctionality) {
		super();
		this.applicationLayerId = applicationLayerId;
		this.applicationOverviewEntity = applicationOverviewEntity;
		this.currentApplicationTechnology = currentApplicationTechnology;
		this.technologyUsed = technologyUsed;
		this.architecture = architecture;
		this.functionalities = functionalities;
		this.reArchitectures = reArchitectures;
		this.newFunctionality = newFunctionality;
		this.futureFunctionality = futureFunctionality;
	}

	public Long getApplicationLayerId() {
		return applicationLayerId;
	}

	public void setApplicationLayerId(Long applicationLayerId) {
		this.applicationLayerId = applicationLayerId;
	}

	public ApplicationOverviewEntity getApplicationOverviewEntity() {
		return applicationOverviewEntity;
	}

	public void setApplicationOverviewEntity(ApplicationOverviewEntity applicationOverviewEntity) {
		this.applicationOverviewEntity = applicationOverviewEntity;
	}

	public String getCurrentApplicationTechnology() {
		return currentApplicationTechnology;
	}

	public void setCurrentApplicationTechnology(String currentApplicationTechnology) {
		this.currentApplicationTechnology = currentApplicationTechnology;
	}

	public String getTechnologyUsed() {
		return technologyUsed;
	}

	public void setTechnologyUsed(String technologyUsed) {
		this.technologyUsed = technologyUsed;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(String functionalities) {
		this.functionalities = functionalities;
	}

	public String getReArchitectures() {
		return reArchitectures;
	}

	public void setReArchitectures(String reArchitectures) {
		this.reArchitectures = reArchitectures;
	}

	public String getNewFunctionality() {
		return newFunctionality;
	}

	public void setNewFunctionality(String newFunctionality) {
		this.newFunctionality = newFunctionality;
	}

	public String getFutureFunctionality() {
		return futureFunctionality;
	}

	public void setFutureFunctionality(String futureFunctionality) {
		this.futureFunctionality = futureFunctionality;
	}

	@Override
	public String toString() {
		return "ApplicationLayerEntity [applicationLayerId=" + applicationLayerId + ", applicationOverviewEntity="
				+ applicationOverviewEntity + ", currentApplicationTechnology=" + currentApplicationTechnology
				+ ", technologyUsed=" + technologyUsed + ", architecture=" + architecture + ", functionalities="
				+ functionalities + ", reArchitectures=" + reArchitectures + ", newFunctionality=" + newFunctionality
				+ ", futureFunctionality=" + futureFunctionality + "]";
	}

}
