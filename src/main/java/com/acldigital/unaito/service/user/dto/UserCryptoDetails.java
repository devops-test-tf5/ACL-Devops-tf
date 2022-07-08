package com.acldigital.unaito.service.user.dto;

public class UserCryptoDetails {

	private String encodedPassword;
	private String salt;
	private String cryptoAlgoName;

	public UserCryptoDetails() {

	}

	public UserCryptoDetails(String encodedPassword, String salt, String cryptoAlgoName) {
		super();
		this.encodedPassword = encodedPassword;
		this.salt = salt;
		this.cryptoAlgoName = cryptoAlgoName;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCryptoAlgoName() {
		return cryptoAlgoName;
	}

	public void setCryptoAlgoName(String cryptoAlgoName) {
		this.cryptoAlgoName = cryptoAlgoName;
	}

	@Override
	public String toString() {
		return "UserCryptoDetails [encodedPassword=" + encodedPassword + ", salt=" + salt + ", cryptoAlgoName="
				+ cryptoAlgoName + "]";
	}

}
