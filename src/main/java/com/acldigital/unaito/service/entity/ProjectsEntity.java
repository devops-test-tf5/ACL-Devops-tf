
package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private CustomersEntity customersEntity;

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

	/*
	 * @Column(name = "drivers") private Json drivers;
	 * 
	 * @Column(name = "scope") private JsonNode scope;
	 */

	@OneToMany(mappedBy = "applicationId", cascade = CascadeType.ALL)
	private List<ApplicationOverviewEntity> applicationsList;

	@Column(name = "user_id")
	private Long userId;

	@OneToMany(mappedBy = "activityId", cascade = CascadeType.ALL)
	private List<ActivityPlanEntity> activityPlanEntities = new ArrayList<>();

	@OneToMany(mappedBy = "resourceId", cascade = CascadeType.ALL)
	private List<ResourceLoadingEntity> resourceLoadingEntities = new ArrayList<>();

	@OneToMany(mappedBy = "onboardingId", cascade = CascadeType.ALL)
	private List<ProjectTeamEntity> projectTeamEntities = new ArrayList<>();

	@OneToMany(mappedBy = "workflowId", cascade = CascadeType.ALL)
	private List<WorkflowMgmtEntity> workflowMgmtEntities = new ArrayList<>();

	@OneToMany(mappedBy = "notificationId", cascade = CascadeType.ALL)
	private List<NotificationsEntity> notificationEntities = new ArrayList<>();

	public ProjectsEntity() {

	}

	public ProjectsEntity(Long projectId, CustomersEntity customersEntity, Long statusId, String projectName,
			String description, Date startDate, Date endDate, String duration, Long userId,
			List<ActivityPlanEntity> activityPlanEntities) {
		super();
		this.projectId = projectId;
		this.customersEntity = customersEntity;
		this.statusId = statusId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.userId = userId;
		this.activityPlanEntities = activityPlanEntities;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public CustomersEntity getCustomersEntity() {
		return customersEntity;
	}

	public void setCustomersEntity(CustomersEntity customersEntity) {
		this.customersEntity = customersEntity;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<ActivityPlanEntity> getActivityPlanEntities() {
		return activityPlanEntities;
	}

	public void setActivityPlanEntities(List<ActivityPlanEntity> activityPlanEntities) {
		this.activityPlanEntities = activityPlanEntities;
	}

	@Override
	public String toString() {
		return "ProjectsEntity [projectId=" + projectId + ", customersEntity=" + customersEntity + ", statusId="
				+ statusId + ", projectName=" + projectName + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", duration=" + duration + ", userId=" + userId
				+ ", activityPlanEntities=" + activityPlanEntities + "]";
	}

}
