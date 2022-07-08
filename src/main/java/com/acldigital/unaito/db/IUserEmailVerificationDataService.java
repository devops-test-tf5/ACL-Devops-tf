package com.acldigital.unaito.db;

import com.acldigital.unaito.service.user.dto.UserEmailVerification;

public interface IUserEmailVerificationDataService {

	public void saveEmailVerificationRecord(UserEmailVerification userEmailVerification);

	public UserEmailVerification retrieveActivationEmailsToSend(Long userId, String email,
			Long statusId);
	
	public int verifyCode(Long userId,String verifyCode);
}
