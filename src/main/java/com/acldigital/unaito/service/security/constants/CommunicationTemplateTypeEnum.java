package com.acldigital.unaito.service.security.constants;

public enum CommunicationTemplateTypeEnum {

	EMAIL_VERIFICATION_TEMPLATE("EMAIL_VERIFICATION"),
	VERIFICATION_RESPONSE("VERIFICATION_RESPONSE");

	private final String value;

	private CommunicationTemplateTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
