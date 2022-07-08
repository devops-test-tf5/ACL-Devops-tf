package com.acldigital.unaito.service.user.dto;

import java.time.Instant;

public class UserEmailVerification {

	private Long verificationId;
	private Long userId;
	private Long communicationTemplateId;
	private Long statusId;
	private String sentFrom;
	private String sentTo;
	private String verificationCode;
	private String verificationUrl;
	private Instant verificationUrlExpiry;
	private Integer retryCount;
	private Instant verificationUrlSent;
	private Instant verifiedTime;

	public UserEmailVerification() {

	}

	public UserEmailVerification(Long userId, Long communicationTemplateId, Long statusId, String sentFrom,
			String sentTo, String verificationCode, String verificationUrl, Instant verificationUrlExpiry,
			Integer retryCount, Instant verificationUrlSent) {
		super();
		this.userId = userId;
		this.communicationTemplateId = communicationTemplateId;
		this.statusId = statusId;
		this.sentFrom = sentFrom;
		this.sentTo = sentTo;
		this.verificationCode = verificationCode;
		this.verificationUrl = verificationUrl;
		this.verificationUrlExpiry = verificationUrlExpiry;
		this.retryCount = retryCount;
		this.verificationUrlSent = verificationUrlSent;
	}

	public UserEmailVerification(Long userId, String sentFrom, String sentTo, String verificationUrl) {
		super();
		this.userId = userId;
		this.sentFrom = sentFrom;
		this.sentTo = sentTo;
		this.verificationUrl = verificationUrl;
	}

	public Long getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(Long verificationId) {
		this.verificationId = verificationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCommunicationTemplateId() {
		return communicationTemplateId;
	}

	public void setCommunicationTemplateId(Long communicationTemplateId) {
		this.communicationTemplateId = communicationTemplateId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getSentFrom() {
		return sentFrom;
	}

	public void setSentFrom(String sentFrom) {
		this.sentFrom = sentFrom;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getVerificationUrl() {
		return verificationUrl;
	}

	public void setVerificationUrl(String verificationUrl) {
		this.verificationUrl = verificationUrl;
	}

	public Instant getVerificationUrlExpiry() {
		return verificationUrlExpiry;
	}

	public void setVerificationUrlExpiry(Instant verificationUrlExpiry) {
		this.verificationUrlExpiry = verificationUrlExpiry;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	public Instant getVerificationUrlSent() {
		return verificationUrlSent;
	}

	public void setVerificationUrlSent(Instant verificationUrlSent) {
		this.verificationUrlSent = verificationUrlSent;
	}

	public Instant getVerifiedTime() {
		return verifiedTime;
	}

	public void setVerifiedTime(Instant verifiedTime) {
		this.verifiedTime = verifiedTime;
	}

	@Override
	public String toString() {
		return "UserEmailVerification [verificationId=" + verificationId + ", userId=" + userId
				+ ", communicationTemplateId=" + communicationTemplateId + ", statusId=" + statusId + ", sentFrom="
				+ sentFrom + ", sentTo=" + sentTo + ", verificationCode=" + verificationCode + ", verificationUrl="
				+ verificationUrl + ", verificationUrlExpiry=" + verificationUrlExpiry + ", retryCount=" + retryCount
				+ ", verificationUrlSent=" + verificationUrlSent + ", verifiedTime=" + verifiedTime + "]";
	}

}
