package com.acldigital.unaito.service.user.exception;

public class UsersNotMatchingException extends RuntimeException {

	private static final long serialVersionUID = 2804287055728723599L;

	private final String message;
	private final Integer httpStatus;

	public UsersNotMatchingException(String message, Integer httpStatus) {
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
