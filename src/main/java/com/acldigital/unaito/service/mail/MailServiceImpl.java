package com.acldigital.unaito.service.mail;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.IUserEmailVerificationDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.entity.CommunicationTemplateMasterEntity;
import com.acldigital.unaito.service.entity.EmailServerConfigEntity;
import com.acldigital.unaito.service.repository.ICommunicationTemplateMasterRepository;
import com.acldigital.unaito.service.repository.IEmailServerConfigRepository;
import com.acldigital.unaito.service.repository.IUserEmailVerificationRepository;
import com.acldigital.unaito.service.security.constants.CommunicationTemplateTypeEnum;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;
import com.acldigital.unaito.service.utils.UserUtils;

@Service
public class MailServiceImpl implements IMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private IEmailServerConfigRepository emailServerConfigRepository;

	@Autowired
	private IUserEmailVerificationRepository userEmailVerificationRepository;

	@Autowired
	private ICommunicationTemplateMasterRepository communicationTemplateMasterRepository;

	@Autowired
	private MapperUtils mapperUtils;

	@Autowired
	private UserUtils userUtils;

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Autowired
	private IUserEmailVerificationDataService emailVerificationDataService;

	@Override
	public void sendNewPassword(String to, String subject, String text) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(fromEmail);
			message.setTo(to);
			message.setSubject(subject);
			message.setText("Login password : " + text);
			javaMailSender.send(message);
		} catch (MailException me) {
			System.out.println(me);
		}
	}

	@Override
	public Map<String, Object> loadEmailServerConfigProperties() {
		List<EmailServerConfigEntity> configEntities = emailServerConfigRepository.findAll();
		Map<String, Object> propertySource = configEntities.stream().collect(
				Collectors.toMap(EmailServerConfigEntity::getConfigName, EmailServerConfigEntity::getConfigValue));
		return propertySource;
	}

	@Override
	public CommunicationTemplateDetails getEmailTemplateDetails(CommunicationTemplateTypeEnum commType) {
		CommunicationTemplateMasterEntity entity = communicationTemplateMasterRepository
				.findByCommunicationTemplateType(commType.getValue());
		CommunicationTemplateDetails emailTemplate = null;
		if (!ObjectUtils.isEmpty(entity)) {
			return mapperUtils.convertToCommunicationTemplateDetails(entity);
		}
		return emailTemplate;
	}

	private String getVerificationCode() {
		return userUtils.generateNewPassword(64);
	}

	@Override
	public void sendVerificationLinkAsEmail(String fromEmail, String toEmail, String subject, String text)
			throws Exception {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(fromEmail);
			message.setTo(toEmail);
			message.setSubject(subject);
			message.setText("Click on the below link to activate your user account with Unaito: " + text);
			javaMailSender.send(message);
		} catch (MailException me) {
			System.out.println(me);
		}
	}

}
