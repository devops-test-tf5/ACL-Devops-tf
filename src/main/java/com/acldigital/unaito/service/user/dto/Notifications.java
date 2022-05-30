package com.acldigital.unaito.service.user.dto;

public class Notifications {

	private Long notificationId;

	private Long projectId;

	private String notifyFrom;

	private String notifyTo;

	private String message;

	public Notifications() {

	}

	public Notifications(Long notificationId, Long projectId, String notifyFrom, String notifyTo, String message) {
		super();
		this.notificationId = notificationId;
		this.projectId = projectId;
		this.notifyFrom = notifyFrom;
		this.notifyTo = notifyTo;
		this.message = message;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getNotifyFrom() {
		return notifyFrom;
	}

	public void setNotifyFrom(String notifyFrom) {
		this.notifyFrom = notifyFrom;
	}

	public String getNotifyTo() {
		return notifyTo;
	}

	public void setNotifyTo(String notifyTo) {
		this.notifyTo = notifyTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notifications [notificationId=" + notificationId + ", projectId=" + projectId + ", notifyFrom="
				+ notifyFrom + ", notifyTo=" + notifyTo + ", message=" + message + "]";
	}

}
