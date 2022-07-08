package com.acldigital.unaito.service.user.dto;

import java.util.List;

import com.acldigital.unaito.service.project.dto.TeamMember;

public class ProjectTeam {

	private Long onboardingId;

	private Long projectId;

	private List<TeamMember> teamMembersList;

	public ProjectTeam() {

	}

	public ProjectTeam(Long onboardingId, Long projectId, List<TeamMember> teamMembersList) {
		super();
		this.onboardingId = onboardingId;
		this.projectId = projectId;
		this.teamMembersList = teamMembersList;
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

	public List<TeamMember> getTeamMembersList() {
		return teamMembersList;
	}

	public void setTeamMembersList(List<TeamMember> teamMembersList) {
		this.teamMembersList = teamMembersList;
	}

	@Override
	public String toString() {
		return "ProjectTeam [onboardingId=" + onboardingId + ", projectId=" + projectId + ", teamMembersList="
				+ teamMembersList + "]";
	}

}
