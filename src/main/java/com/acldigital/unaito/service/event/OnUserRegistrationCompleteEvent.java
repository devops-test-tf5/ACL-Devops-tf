package com.acldigital.unaito.service.event;

import org.springframework.context.ApplicationEvent;

import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;

public class OnUserRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3450627535227313165L;

	private UserRegistrationDetails userRegistrationDetails;
	private Long userId;

	public OnUserRegistrationCompleteEvent(UserRegistrationDetails userRegistrationDetails, Long userId) {
		super(userRegistrationDetails);
		this.userRegistrationDetails = userRegistrationDetails;
		this.userId = userId;
	}

	public UserRegistrationDetails getUserRegistrationDetails() {
		return userRegistrationDetails;
	}

	public void setUserRegistrationDetails(UserRegistrationDetails userRegistrationDetails) {
		this.userRegistrationDetails = userRegistrationDetails;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OnUserRegistrationCompleteEvent [userRegistrationDetails=" + userRegistrationDetails + ", userId="
				+ userId + "]";
	}

}
