package com.acldigital.unaito.service.user.exception;

public class UserInActiveException extends RuntimeException {

	private static final long serialVersionUID = 1512878638599437217L;

	private final String message;
	private final Integer httpStatus;

	public UserInActiveException(String message, Integer httpStatus) {
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
