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
@Table(name = "notifications")
public class NotificationsEntity implements Serializable {

	private static final long serialVersionUID = 4909824274030680540L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private Long notificationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private ProjectsEntity projectEntity;

	@Column(name = "notify_from")
	private String notifyFrom;

	@Column(name = "notify_to")
	private String notifyTo;

	@Column(name = "message")
	private String message;

	public NotificationsEntity() {

	}

	public NotificationsEntity(Long notificationId, ProjectsEntity projectEntity, String notifyFrom, String notifyTo,
			String message) {
		super();
		this.notificationId = notificationId;
		this.projectEntity = projectEntity;
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

	public ProjectsEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectsEntity projectEntity) {
		this.projectEntity = projectEntity;
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
		return "NotificationsEntity [notificationId=" + notificationId + ", projectEntity=" + projectEntity
				+ ", notifyFrom=" + notifyFrom + ", notifyTo=" + notifyTo + ", message=" + message + "]";
	}

}
