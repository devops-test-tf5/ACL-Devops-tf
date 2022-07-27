package com.acldigital.unaito.service.user.dto;

public class ApplicationLayerDetails {

	private Long applicationLayerId;

	private Long applicationId;

	private String currentApplicationTechnology;

	private String technologyUsed;

	private String architecture;

	private String functionalities;

	private String reArchitectures;

	private String futureStateReArchitecture;

	private String newFunctionality;

	private String futureFunctionality;

	public ApplicationLayerDetails() {

	}

	public ApplicationLayerDetails(Long applicationLayerId, Long applicationId, String currentApplicationTechnology,
			String technologyUsed, String architecture, String functionalities, String reArchitectures,
			String futureStateReArchitecture, String newFunctionality, String futureFunctionality) {
		super();
		this.applicationLayerId = applicationLayerId;
		this.applicationId = applicationId;
		this.currentApplicationTechnology = currentApplicationTechnology;
		this.technologyUsed = technologyUsed;
		this.architecture = architecture;
		this.functionalities = functionalities;
		this.reArchitectures = reArchitectures;
		this.futureStateReArchitecture = futureStateReArchitecture;
		this.newFunctionality = newFunctionality;
		this.futureFunctionality = futureFunctionality;
	}

	public Long getApplicationLayerId() {
		return applicationLayerId;
	}

	public void setApplicationLayerId(Long applicationLayerId) {
		this.applicationLayerId = applicationLayerId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
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

	public String getFutureStateReArchitecture() {
		return futureStateReArchitecture;
	}

	public void setFutureStateReArchitecture(String futureStateReArchitecture) {
		this.futureStateReArchitecture = futureStateReArchitecture;
	}

	@Override
	public String toString() {
		return "ApplicationLayerDetails [applicationLayerId=" + applicationLayerId + ", applicationId=" + applicationId
				+ ", currentApplicationTechnology=" + currentApplicationTechnology + ", technologyUsed="
				+ technologyUsed + ", architecture=" + architecture + ", functionalities=" + functionalities
				+ ", reArchitectures=" + reArchitectures + ", futureStateReArchitecture=" + futureStateReArchitecture
				+ ", newFunctionality=" + newFunctionality + ", futureFunctionality=" + futureFunctionality + "]";
	}

}
