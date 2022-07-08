package com.acldigital.unaito.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.service.UnaitoUserDetailsService;
import com.acldigital.unaito.service.user.constants.HttpConstantsEnum;
import com.acldigital.unaito.service.user.exception.UnaitoSecurityException;

@Component
public class CommonUtils {

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UnaitoUserDetailsService detailsService;

	public static String resolveToken(String jwtToken) throws UnaitoSecurityException {
		if (jwtToken != null && jwtToken.startsWith(HttpConstantsEnum.HEADER_BEARER.getValue() + " ")) {
			return jwtToken.substring(7);
		} else {
			throw new UnaitoSecurityException("Invalid JWT Token", HttpStatus.FORBIDDEN.value());
		}
	}

	public boolean validateToken(String jwtToken) {
		String userName = jwtUtils.extractUsername(jwtToken);
		return jwtUtils.validateToken(jwtToken, detailsService.loadUserByUsername(userName));
	}
}
