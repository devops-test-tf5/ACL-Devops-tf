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
@Table(name = "resource_loading")
public class ResourceLoadingEntity implements Serializable {

	private static final long serialVersionUID = 6186730544928658560L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_id")
	private Long resourceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private ProjectsEntity projectEntity;

	@Column(name = "resource_name")
	private String resourceName;

	public ResourceLoadingEntity() {

	}

	public ResourceLoadingEntity(Long resourceId, ProjectsEntity projectEntity, String resourceName) {
		super();
		this.resourceId = resourceId;
		this.projectEntity = projectEntity;
		this.resourceName = resourceName;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public ProjectsEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectsEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Override
	public String toString() {
		return "ResourceLoadingEntity [resourceId=" + resourceId + ", projectEntity=" + projectEntity
				+ ", resourceName=" + resourceName + "]";
	}

}
