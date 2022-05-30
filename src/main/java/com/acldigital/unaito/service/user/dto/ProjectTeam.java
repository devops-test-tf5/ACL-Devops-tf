package com.acldigital.unaito.service.user.dto;

public class ProjectTeam {

	private Long onboardingId;

	private Long projectId;

	private String teamMemberName;

	private Long userId;

	private Long roleId;

	private String email;

	public ProjectTeam() {

	}

	public ProjectTeam(Long onboardingId, Long projectId, String teamMemberName, Long userId, Long roleId,
			String email) {
		super();
		this.onboardingId = onboardingId;
		this.projectId = projectId;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
		return "ProjectTeam [onboardingId=" + onboardingId + ", projectId=" + projectId + ", teamMemberName="
				+ teamMemberName + ", userId=" + userId + ", roleId=" + roleId + ", email=" + email + "]";
	}

}
