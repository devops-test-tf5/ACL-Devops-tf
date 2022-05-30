package com.acldigital.unaito.service.user.dto;

public class WorkflowMgmt {

	private Long workflowId;

	private Long projectId;

	private String workflowFrom;

	private String workflowTo;

	private String commentsOrMessage;

	public WorkflowMgmt() {

	}

	public WorkflowMgmt(Long workflowId, Long projectId, String workflowFrom, String workflowTo,
			String commentsOrMessage) {
		super();
		this.workflowId = workflowId;
		this.projectId = projectId;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
		return "WorkflowMgmt [workflowId=" + workflowId + ", projectId=" + projectId + ", workflowFrom=" + workflowFrom
				+ ", workflowTo=" + workflowTo + ", commentsOrMessage=" + commentsOrMessage + "]";
	}

}
