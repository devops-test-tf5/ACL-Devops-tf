package com.acldigital.unaito.service.security.constants;

public enum RoleConstantsEnum {

	PROJECT_MANAGER(1), ACL_STAFF(2), CUSTOMER(3), CLOUD_CONSULTANT(4), TEAM_MEMBER(5);

	private Integer value;

	private RoleConstantsEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
