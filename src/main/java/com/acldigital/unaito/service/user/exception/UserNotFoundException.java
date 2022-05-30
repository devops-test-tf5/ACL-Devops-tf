package com.acldigital.unaito.service.user.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4260973376516530157L;
	private final String message;
	private final Integer httpStatus;

	public UserNotFoundException(String message, Integer httpStatus) {
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
