package com.acldigital.unaito.service.user.exception;

public class UnaitoSecurityException extends RuntimeException {

	private static final long serialVersionUID = 4060613313558294693L;

	private final String message;
	private final Integer httpStatus;

	public UnaitoSecurityException(String message, Integer httpStatus) {
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
