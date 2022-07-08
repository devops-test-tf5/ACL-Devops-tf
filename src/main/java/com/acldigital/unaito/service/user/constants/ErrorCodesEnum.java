package com.acldigital.unaito.service.user.constants;

public enum ErrorCodesEnum {

	NO_ERROR(0), USER_DETAILS_FAILED_TO_CREATE(-9000), USER_DETAILS_FAILED_TO_UPDATE(-9001),
	USER_DETAILS_FAILED_TO_DELETE(-9002), MISSING_REQUIRED_DATA(-9003), INVALID_USER(-9004), INVALID_DATA(-9005);

	private int value;

	private ErrorCodesEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
