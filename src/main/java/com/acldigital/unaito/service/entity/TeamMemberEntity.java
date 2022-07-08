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

import org.apache.commons.lang3.builder.ToStringExclude;

@Entity
@Table(name = "team_members")
public class TeamMemberEntity implements Serializable {

	private static final long serialVersionUID = 5709547461958872892L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_member_id")
	private Long teamMemberId;

	@ToStringExclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "onboarding_id", referencedColumnName = "onboarding_id")
	private ProjectTeamEntity projectTeamEntity;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "email")
	private String email;

	public TeamMemberEntity() {

	}

	public TeamMemberEntity(String memberName, Long userId, Long roleId, String email) {
		super();
		this.memberName = memberName;
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
	}

	public Long getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(Long teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public ProjectTeamEntity getProjectTeamEntity() {
		return projectTeamEntity;
	}

	public void setProjectTeamEntity(ProjectTeamEntity projectTeamEntity) {
		this.projectTeamEntity = projectTeamEntity;
	}

	@Override
	public String toString() {
		return "TeamMemberEntity [teamMemberId=" + teamMemberId + ", memberName=" + memberName + ", userId=" + userId
				+ ", roleId=" + roleId + ", email=" + email + "]";
	}

}
