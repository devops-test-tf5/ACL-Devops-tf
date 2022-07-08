package com.acldigital.unaito.service.user.exception;

public class CommunicationTemplateNotDefinedException extends RuntimeException {

	private static final long serialVersionUID = 5874662916609546717L;

	private final String message;
	private final Integer httpStatus;

	public CommunicationTemplateNotDefinedException(String message, Integer httpStatus) {
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
