package com.acldigital.unaito.service.user.exception;

public class InvalidOrExpiredVerificationLinkException extends RuntimeException {

	private static final long serialVersionUID = 5858461937620593156L;

	private final String message;
	private final Integer httpStatus;

	public InvalidOrExpiredVerificationLinkException(String message, Integer httpStatus) {
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
