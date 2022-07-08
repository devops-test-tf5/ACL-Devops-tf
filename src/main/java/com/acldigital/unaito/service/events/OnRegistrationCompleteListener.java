package com.acldigital.unaito.service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.event.OnUserRegistrationCompleteEvent;
import com.acldigital.unaito.service.service.IUserEmailVerificationService;

@Component
public class OnRegistrationCompleteListener implements ApplicationListener<OnUserRegistrationCompleteEvent> {

	@Autowired
	private IUserEmailVerificationService emailVerificationService;

	@Override
	public void onApplicationEvent(OnUserRegistrationCompleteEvent event) {
		emailVerificationService.generateUserVerificationEmail(event.getUserId(),
				event.getUserRegistrationDetails().getUserName(), event.getUserRegistrationDetails().getEmail());
		
	}
}
