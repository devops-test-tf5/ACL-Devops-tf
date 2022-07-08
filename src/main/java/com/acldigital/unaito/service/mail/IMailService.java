package com.acldigital.unaito.service.mail;

import java.util.Map;

import com.acldigital.unaito.service.security.constants.CommunicationTemplateTypeEnum;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;

public interface IMailService {

	public void sendVerificationLinkAsEmail(String fromEmail, String toEmail, String subject, String text)
			throws Exception;

	public void sendNewPassword(String to, String subject, String text);

	public Map<String, Object> loadEmailServerConfigProperties();

	CommunicationTemplateDetails getEmailTemplateDetails(CommunicationTemplateTypeEnum commType);
}
