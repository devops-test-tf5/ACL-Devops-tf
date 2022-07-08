package com.acldigital.unaito.service.user.exception;

public class TokenMissingException extends RuntimeException {

	private static final long serialVersionUID = 184727107682882421L;

	private final String message;
	private final Integer httpStatus;

	public TokenMissingException(String message, Integer httpStatus) {
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
