package com.acldigital.unaito.service.user.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties {

	@Value("${user.service.security.jwt.secret.key}")
	private String userServiceSecretKey;

	@Value("${spring.application.name}")
	private String serviceName;

	@Value("${user.service.security.jwt.audiance}")
	private String jwtAudience;

	@Value("${user.service.api-key}")
	private String userApiKey;

	@Value("${customer.service.api-key}")
	private String customerApiKey;
	
	@Value("${project.service.api-key}")
	private String projectApiKey;

	public String getUserServiceSecretKey() {
		return userServiceSecretKey;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getJwtAudience() {
		return jwtAudience;
	}

	public String getUserApiKey() {
		return userApiKey;
	}

	public String getCustomerApiKey() {
		return customerApiKey;
	}

	public String getProjectApiKey() {
		return projectApiKey;
	}
}
