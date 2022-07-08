package com.acldigital.unaito.service.user.exception;

public class UnaitoSQLException extends RuntimeException {

	private static final long serialVersionUID = 7647807721948815757L;

	private final String message;
	private final Integer httpStatus;

	public UnaitoSQLException(String message, Integer httpStatus) {
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
