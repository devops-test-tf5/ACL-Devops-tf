package com.acldigital.unaito.service.user.dto;

public class ActivityPlan {

	private Long activityId;

	private Long projectId;

	private String activities;

	private String week;

	public ActivityPlan() {

	}

	public ActivityPlan(Long activityId, Long projectId, String activities, String week) {
		super();
		this.activityId = activityId;
		this.projectId = projectId;
		this.activities = activities;
		this.week = week;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return "ActivityPlan [activityId=" + activityId + ", projectId=" + projectId + ", activities=" + activities
				+ ", week=" + week + "]";
	}

}
