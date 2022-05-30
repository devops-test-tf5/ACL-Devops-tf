package com.acldigital.unaito.service.user.constants;

public enum JwtConstantsEnum {

	BEARER("Bearer");

	private String value;

	private JwtConstantsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
