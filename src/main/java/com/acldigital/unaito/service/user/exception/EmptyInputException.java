package com.acldigital.unaito.service.user.exception;

public class EmptyInputException extends RuntimeException{

	private static final long serialVersionUID = 226665306869370441L;

	private final String message;
	private final Integer httpStatus;

	public EmptyInputException(String message, Integer httpStatus) {
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
