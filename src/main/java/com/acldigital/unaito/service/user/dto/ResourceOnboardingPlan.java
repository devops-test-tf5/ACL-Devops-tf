package com.acldigital.unaito.service.user.dto;

public class ResourceOnboardingPlan {

	private Long resourceId;

	private Long projectId;

	private String resourceName;

	private Integer numberOfResources;

	public ResourceOnboardingPlan() {

	}

	public ResourceOnboardingPlan(Long resourceId, Long projectId, String resourceName, Integer numberOfResources) {
		super();
		this.resourceId = resourceId;
		this.projectId = projectId;
		this.resourceName = resourceName;
		this.numberOfResources = numberOfResources;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Integer getNumberOfResources() {
		return numberOfResources;
	}

	public void setNumberOfResources(Integer numberOfResources) {
		this.numberOfResources = numberOfResources;
	}

	@Override
	public String toString() {
		return "ResourceLoading [resourceId=" + resourceId + ", projectId=" + projectId + ", resourceName="
				+ resourceName + ", numberOfResources=" + numberOfResources + "]";
	}

}
