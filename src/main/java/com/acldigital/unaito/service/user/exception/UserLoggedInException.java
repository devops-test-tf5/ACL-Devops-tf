package com.acldigital.unaito.service.user.exception;

public class UserLoggedInException extends RuntimeException {

	private static final long serialVersionUID = 7672533503991331808L;

	private final String message;
	private final Integer httpStatus;

	public UserLoggedInException(String message, Integer httpStatus) {
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
