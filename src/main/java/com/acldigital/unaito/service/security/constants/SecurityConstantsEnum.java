package com.acldigital.unaito.service.security.constants;

public enum SecurityConstantsEnum {

	JSESSIONID("jsessionid"), PLAYERTYPE("playertype"), NEW("new"), REFRESH("REFRESH");

	private String value;

	private SecurityConstantsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
