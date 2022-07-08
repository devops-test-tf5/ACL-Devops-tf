package com.acldigital.unaito.service.user.dto;

public class ResourcePlanResponse {

	private Integer code;
	private Object responseObject;

	public ResourcePlanResponse() {

	}

	public ResourcePlanResponse(Integer code, Object responseObject) {
		super();
		this.code = code;
		this.responseObject = responseObject;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	@Override
	public String toString() {
		return "ResourcePlanResponse [code=" + code + ", responseObject=" + responseObject + "]";
	}

}
