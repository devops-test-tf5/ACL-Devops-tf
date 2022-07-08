package com.acldigital.unaito.service.user.constants;

public enum HttpConstantsEnum {

	HEADER_APIKEY("API-KEY"), HEADER_BEARER("Bearer"), AUTHORIZATION("Authorization");

	private String value;

	private HttpConstantsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
