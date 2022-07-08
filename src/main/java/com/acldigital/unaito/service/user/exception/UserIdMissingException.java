package com.acldigital.unaito.service.user.exception;

public class UserIdMissingException extends RuntimeException {

	private static final long serialVersionUID = 5296324493274730566L;

	private final String message;
	private final Integer httpStatus;

	public UserIdMissingException(String message, Integer httpStatus) {
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
