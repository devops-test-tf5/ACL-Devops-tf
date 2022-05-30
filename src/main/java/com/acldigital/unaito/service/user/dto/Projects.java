package com.acldigital.unaito.service.user.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Projects {

	private Long projectId;

	private Long customerId;

	private String customerName;

	private String description;

	private List<Applications> applicationsList;

	private Date startDate;

	private Date endDate;

	private String duration;

	private Long statusId;

	private JsonNode drivers;

	private JsonNode scope;

	private List<ActivityPlan> activityPlanList;

	private List<ResourceLoading> resourceLoadingList;

	private ProjectTeam projectTeam;

	private WorkflowMgmt workFlowMgmt;

	private List<Notifications> notificationsList;

	public Projects() {

	}

	public Projects(Long projectId, Long customerId, String customerName, String description,
			List<Applications> applicationsList, Date startDate, Date endDate, String duration, Long statusId,
			JsonNode drivers, JsonNode scope, List<ActivityPlan> activityPlanList,
			List<ResourceLoading> resourceLoadingList, ProjectTeam projectTeam, WorkflowMgmt workFlowMgmt,
			List<Notifications> notificationsList) {
		super();
		this.projectId = projectId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.description = description;
		this.applicationsList = applicationsList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.statusId = statusId;
		this.drivers = drivers;
		this.scope = scope;
		this.activityPlanList = activityPlanList;
		this.resourceLoadingList = resourceLoadingList;
		this.projectTeam = projectTeam;
		this.workFlowMgmt = workFlowMgmt;
		this.notificationsList = notificationsList;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Applications> getApplicationsList() {
		return applicationsList;
	}

	public void setApplicationsList(List<Applications> applicationsList) {
		this.applicationsList = applicationsList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public JsonNode getDrivers() {
		return drivers;
	}

	public void setDrivers(JsonNode drivers) {
		this.drivers = drivers;
	}

	public JsonNode getScope() {
		return scope;
	}

	public void setScope(JsonNode scope) {
		this.scope = scope;
	}

	public List<ActivityPlan> getActivityPlanList() {
		return activityPlanList;
	}

	public void setActivityPlanList(List<ActivityPlan> activityPlanList) {
		this.activityPlanList = activityPlanList;
	}

	public List<ResourceLoading> getResourceLoadingList() {
		return resourceLoadingList;
	}

	public void setResourceLoadingList(List<ResourceLoading> resourceLoadingList) {
		this.resourceLoadingList = resourceLoadingList;
	}

	public ProjectTeam getProjectTeam() {
		return projectTeam;
	}

	public void setProjectTeam(ProjectTeam projectTeam) {
		this.projectTeam = projectTeam;
	}

	public WorkflowMgmt getWorkFlowMgmt() {
		return workFlowMgmt;
	}

	public void setWorkFlowMgmt(WorkflowMgmt workFlowMgmt) {
		this.workFlowMgmt = workFlowMgmt;
	}

	public List<Notifications> getNotificationsList() {
		return notificationsList;
	}

	public void setNotificationsList(List<Notifications> notificationsList) {
		this.notificationsList = notificationsList;
	}

	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", description=" + description + ", applicationsList=" + applicationsList + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", duration=" + duration + ", statusId=" + statusId + ", drivers=" + drivers
				+ ", scope=" + scope + ", activityPlanList=" + activityPlanList + ", resourceLoadingList="
				+ resourceLoadingList + ", projectTeam=" + projectTeam + ", workFlowMgmt=" + workFlowMgmt
				+ ", notificationsList=" + notificationsList + "]";
	}

}
