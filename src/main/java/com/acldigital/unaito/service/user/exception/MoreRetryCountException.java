package com.acldigital.unaito.service.user.exception;

public class MoreRetryCountException extends RuntimeException {

	private static final long serialVersionUID = 5737446663997710490L;

	private final String message;
	private final Integer httpStatus;

	public MoreRetryCountException(String message, Integer httpStatus) {
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
