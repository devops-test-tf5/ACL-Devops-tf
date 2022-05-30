package com.acldigital.unaito.service.user.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 8116312928066385889L;
	private final String message;
	private final Integer httpStatus;

	public UserException(String message, Integer httpStatus) {
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