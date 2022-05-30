package com.acldigital.unaito.service.user.exception;

public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 9152266913735218849L;

	private final String message;
	private final Integer httpStatus;

	public InvalidUserException(String message, Integer httpStatus) {
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
