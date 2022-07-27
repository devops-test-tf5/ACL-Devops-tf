package com.acldigital.unaito.service.user.dto;

public class ResourceOnboardingPlan {

	private Long resourceId;

	private Long projectId;

	private String resourceName;

	private Integer numberOfResources;

	private String week;

	public ResourceOnboardingPlan() {

	}

	public ResourceOnboardingPlan(Long resourceId, Long projectId, String resourceName, Integer numberOfResources,
			String week) {
		super();
		this.resourceId = resourceId;
		this.projectId = projectId;
		this.resourceName = resourceName;
		this.numberOfResources = numberOfResources;
		this.week = week;
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

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return "ResourceOnboardingPlan [resourceId=" + resourceId + ", projectId=" + projectId + ", resourceName="
				+ resourceName + ", numberOfResources=" + numberOfResources + ", week=" + week + "]";
	}

}
