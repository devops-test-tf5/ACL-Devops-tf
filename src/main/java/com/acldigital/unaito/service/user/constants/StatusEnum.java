package com.acldigital.unaito.service.user.constants;

public enum StatusEnum {

	NEW("1"), RETRY("2"), MAX_RETRY_CONSUMED("3"), SENT("4"), VERIFIED("5"), FAILED("6"), IN_REVIEW("7"), REVIEWED("8"), APPROVED("9");

	private String value;

	private StatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
