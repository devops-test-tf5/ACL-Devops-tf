package com.acldigital.unaito.service.events;

import org.springframework.context.ApplicationEvent;

public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 6170738407732398168L;

	public OnRegistrationCompleteEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "Registration complete.";
	}

}
