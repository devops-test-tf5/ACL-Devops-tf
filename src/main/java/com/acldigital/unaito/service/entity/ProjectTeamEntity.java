package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "project_team")
public class ProjectTeamEntity implements Serializable {

	private static final long serialVersionUID = 5741746036241304126L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "onboarding_id")
	private Long onboardingId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private ProjectsEntity projectsEntity;

	@OneToMany(mappedBy = "projectTeamEntity", cascade = CascadeType.ALL)
	private List<TeamMemberEntity> teamMembersList = new ArrayList<TeamMemberEntity>();

	public void addTeamMember(TeamMemberEntity teamMembers) {
		teamMembersList.add(teamMembers);
		teamMembers.setProjectTeamEntity(this);
	}

	public void removeTeamMember(TeamMemberEntity teamMemberEntity) {
		teamMembersList.remove(teamMemberEntity);
		teamMemberEntity.setProjectTeamEntity(null);
	}

	public ProjectTeamEntity() {

	}

	public ProjectTeamEntity(ProjectsEntity projectsEntity, List<TeamMemberEntity> teamMembersList) {
		super();
		this.projectsEntity = projectsEntity;
		this.teamMembersList = teamMembersList;
	}

	public Long getOnboardingId() {
		return onboardingId;
	}

	public void setOnboardingId(Long onboardingId) {
		this.onboardingId = onboardingId;
	}

	public ProjectsEntity getProjectsEntity() {
		return projectsEntity;
	}

	public void setProjectsEntity(ProjectsEntity projectsEntity) {
		this.projectsEntity = projectsEntity;
	}

	public List<TeamMemberEntity> getTeamMembersList() {
		return teamMembersList;
	}

	public void setTeamMembersList(List<TeamMemberEntity> teamMembersList) {
		this.teamMembersList = teamMembersList;
	}

	@Override
	public String toString() {
		return "ProjectTeamEntity [onboardingId=" + onboardingId + ", projectsEntity=" + projectsEntity
				+ ", teamMembersList=" + teamMembersList + "]";
	}

}
