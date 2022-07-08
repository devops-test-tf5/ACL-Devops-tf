package com.acldigital.unaito.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.user.constants.ConfigProperties;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.exception.UnaitoSecurityException;

@Component
public class SecurityUtils {

	@Autowired
	private ConfigProperties configProperties;

	public void validateApiKey(String apiKey) {
		if (!apiKey.equals(configProperties.getUserApiKey())) {
			throw new UnaitoSecurityException(UserConstants.INVALID_API_KEY, HttpStatus.BAD_REQUEST.value());
		}
	}

	public void validateCustomerApiKey(String apiKey) {
		if (!apiKey.equals(configProperties.getCustomerApiKey())) {
			throw new UnaitoSecurityException(UserConstants.INVALID_API_KEY, HttpStatus.BAD_REQUEST.value());
		}
	}

	public void validateProjectApiKey(String apiKey) {
		if (!apiKey.equals(configProperties.getProjectApiKey())) {
			throw new UnaitoSecurityException(UserConstants.INVALID_API_KEY, HttpStatus.BAD_REQUEST.value());
		}
	}

}
