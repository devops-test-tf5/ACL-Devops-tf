package com.acldigital.unaito.service.user.exception;

public class UserConstraintValidationException extends RuntimeException {

	private static final long serialVersionUID = 8635662249365177978L;

	private final String message;
	private final Integer httpStatus;

	public UserConstraintValidationException(String message, Integer httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}
}
