package com.acldigital.unaito.service.user.dto;

public class ApplicationLayerResponse {

	private Integer code;
	private Object responObject;

	public ApplicationLayerResponse() {

	}

	public ApplicationLayerResponse(Integer code, Object responObject) {
		super();
		this.code = code;
		this.responObject = responObject;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getResponObject() {
		return responObject;
	}

	public void setResponObject(Object responObject) {
		this.responObject = responObject;
	}

	@Override
	public String toString() {
		return "ApplicationLayerResponse [code=" + code + ", responObject=" + responObject + "]";
	}

}
