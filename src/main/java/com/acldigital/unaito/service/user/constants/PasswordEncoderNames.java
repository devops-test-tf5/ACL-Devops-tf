package com.acldigital.unaito.service.user.constants;

import java.util.HashMap;
import java.util.Map;

public enum PasswordEncoderNames {

	BCRYPT("BCRYPT");

	private String value;

	private PasswordEncoderNames(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	private static final Map<String, PasswordEncoderNames> map = new HashMap<>();
	static {
		// populating the map
		for (PasswordEncoderNames e : values()) {
			map.put(e.getValue(), e);
		}
	}

	public static PasswordEncoderNames getForValue(String s) {
		return map.get(s);
	}
}
