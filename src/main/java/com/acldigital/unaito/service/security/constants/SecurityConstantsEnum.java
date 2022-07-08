package com.acldigital.unaito.service.security.constants;

public enum SecurityConstantsEnum {

	JSESSIONID("JSESSIONID"), PLAYERTYPE("PLAYERTYPE"), NEW("NEW"), REFRESH("REFRESH"), INVALID("INVALID");

	private String value;

	private SecurityConstantsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
