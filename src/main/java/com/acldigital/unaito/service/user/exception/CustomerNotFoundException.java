package com.acldigital.unaito.service.user.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 273772294538307419L;

	private final String message;
	private final Integer httpStatus;

	public CustomerNotFoundException(String message, Integer httpStatus) {
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
