package com.acldigital.unaito.service.user.dto;

public class Roles {

	private Long roleId;

	private String roleName;

	private int isActive;

	public Roles() {

	}

	public Roles(Long roleId, String roleName, int isActive) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.isActive = isActive;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + ", isActive=" + isActive + "]";
	}

}
