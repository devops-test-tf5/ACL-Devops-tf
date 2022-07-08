package com.acldigital.unaito.service.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.acldigital.unaito.service.user.constants.PasswordEncoderNames;

public class EncoderFactory {

	private static Map<PasswordEncoderNames, PasswordEncoder> encoders = new HashMap<>();

	static {
		encoders.put(PasswordEncoderNames.BCRYPT, new BCryptPasswordEncoder());
		/* encoders.put(PasswordEncoderNames.SCRYPT, new SCryptPasswordEncoder()); */
	}

	public static PasswordEncoder getPasswordEncoder(PasswordEncoderNames encoderName) {
		return encoders.get(encoderName);
	}

	public static Set<PasswordEncoderNames> getAvailableEncoderNames() {
		return encoders.keySet();
	}
}
