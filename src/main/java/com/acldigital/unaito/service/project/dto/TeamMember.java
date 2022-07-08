package com.acldigital.unaito.service.project.dto;

public class TeamMember {

	private Long memberId;
	private String memberName;
	private Long userId;
	private Long roleId;
	private String email;

	public TeamMember() {

	}

	public TeamMember(String memberName, Long userId, Long roleId, String email) {
		super();
		this.memberName = memberName;
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
	}

	public TeamMember(Long memberId, String memberName, Long userId, Long roleId, String email) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Long getRole() {
		return roleId;
	}

	public void setRole(Long roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "TeamMember [memberId=" + memberId + ", memberName=" + memberName + ", userId=" + userId + ", roleId="
				+ roleId + ", email=" + email + "]";
	}

}
