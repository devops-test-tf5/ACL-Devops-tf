package com.acldigital.unaito.service.service;

public interface IUserEmailVerificationService {

	public void generateUserVerificationEmail(Long userId, String userName, String email);
}
