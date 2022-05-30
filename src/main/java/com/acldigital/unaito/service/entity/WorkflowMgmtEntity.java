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
@Table(name = "workflow_mgmt")
public class WorkflowMgmtEntity implements Serializable{

	private static final long serialVersionUID = 704298539793776374L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workflow_id")
	private Long workflowId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private ProjectsEntity projectEntity;
	
	@Column(name = "workflow_from")
	private String workflowFrom;

	@Column(name = "workflow_to")
	private String workflowTo;

	@Column(name = "comments_or_message")
	private String commentsOrMessage;
	
	public WorkflowMgmtEntity() {
		
	}

	public WorkflowMgmtEntity(Long workflowId, ProjectsEntity projectEntity, String workflowFrom, String workflowTo,
			String commentsOrMessage) {
		super();
		this.workflowId = workflowId;
		this.projectEntity = projectEntity;
		this.workflowFrom = workflowFrom;
		this.workflowTo = workflowTo;
		this.commentsOrMessage = commentsOrMessage;
	}

	public Long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	public ProjectsEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectsEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public String getWorkflowFrom() {
		return workflowFrom;
	}

	public void setWorkflowFrom(String workflowFrom) {
		this.workflowFrom = workflowFrom;
	}

	public String getWorkflowTo() {
		return workflowTo;
	}

	public void setWorkflowTo(String workflowTo) {
		this.workflowTo = workflowTo;
	}

	public String getCommentsOrMessage() {
		return commentsOrMessage;
	}

	public void setCommentsOrMessage(String commentsOrMessage) {
		this.commentsOrMessage = commentsOrMessage;
	}

	@Override
	public String toString() {
		return "WorkflowMgmtEntity [workflowId=" + workflowId + ", projectEntity=" + projectEntity + ", workflowFrom="
				+ workflowFrom + ", workflowTo=" + workflowTo + ", commentsOrMessage=" + commentsOrMessage + "]";
	}

	
	
	
}
