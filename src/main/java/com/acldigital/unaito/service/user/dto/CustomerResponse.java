package com.acldigital.unaito.service.user.dto;

public class CustomerResponse {

	private Integer responseCode;
	private Object responseObject;

	public CustomerResponse() {

	}

	public CustomerResponse(Integer responseCode, Object responseObject) {
		super();
		this.responseCode = responseCode;
		this.responseObject = responseObject;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	@Override
	public String toString() {
		return "CustomerResponse [responseCode=" + responseCode + ", responseObject=" + responseObject + "]";
	}

}
