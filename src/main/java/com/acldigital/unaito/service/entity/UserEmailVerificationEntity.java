package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_email_verification")
public class UserEmailVerificationEntity implements Serializable {

	private static final long serialVersionUID = 8749385749342929443L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "verification_id")
	private Long verificationId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "comm_template_id")
	private Long communicationTemplateId;

	@Column(name = "status_id")
	private Long statusId;

	@Column(name = "sent_from_email_address")
	private String sentFrom;

	@Column(name = "sent_to_email_address")
	private String sentTo;

	@Column(name = "verification_code")
	private String verificationCode;

	@Column(name = "verification_url")
	private String verificationUrl;

	@Column(name = "verification_url_expiry")
	private Instant verificationUrlExpiry;

	@Column(name = "retry_count")
	private Integer retryCount;

	@Column(name = "verification_url_sent")
	private Instant verificationUrlSent;

	@Column(name = "verified_time")
	private Instant verifiedTime;

	public UserEmailVerificationEntity() {

	}

	public UserEmailVerificationEntity(Long userId, Long communicationTemplateId, Long statusId, String sentFrom,
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
		return "UserEmailVerificationEntity [verificationId=" + verificationId + ", userId=" + userId
				+ ", communicationTemplateId=" + communicationTemplateId + ", statusId=" + statusId + ", sentFrom="
				+ sentFrom + ", sentTo=" + sentTo + ", verificationCode=" + verificationCode + ", verificationUrl="
				+ verificationUrl + ", verificationUrlExpiry=" + verificationUrlExpiry + ", retryCount=" + retryCount
				+ ", verificationUrlSent=" + verificationUrlSent + ", verifiedTime=" + verifiedTime + "]";
	}

}
