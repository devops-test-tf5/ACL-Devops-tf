package com.acldigital.unaito.service.user.exception;

public class JWTExpiredException extends RuntimeException {

	private static final long serialVersionUID = 8839538033298685377L;

	private final String message;
	private final Integer httpStatus;

	public JWTExpiredException(String message, Integer httpStatus) {
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
