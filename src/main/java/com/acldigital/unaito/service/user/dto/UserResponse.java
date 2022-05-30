package com.acldigital.unaito.service.user.dto;

public class UserResponse {

	private Integer responseCode;
	private Object responseObject;

	public UserResponse() {

	}

	public UserResponse(Integer responseCode, Object responseObject) {
		super();
		this.responseObject = responseObject;
		this.responseCode = responseCode;
		// get the code value corresponding to each errorCode and set in responseCode
		// responseCode.stream().map(errorCode->this.responseCode.add(errorCode.getValue())).collect(Collectors.toList());
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
		return "UserResponse [responseCode=" + responseCode + ", responseObject=" + responseObject + "]";
	}

}
