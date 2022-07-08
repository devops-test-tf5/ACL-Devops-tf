package com.acldigital.unaito.service.user.exception;

public class CustomerCreationException extends RuntimeException {

	private static final long serialVersionUID = 2556660579540241471L;

	private final String message;
	private final Integer httpStatus;

	public CustomerCreationException(String message, Integer httpStatus) {
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
