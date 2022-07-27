
package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class ProjectsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "status_id")
	private Long statusId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "description")
	private String description;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "duration")
	private String duration;

	@Column(name = "drivers")
	private String drivers;

	@Column(name = "scope")
	private String scope;

	@Column(name = "activity_plans")
	private String activityPlans;

	@Column(name = "resource_plans")
	private String resourcePlans;

	@OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
	private List<ApplicationOverviewEntity> applicationOverviewEntities = new ArrayList<>();
	
	/*
	 * @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL) private
	 * List<IntegrationLayerEntity> integrationLayerEntities = new ArrayList<>();
	 */
	
	/*
	 * @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL) private
	 * List<ActivityPlanEntity> activityPlanEntities = new ArrayList<>();
	 */
	@OneToMany(mappedBy = "projectsEntity", cascade = CascadeType.ALL)
	private List<ProjectTeamEntity> projectTeamEntities = new ArrayList<>();

	/*
	 * @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL) private
	 * List<ResourceOnboardingEntity> resourceOnboardingEntities = new
	 * ArrayList<>();
	 */
	@OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
	private List<WorkflowMgmtEntity> workflowMgmtEntities = new ArrayList<>();

	@OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
	private List<NotificationsEntity> notificationEntities = new ArrayList<>();

	public ProjectsEntity() {

	}

	public ProjectsEntity(Long projectId) {
		this.projectId = projectId;
	}

	public ProjectsEntity(Long customerId, Long statusId, String projectName, String description, Date startDate,
			Date endDate, String duration) {
		super();
		this.customerId = customerId;
		this.statusId = statusId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
	}

	public ProjectsEntity(Long projectId, Long customerId, Long statusId, String projectName, String description,
			Date startDate, Date endDate, String duration, String drivers, String scope, String activityPlans,
			String resourcePlans, List<ApplicationOverviewEntity> applicationOverviewEntities,
			List<ActivityPlanEntity> activityPlanEntities, List<ProjectTeamEntity> projectTeamEntities,
			List<ResourceOnboardingEntity> resourceOnboardingEntities, List<WorkflowMgmtEntity> workflowMgmtEntities,
			List<NotificationsEntity> notificationEntities) {
		super();
		this.projectId = projectId;
		this.customerId = customerId;
		this.statusId = statusId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.drivers = drivers;
		this.scope = scope;
		this.activityPlans = activityPlans;
		this.resourcePlans = resourcePlans;
		this.applicationOverviewEntities = applicationOverviewEntities;
		//this.activityPlanEntities = activityPlanEntities;
		this.projectTeamEntities = projectTeamEntities;
		//this.resourceOnboardingEntities = resourceOnboardingEntities;
		this.workflowMgmtEntities = workflowMgmtEntities;
		this.notificationEntities = notificationEntities;
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

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	/*
	 * public List<ActivityPlanEntity> getActivityPlanEntities() { return
	 * activityPlanEntities; }
	 * 
	 * public void setActivityPlanEntities(List<ActivityPlanEntity>
	 * activityPlanEntities) { this.activityPlanEntities = activityPlanEntities; }
	 */
	public String getDrivers() {
		return drivers;
	}

	public void setDrivers(String drivers) {
		this.drivers = drivers;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public List<ProjectTeamEntity> getProjectTeamEntities() {
		return projectTeamEntities;
	}

	public void setProjectTeamEntities(List<ProjectTeamEntity> projectTeamEntities) {
		this.projectTeamEntities = projectTeamEntities;
	}

	/*
	 * public List<ResourceOnboardingEntity> getResourceOnboardingEntities() {
	 * return resourceOnboardingEntities; }
	 * 
	 * public void setResourceOnboardingEntities(List<ResourceOnboardingEntity>
	 * resourceOnboardingEntities) { this.resourceOnboardingEntities =
	 * resourceOnboardingEntities; }
	 */
	public List<WorkflowMgmtEntity> getWorkflowMgmtEntities() {
		return workflowMgmtEntities;
	}

	public void setWorkflowMgmtEntities(List<WorkflowMgmtEntity> workflowMgmtEntities) {
		this.workflowMgmtEntities = workflowMgmtEntities;
	}

	public List<NotificationsEntity> getNotificationEntities() {
		return notificationEntities;
	}

	public void setNotificationEntities(List<NotificationsEntity> notificationEntities) {
		this.notificationEntities = notificationEntities;
	}

	public List<ApplicationOverviewEntity> getApplicationOverviewEntities() {
		return applicationOverviewEntities;
	}

	public void setApplicationOverviewEntities(List<ApplicationOverviewEntity> applicationOverviewEntities) {
		this.applicationOverviewEntities = applicationOverviewEntities;
	}

	public String getActivityPlans() {
		return activityPlans;
	}

	public void setActivityPlans(String activityPlans) {
		this.activityPlans = activityPlans;
	}

	public String getResourcePlans() {
		return resourcePlans;
	}

	public void setResourcePlans(String resourcePlans) {
		this.resourcePlans = resourcePlans;
	}

	@Override
	public String toString() {
		return "ProjectsEntity [projectId=" + projectId + ", customerId=" + customerId + ", statusId=" + statusId
				+ ", projectName=" + projectName + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", duration=" + duration + ", drivers=" + drivers + ", scope=" + scope
				+ ", activityPlans=" + activityPlans + ", resourcePlans=" + resourcePlans
				+ ", applicationOverviewEntities=" + applicationOverviewEntities + ", projectTeamEntities="
				+ projectTeamEntities + ", workflowMgmtEntities=" + workflowMgmtEntities + ", notificationEntities="
				+ notificationEntities + "]";
	}


}
