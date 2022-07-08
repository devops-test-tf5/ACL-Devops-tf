package com.acldigital.unaito.service.user.exception;

public class TokenExpiredException extends RuntimeException {

	private static final long serialVersionUID = 6636276865191434027L;

	private final String message;
	private final Integer httpStatus;

	public TokenExpiredException(String message, Integer httpStatus) {
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
