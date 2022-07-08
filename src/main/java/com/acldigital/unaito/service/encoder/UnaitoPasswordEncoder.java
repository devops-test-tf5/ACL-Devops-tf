package com.acldigital.unaito.service.encoder;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.service.EncoderFactory;
import com.acldigital.unaito.service.user.constants.PasswordEncoderNames;

@Component
public class UnaitoPasswordEncoder {

	private PasswordEncoderNames encoder;
	private String encodedPassword;
	private String salt;

	public String encoderPassword(String password) {

		Set<PasswordEncoderNames> encoderNames = EncoderFactory.getAvailableEncoderNames();

		// pick up a encoder randomly from this list
		Random rand = new Random();
		int randNum = rand.nextInt(encoderNames.size());
		encoder = (PasswordEncoderNames) encoderNames.toArray()[randNum];

		// generate a salt for this user
		String uuid = UUID.randomUUID().toString();
		salt = uuid.substring(uuid.lastIndexOf('-') + 1, uuid.length());

		// encode password using this encoder and salt
		PasswordEncoder randomEncoder = EncoderFactory.getPasswordEncoder(encoder);
		this.encodedPassword = randomEncoder.encode(password + salt);
		return this.encodedPassword;
	}

	public PasswordEncoderNames getEncoder() {
		return encoder;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public String getSalt() {
		return salt;
	}

	public static boolean validatePassword(String salt, String cryptoAlgoName, String encodedPassword,
			String userPassword) {
		PasswordEncoderNames passwordEncoderNames = PasswordEncoderNames.getForValue(cryptoAlgoName);
		PasswordEncoder randomEncoder = EncoderFactory.getPasswordEncoder(passwordEncoderNames);
		return randomEncoder.matches(userPassword + salt, encodedPassword);
	}
}
