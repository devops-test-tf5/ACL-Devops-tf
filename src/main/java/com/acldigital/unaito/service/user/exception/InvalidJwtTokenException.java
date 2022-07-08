package com.acldigital.unaito.service.user.exception;

public class InvalidJwtTokenException extends RuntimeException{

	private static final long serialVersionUID = 6092059504651918617L;

	private final String message;
	private final Integer httpStatus;

	public InvalidJwtTokenException(String message, Integer httpStatus) {
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
