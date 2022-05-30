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
@Table(name = "project_team")
public class ProjectTeamEntity implements Serializable {

	private static final long serialVersionUID = 5741746036241304126L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "onboarding_id")
	private Long onboardingId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private ProjectsEntity projectEntity;

	@Column(name = "team_member_name")
	private String teamMemberName;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "email")
	private String email;

	public ProjectTeamEntity() {

	}

	public ProjectTeamEntity(Long onboardingId, ProjectsEntity projectEntity, String teamMemberName, Long userId,
			Long roleId, String email) {
		super();
		this.onboardingId = onboardingId;
		this.projectEntity = projectEntity;
		this.teamMemberName = teamMemberName;
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
	}

	public Long getOnboardingId() {
		return onboardingId;
	}

	public void setOnboardingId(Long onboardingId) {
		this.onboardingId = onboardingId;
	}

	public ProjectsEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectsEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public String getTeamMemberName() {
		return teamMemberName;
	}

	public void setTeamMemberName(String teamMemberName) {
		this.teamMemberName = teamMemberName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ProjectTeamEntity [onboardingId=" + onboardingId + ", projectEntity=" + projectEntity
				+ ", teamMemberName=" + teamMemberName + ", userId=" + userId + ", roleId=" + roleId + ", email="
				+ email + "]";
	}

}
