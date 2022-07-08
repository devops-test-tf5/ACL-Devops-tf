package com.acldigital.unaito.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acldigital.unaito.db.ICommunicationTemplateDataService;
import com.acldigital.unaito.db.IUserEmailVerificationDataService;
import com.acldigital.unaito.service.mail.IMailService;
import com.acldigital.unaito.service.security.constants.CommunicationTemplateTypeEnum;
import com.acldigital.unaito.service.service.IUserEmailVerificationService;
import com.acldigital.unaito.service.user.constants.StatusEnum;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;
import com.acldigital.unaito.service.user.dto.UserEmailVerification;
import com.acldigital.unaito.service.user.exception.EmailTemplateNotAvailableException;

@Service
public class UserEmailVerificationServiceImpl implements IUserEmailVerificationService {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private ICommunicationTemplateDataService communicationTemplateDataService;

	@Value("${spring.mail.username}")
	private String sentFrom;

	@Value("${email.verificationhost}")
	private String emailVerifyHostName;

	@Autowired
	private IUserEmailVerificationDataService emailVerificationDataService;

	@Autowired
	private IMailService mailService;

	private String generateVerificationCode() {
		return UUID.randomUUID().toString();
	}

	private String prepareEmailVerificationLink(Long userId) {
		/*
		 * String host = null; int port = request.getLocalPort(); try { host =
		 * InetAddress.getByName(emailVerifyHostName).getHostAddress(); } catch
		 * (UnknownHostException uhe) { uhe.printStackTrace(); }
		 */
		return "http://localhost:8080" + "/unaito/v1/users/email-verify/userId/" + userId + "/verifyId/";
		// return "http://" + host + ":" + port + "/unaito/v1/users/email-verify/userId"
		// + userId + "/verify/";
	}

	@Override
	public void generateUserVerificationEmail(Long userId, String userName, String email) {
		String verificationLink = prepareEmailVerificationLink(userId);
		String verificationCode = generateVerificationCode();
		UserEmailVerification userEmailVerification = null;

		Instant verificationUrlSentTime = Instant.now();
		Instant createdDate = Instant.now();
		Instant expiryTime = verificationUrlSentTime.plus(1, ChronoUnit.HOURS);

		CommunicationTemplateDetails communicationTemplateDetails = communicationTemplateDataService
				.getEmailTemplateDetails(CommunicationTemplateTypeEnum.EMAIL_VERIFICATION_TEMPLATE);
		if (!ObjectUtils.isEmpty(communicationTemplateDetails)) {

			userEmailVerification = new UserEmailVerification(userId,
					communicationTemplateDetails.getCommunicationTemplateId(), Long.valueOf(StatusEnum.NEW.getValue()),
					sentFrom, email, verificationCode, verificationLink + verificationCode, expiryTime, 1,
					verificationUrlSentTime);
			emailVerificationDataService.saveEmailVerificationRecord(userEmailVerification);
			sendAccountActivationEmail(userEmailVerification.getUserId(), userEmailVerification.getSentFrom(),
					userEmailVerification.getSentTo(), userEmailVerification.getStatusId());
		} else {
			throw new EmailTemplateNotAvailableException("No email template", HttpStatus.NOT_FOUND.value());
		}
	}

	private void sendAccountActivationEmail(Long userId, String fromEmail, String toEmail, Long statusId) {
		UserEmailVerification emailVerification = emailVerificationDataService.retrieveActivationEmailsToSend(userId,
				toEmail, statusId);
		String subject = "Unaito account activation email.";
		try {
		mailService.sendVerificationLinkAsEmail(emailVerification.getSentFrom(), emailVerification.getSentTo(), subject,
				emailVerification.getVerificationUrl());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
