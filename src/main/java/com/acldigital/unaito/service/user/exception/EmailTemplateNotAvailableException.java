package com.acldigital.unaito.service.user.exception;

public class EmailTemplateNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 6859287956091076959L;

	private final String message;
	private final Integer httpStatus;

	public EmailTemplateNotAvailableException(String message, Integer httpStatus) {
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
