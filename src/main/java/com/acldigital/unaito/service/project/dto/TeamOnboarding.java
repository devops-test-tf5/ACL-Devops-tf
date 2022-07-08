package com.acldigital.unaito.service.project.dto;

import java.util.List;

public class TeamOnboarding {

	private Long onboardingId;

	private Long projectId;

	private List<TeamMember> teamMembers;

	public TeamOnboarding() {

	}

	public TeamOnboarding(Long onboardingId, Long projectId, List<TeamMember> teamMembers) {
		super();
		this.onboardingId = onboardingId;
		this.projectId = projectId;
		this.teamMembers = teamMembers;
	}
	
	public TeamOnboarding(Long projectId, List<TeamMember> teamMembers) {
		super();
		this.projectId = projectId;
		this.teamMembers = teamMembers;
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

	public List<TeamMember> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Override
	public String toString() {
		return "TeamOnboarding [onboardingId=" + onboardingId + ", projectId=" + projectId + ", teamMembers="
				+ teamMembers + "]";
	}

}
