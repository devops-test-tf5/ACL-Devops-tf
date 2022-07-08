package com.acldigital.unaito.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acldigital.unaito.db.IUserEmailVerificationDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.entity.UserEmailVerificationEntity;
import com.acldigital.unaito.service.repository.IUserEmailVerificationRepository;
import com.acldigital.unaito.service.user.constants.StatusEnum;
import com.acldigital.unaito.service.user.dto.UserEmailVerification;

@Service
public class EmailVerificationDataServiceImpl implements IUserEmailVerificationDataService {

	@Autowired
	private MapperUtils mapperUtils;

	@Autowired
	private IUserEmailVerificationRepository emailVerificationRepository;

	@Override
	public void saveEmailVerificationRecord(UserEmailVerification userEmailVerification) {
		UserEmailVerificationEntity entity = mapperUtils.convertToUserEmailVerificationEntity(userEmailVerification);
		emailVerificationRepository.save(entity);
	}

	@Override
	public UserEmailVerification retrieveActivationEmailsToSend(Long userId, String email, Long statusId) {
		UserEmailVerificationEntity entity = emailVerificationRepository.fetchVerificationDetails(userId, email,
				statusId);
		return mapperUtils.convertToUserEmailVerification(entity);
	}

	@Override
	public int verifyCode(Long userId, String verifyCode) {
		return emailVerificationRepository.activateAccount(Long.valueOf(StatusEnum.VERIFIED.getValue()), userId,
				verifyCode);
	}

}
