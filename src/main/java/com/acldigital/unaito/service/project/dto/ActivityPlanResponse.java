package com.acldigital.unaito.service.project.dto;

public class ActivityPlanResponse {

	private Integer code;
	private Object responseObject;

	public ActivityPlanResponse() {

	}

	public ActivityPlanResponse(Integer code, Object responseObject) {
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
		return "ActivityPlanResponse [code=" + code + ", responseObject=" + responseObject + "]";
	}

}
