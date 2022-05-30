package com.acldigital.unaito.service.user.dto;

public class ResourceLoading {

	private Long resourceId;
	
	private Long projectId;
	
	private String resourceName;
	
	public ResourceLoading() {
		
	}

	public ResourceLoading(Long resourceId, Long projectId, String resourceName) {
		super();
		this.resourceId = resourceId;
		this.projectId = projectId;
		this.resourceName = resourceName;
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

	@Override
	public String toString() {
		return "ResourceLoading [resourceId=" + resourceId + ", projectId=" + projectId + ", resourceName="
				+ resourceName + "]";
	}
	
	
}
