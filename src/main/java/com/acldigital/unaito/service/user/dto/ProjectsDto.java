package com.acldigital.unaito.service.user.dto;

import java.util.Date;
import java.util.List;

import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.fasterxml.jackson.databind.JsonNode;

public class ProjectsDto {

	private Long projectId;

	private Long customerId;

	private Long statusId;

	private String projectName;

	private String description;

	private String customerName;

	private Date startDate;

	private Date endDate;

	private String duration;

	private JsonNode drivers;

	private JsonNode scope;

	private JsonNode activityPlans;

	private List<ProjectTeam> projectTeamList;

	private JsonNode resourcePlans;

	private List<Notifications> notificationsList;

	private List<WorkflowMgmt> workflowMgmtList;

	private List<ApplicationOverview> applicationOverviewList;

	public ProjectsDto() {

	}

	public ProjectsDto(Long projectId, Long customerId, String projectName, String customerName, String description,
			Date startDate, Date endDate, String duration, Long statusId) {
		super();
		this.projectId = projectId;
		this.customerId = customerId;
		this.projectName = projectName;
		this.customerName = customerName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.statusId = statusId;
	}

	public ProjectsDto(Long projectId, Long customerId, Long statusId, String projectName, String description,
			String customerName, Date startDate, Date endDate, String duration, JsonNode drivers, JsonNode scope,
			JsonNode activityPlanList, List<ProjectTeam> projectTeamList, JsonNode resourceLoadingList) {
		super();
		this.projectId = projectId;
		this.customerId = customerId;
		this.statusId = statusId;
		this.projectName = projectName;
		this.description = description;
		this.customerName = customerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.drivers = drivers;
		this.scope = scope;
		this.activityPlans = activityPlanList;
		this.projectTeamList = projectTeamList;
		this.resourcePlans = resourceLoadingList;
	}

	public ProjectsDto(Long projectId, Long customerId, Long statusId, String projectName, String description,
			String customerName, Date startDate, Date endDate, String duration, JsonNode drivers, JsonNode scope,
			JsonNode activityPlanList, List<ProjectTeam> projectTeamList, JsonNode resourceLoadingList,
			List<Notifications> notificationsList, List<WorkflowMgmt> workflowMgmtList,
			List<ApplicationOverview> applicationOverviewList) {
		super();
		this.projectId = projectId;
		this.customerId = customerId;
		this.statusId = statusId;
		this.projectName = projectName;
		this.description = description;
		this.customerName = customerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.drivers = drivers;
		this.scope = scope;
		this.activityPlans = activityPlanList;
		this.projectTeamList = projectTeamList;
		this.resourcePlans = resourceLoadingList;
		this.notificationsList = notificationsList;
		this.workflowMgmtList = workflowMgmtList;
		this.applicationOverviewList = applicationOverviewList;
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

	public JsonNode getActivityPlanList() {
		return activityPlans;
	}

	public void setActivityPlanList(JsonNode activityPlanList) {
		this.activityPlans = activityPlanList;
	}

	public JsonNode getResourceLoadingList() {
		return resourcePlans;
	}

	public void setResourceLoadingList(JsonNode resourceLoadingList) {
		this.resourcePlans = resourceLoadingList;
	}

	public List<ProjectTeam> getProjectTeam() {
		return projectTeamList;
	}

	public void setProjectTeam(List<ProjectTeam> projectTeamList) {
		this.projectTeamList = projectTeamList;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Notifications> getNotificationsList() {
		return notificationsList;
	}

	public void setNotificationsList(List<Notifications> notificationsList) {
		this.notificationsList = notificationsList;
	}

	public List<WorkflowMgmt> getWorkflowMgmtList() {
		return workflowMgmtList;
	}

	public void setWorkflowMgmtList(List<WorkflowMgmt> workflowMgmtList) {
		this.workflowMgmtList = workflowMgmtList;
	}

	public List<ProjectTeam> getProjectTeamList() {
		return projectTeamList;
	}

	public void setProjectTeamList(List<ProjectTeam> projectTeamList) {
		this.projectTeamList = projectTeamList;
	}

	public List<ApplicationOverview> getApplicationOverviewList() {
		return applicationOverviewList;
	}

	public void setApplicationOverviewList(List<ApplicationOverview> applicationOverviewList) {
		this.applicationOverviewList = applicationOverviewList;
	}

	@Override
	public String toString() {
		return "ProjectsDto [projectId=" + projectId + ", customerId=" + customerId + ", statusId=" + statusId
				+ ", projectName=" + projectName + ", description=" + description + ", customerName=" + customerName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", duration=" + duration + ", drivers="
				+ drivers + ", scope=" + scope + ", activityPlanList=" + activityPlans + ", projectTeamList="
				+ projectTeamList + ", resourceLoadingList=" + resourcePlans + ", notificationsList="
				+ notificationsList + ", workflowMgmtList=" + workflowMgmtList + ", applicationOverviewList="
				+ applicationOverviewList + "]";
	}

}
